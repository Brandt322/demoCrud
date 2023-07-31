package com.example.demoCrud.Dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AuthorDto {
    private Long id;
    private String name;
    private String lastname;
    private int age;
    private String country;
}
