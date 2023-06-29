package com.example.demoCrud.service;

import com.example.demoCrud.model.Book;

public interface BookService {
    //Create books
    Book newBook(Book newBook);

    //Read books
    Iterable<Book> getAll();

    //Edit books
    Book editBook(Book book);

    //Delete books
    Boolean deleteBook(Long id);
}
