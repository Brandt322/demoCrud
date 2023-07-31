package com.example.demoCrud.controller;

import com.example.demoCrud.Dto.AuthorDto;
import com.example.demoCrud.model.Author;
import com.example.demoCrud.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    private AuthorDto mapAuthorToDTO(Author author) {
        AuthorDto dto = new AuthorDto();
        dto.setId(author.getId());
        dto.setName(author.getName());
        dto.setLastname(author.getLastname());
        dto.setAge(author.getAge());
        dto.setCountry(author.getCountry());
        return dto;
    }

    private List<AuthorDto> mapAuthorsToDTOs(Iterable<Author> authors) {
        List<AuthorDto> dtos = new ArrayList<>();
        for (Author author : authors) {
            dtos.add(mapAuthorToDTO(author));
        }
        return dtos;
    }

    @PostMapping("/newAuthor")
    public AuthorDto newAuthor(@RequestBody Author newAuthor) {
        Author savedAuthor = this.authorService.newAuthor(newAuthor);
        return mapAuthorToDTO(savedAuthor);
    }

    @GetMapping("/showAuthors")
    public Iterable<AuthorDto> getAll() {
        Iterable<Author> showAuthor = authorService.getAll();
        return mapAuthorsToDTOs(showAuthor);
    }

    @PostMapping("/updateAuthor")
    public AuthorDto updateAuthor(@RequestBody Author author) {
        Author updatedAuthor = this.authorService.editAuthor(author);
        return mapAuthorToDTO(updatedAuthor);
    }

    @PostMapping(value = "/delete/{id}")
    public Boolean deleteAuthor(@PathVariable(value = "id") Long id) {
        return this.authorService.deleteAuthor(id);
    }

}
