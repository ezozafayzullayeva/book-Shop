package com.example.book_shop.book.entity;

import com.example.book_shop.cart.entity.Cart;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "`book`")
public class Book {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    @Column(unique = true, nullable = false)
    private String name;
    private String author;
//    private Double price;                     //narxi
    private String price;                      //narxi
//    private BookCover cover;                //yumshoq qattiqligi
    private String cover;                    //yumshoq qattiqligi
    private String publisher;               //nashri
    private String pages;              //sahifalar soni
    private String yearOfPublication;

    @OneToMany(mappedBy = "book")
    private List<Cart> carts = new ArrayList<>();


    public Book(String name, String author, String price, String cover, String publisher, String pages, String yearOfPublication) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.cover = cover;
        this.publisher = publisher;
        this.pages = pages;
        this.yearOfPublication = yearOfPublication;
    }
}
