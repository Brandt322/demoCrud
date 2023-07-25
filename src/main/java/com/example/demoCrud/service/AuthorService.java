package com.example.demoCrud.service;

import com.example.demoCrud.model.Author;

public interface AuthorService {
    //Create authors
    Author newAuthor(Author newAuthor);

    //Read authors
    Iterable<Author> getAll();

    //Edit authors
    Author editAuthor(Author author);

    //Delete author
    Boolean deleteAuthor(Long id);
}
