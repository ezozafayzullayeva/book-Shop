package com.example.book_shop.book;

import com.example.book_shop.book.dto.BookCreateDto;
import com.example.book_shop.book.entity.Book;
import com.example.book_shop.cart.CartService;
import com.example.book_shop.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;
    private final BookRepository bookRepository;
    private final UserRepository userRepository;
    private final CartService cartService;

    @GetMapping
    public String getAll(Model model){
        List<Book> books = bookService.getAll();
        model.addAttribute("books", books);
        return "book/books";
    }

    @PostMapping
    public String create(@ModelAttribute BookCreateDto createDto){
        bookService.create(createDto);
        return "redirect:/books";
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable UUID id) {
        bookService.delete(id);
        return "redirect:/books";
    }
//    @PostMapping("books/addToCart/{bookId}")
//    public String addToCart(@PathVariable UUID bookId, Principal principal) {
//        Book book = bookRepository.findById(bookId).orElse(null);
//        if (book != null) {
//            cartService.addToCart(book.getId());
//        }
//        return "redirect:/";
//    }




    @GetMapping("/add-book")
    public String addBookPage() {
        return "book/add-book";
    }
//    @GetMapping("/add-book")
//    public String showAddBookForm() {
//        // Kodlar
//        return "book/add-book";
//    }
//
//    @PostMapping("/add-book")
//    public String addBook(@ModelAttribute Book book) {
//        // Kodlar
//        return "redirect:/books";
//    }

//    @GetMapping("/search")
//    public String findBookByName(Model model, @Param("keyword") String keyword){
//        model.addAttribute("books", bookService.findBookByName(keyword));
//        return "book/books";
//    }
}
