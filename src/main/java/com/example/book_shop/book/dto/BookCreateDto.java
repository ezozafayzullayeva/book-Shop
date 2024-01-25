package com.example.book_shop.book.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookCreateDto {
    private String name;
    private String author;
    private String price;
    private String cover;
    private String publisher;
    private String pages;
    private String yearOfPublication;
}
