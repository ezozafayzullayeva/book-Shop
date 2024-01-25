package com.example.book_shop.cart;

import com.example.book_shop.book.entity.Book;
import com.example.book_shop.cart.entity.Cart;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.UUID;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
//    List<Book> getBooks(UUID userId);
}
