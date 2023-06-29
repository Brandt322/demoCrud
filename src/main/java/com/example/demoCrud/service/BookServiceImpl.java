package com.example.demoCrud.service;

import com.example.demoCrud.model.Book;
import com.example.demoCrud.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class BookServiceImpl implements BookService{
    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book newBook(Book newBook) {
        return bookRepository.save(newBook);
    }

    @Override
    public Iterable<Book> getAll() {
        return this.bookRepository.findAll();
    }

    @Override
    public Book editBook(Book book) {
        Optional<Book> bookToEdit= this.bookRepository.findById(book.getId());
        if(bookToEdit.get() != null) {
            bookToEdit.get().setAuthor(book.getAuthor());
            bookToEdit.get().setIsbn(book.getIsbn());
            bookToEdit.get().setTitle(book.getTitle());
            bookToEdit.get().setLanguage(book.getLanguage());
            bookToEdit.get().setYearPublication(book.getYearPublication());
            return this.newBook(bookToEdit.get());
        }
        return null;
    }

    @Override
    public Boolean deleteBook(Long id) {
        this.bookRepository.deleteById(id);
        return true;
    }
}