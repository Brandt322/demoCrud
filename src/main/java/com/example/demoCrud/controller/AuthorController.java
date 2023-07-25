package com.example.demoCrud.controller;

import com.example.demoCrud.model.Author;
import com.example.demoCrud.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @PostMapping("/newAuthor")
    public Author newAuthor(@RequestBody Author newAuthor) {
        return this.authorService.newAuthor(newAuthor);
    }

    @GetMapping("/showAuthors")
    public Iterable<Author> getAll() {
        return authorService.getAll();
    }

    @PostMapping("/updateAuthor")
    public Author updateAuthor(@RequestBody Author author) {
        return authorService.editAuthor(author);
    }

    @PostMapping(value = "/delete/{id}")
    public Boolean deleteAuthor(@PathVariable(value = "id") Long id) {
        return this.authorService.deleteAuthor(id);
    }
}
