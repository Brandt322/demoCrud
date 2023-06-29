package com.example.demoCrud.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Book {
    @Id
    @Column
    private Long id;
    @Column
    private String title;
    @Column
    private String author;
    @Column
    private String isbn;
    @Column
    private int yearPublication;
}
