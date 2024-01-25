package com.example.book_shop.book;

import com.example.book_shop.book.dto.BookCreateDto;
import com.example.book_shop.book.entity.Book;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    public void create(BookCreateDto createDto) {
        Book book = new Book(createDto.getName(), createDto.getAuthor(), createDto.getPrice(), createDto.getCover(),
                createDto.getPublisher(), createDto.getPages(), createDto.getYearOfPublication());
        book.setId(UUID.randomUUID());
        bookRepository.save(book);
    }

    public List<Book> findBookByName(String keyword) {
        return bookRepository.findByName(keyword);
    }

    public void delete(UUID id) {
        if (!(bookRepository.existsById(id))) {
            throw new EntityNotFoundException();
        }
        bookRepository.deleteById(id);
    }




//    public List<Book> getALl() {
//        return bookRepository.findAll();
//    }
//
//    public Optional<Book> findById(UUID id) {
//        return bookRepository.findById(id);
//    }
//
//    public Book findByName(String name) {
//        var book = bookRepository.findByName(name);
//        return book.orElse(null);
//    }
}
