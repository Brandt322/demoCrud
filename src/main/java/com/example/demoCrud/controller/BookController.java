package com.example.demoCrud.controller;

import com.example.demoCrud.model.Book;
import com.example.demoCrud.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping("/new")
    public Book newBook(@RequestBody Book newBook) {
        return this.bookService.newBook(newBook);
    }

    @GetMapping("/show")
    public Iterable<Book> getAll() {
        return bookService.getAll();
    }

    @PostMapping("/update")
    public Book updateBook(@RequestBody Book book) {
        return this.bookService.editBook(book);
    }

    @PostMapping("/{id}")
    public Boolean deleteBook(@RequestParam Long id) {
        return this.bookService.deleteBook(id);
    }
}
