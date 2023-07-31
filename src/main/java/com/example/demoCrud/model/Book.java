package com.example.demoCrud.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "book")
@Getter
@Setter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String title;


    // Establecer la relación Many-to-One con la clase Author
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "author_id") // Nombre de la columna que contendrá el ID del autor en la tabla "Book"
    private Author author;


    // Establecer la relación Many-to-One con la clase Author
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    @Column(name = "isbn")
    private String isbn;
    @Column(name = "yearPublication")
    private int yearPublication;
    @Column(name = "language")
    private String language;


    /*
    @JsonIgnore // Evita la serialización de la propiedad author al convertir en JSON
    // Establecer la relación Many-to-One con la clase Author
    @ManyToMany
    @JoinTable(name = "book_category",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories = new HashSet<>();*/

    // Método equals

    public Book() {

    }
    public Book(Long id, String title, Author author, Publisher publisher, String isbn, int yearPublication, String language) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.isbn = isbn;
        this.yearPublication = yearPublication;
        this.language = language;
    }
}
