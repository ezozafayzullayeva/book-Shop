package com.example.book_shop.cart;

import com.example.book_shop.book.entity.Book;
import com.example.book_shop.cart.entity.Cart;
import com.example.book_shop.user.UserRepository;
import com.example.book_shop.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CartService {
    private final CartRepository cartRepository;
    private final UserRepository userRepository;


    public List<Cart> getCarts(UUID userId) {
        User user = userRepository.findById(userId).orElseThrow();
        return user.getCarts();
    }
//    public void addToCart(User user, Book book) {
//        Cart cart = new Cart(user, book, LocalDateTime.now());
//        cartRepository.save(cart);
//    }

//    public List<Book> getBooks(UUID userId) {
//        return cartRepository.getBooks(userId);
//    }

    public void addToCart(UUID id) {
    }
}
