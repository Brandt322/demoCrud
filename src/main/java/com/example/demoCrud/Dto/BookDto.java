package com.example.demoCrud.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookDto {
    private Long id;
    private String title;
    private String isbn;
    private int yearPublication;
    private String language;
    private Long authorId;
    private Long publisherId;
}
