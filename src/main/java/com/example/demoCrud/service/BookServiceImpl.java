package com.example.demoCrud.service;

import com.example.demoCrud.model.Book;
import com.example.demoCrud.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
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
        Optional<Book> bookToEdit = this.bookRepository.findById(book.getId());
        if (bookToEdit.get() != null) {
            Book bookToEditEntity = bookToEdit.get();
            bookToEditEntity.setTitle(book.getTitle());
            bookToEditEntity.setIsbn(book.getIsbn());
            bookToEditEntity.setYearPublication(book.getYearPublication());
            bookToEditEntity.setLanguage(book.getLanguage());

            bookToEditEntity.setAuthor(book.getAuthor());

            bookToEditEntity.setPublisher(book.getPublisher());
            System.out.println("consola:" + book.getPublisher() + "--" + book.getAuthor());
            return this.newBook(bookToEditEntity);
        }
        return null;
    }


    @Override
    public Boolean deleteBook(Long id) {
        this.bookRepository.deleteById(id);
        return true;
    }
}
