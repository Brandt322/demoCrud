package com.example.demoCrud.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Author {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column
    private String name;
    @Column
    private String lastname;
    @Column
    private int age;
    @Column
    private String country;
    // Establecer la relación One-to-Many con la clase Book
    @OneToMany(mappedBy = "author") // "author" debe coincidir con el nombre del atributo en la clase Book que representa al autor
    private List<Book> books;
}
