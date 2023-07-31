package com.example.demoCrud.controller;

import com.example.demoCrud.Dto.BookDto;
import com.example.demoCrud.model.Book;
import com.example.demoCrud.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    private BookDto mapBookToDTO(Book book) {
        BookDto dto = new BookDto();
        dto.setId(book.getId());
        dto.setTitle(book.getTitle());
        dto.setIsbn(book.getIsbn());
        dto.setYearPublication(book.getYearPublication());
        dto.setLanguage(book.getLanguage());

        // Incluir los IDs del autor y el publisher en el DTO
        if (book.getAuthor() != null) {
            dto.setAuthorId(book.getAuthor().getId());
        }

        if (book.getPublisher() != null) {
            dto.setPublisherId(book.getPublisher().getId());
        }

        return dto;
    }

    private List<BookDto> mapBooksToDTOs(Iterable<Book> books) {
        List<BookDto> dtos = new ArrayList<>();
        for (Book book : books) {
            dtos.add(mapBookToDTO(book));
        }
        return dtos;
    }

    @PostMapping("/new")
    public BookDto newBook(@RequestBody Book newBook) {
        Book savedBook = this.bookService.newBook(newBook);
        return mapBookToDTO(savedBook);
    }

    @GetMapping("/show")
    public List<BookDto> getAll() {
        Iterable<Book> books = bookService.getAll();
        return mapBooksToDTOs(books);
    }

    @PostMapping("/update")
    public BookDto updateBook(@RequestBody Book book) {
        Book updatedBook = this.bookService.editBook(book);
        return mapBookToDTO(updatedBook);
    }

    @PostMapping(value = "/delete/{id}")
    public Boolean deleteBook(@PathVariable(value = "id") Long id) {
        return this.bookService.deleteBook(id);
    }

}

