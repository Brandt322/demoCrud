package com.example.demoCrud.repository;

import com.example.demoCrud.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
