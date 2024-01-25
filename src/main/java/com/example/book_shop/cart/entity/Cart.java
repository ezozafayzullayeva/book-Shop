package com.example.book_shop.cart.entity;

import com.example.book_shop.book.entity.Book;
import com.example.book_shop.user.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "`cart`")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private User user;
    @ManyToOne
    private Book book;
    private LocalDateTime timeAddBookToCart;

    public Cart(User user, Book book, LocalDateTime timeAddBookToCart) {
        this.user = user;
        this.book = book;
        this.timeAddBookToCart = timeAddBookToCart;
    }
}
