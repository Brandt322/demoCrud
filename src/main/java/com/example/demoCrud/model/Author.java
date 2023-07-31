package com.example.demoCrud.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Entity
@Table(name = "author")
@Getter
@Setter
public class Author {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "age")
    private int age;

    @Column(name = "country")
    private String country;


    // Establecer la relación One-to-Many con la clase Book
    @OneToMany(mappedBy = "author")
    private List<Book> books;

    public Author() {

    }
    public Author(Long id, String name, String lastname, int age, String country, List<Book> books) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.country = country;
        this.books = books;
    }
}
