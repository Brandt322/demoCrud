package com.example.demoCrud.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Book {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String title;

    @JsonIgnore // Evita la serialización de la propiedad author al convertir en JSON
    // Establecer la relación Many-to-One con la clase Author
    @ManyToOne
    @JoinColumn(name = "author_id") // Nombre de la columna que contendrá el ID del autor en la tabla "Book"
    private Author author;

    @Column
    private String isbn;
    @Column
    private int yearPublication;
    @Column
    private String language;
}
