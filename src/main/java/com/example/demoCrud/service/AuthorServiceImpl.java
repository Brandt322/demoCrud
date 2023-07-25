package com.example.demoCrud.service;

import com.example.demoCrud.model.Author;
import com.example.demoCrud.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public Author newAuthor(Author newAuthor) {
        return authorRepository.save(newAuthor);
    }

    @Override
    public Iterable<Author> getAll() {
        return this.authorRepository.findAll();
    }

    @Override
    public Author editAuthor(Author author) {
        Optional<Author> authorToEdit = this.authorRepository.findById(author.getId());
        if (authorToEdit.get() != null) {
            authorToEdit.get().setName(author.getName());
            authorToEdit.get().setLastname(author.getLastname());
            authorToEdit.get().setAge(author.getAge());
            authorToEdit.get().setCountry(author.getCountry());
            return this.newAuthor(authorToEdit.get());
        }
        return null;
    }

    @Override
    public Boolean deleteAuthor(Long id) {
        this.authorRepository.deleteById(id);
        return true;
    }
}
