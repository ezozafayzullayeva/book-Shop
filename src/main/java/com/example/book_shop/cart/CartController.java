package com.example.book_shop.cart;

import com.example.book_shop.book.entity.Book;
import com.example.book_shop.cart.entity.Cart;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;

    @GetMapping("/{userId}")
    public String getCart(@PathVariable UUID userId, Model model) {
        List<Cart> carts = cartService.getCarts(userId);
        model.addAttribute("carts", carts);
        return "carts";
    }

    @PostMapping("/add")
    public String addToCart(@RequestParam Book book){
        cartService.addToCart(book.getId());
        return "redirect:/";
    }
}
