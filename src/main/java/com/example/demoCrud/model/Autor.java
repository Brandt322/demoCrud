package com.example.demoCrud.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Autor {
    @Id
    @Column
    private Long id;
    @Column
    private String name;
    @Column
    private String lastname;
}