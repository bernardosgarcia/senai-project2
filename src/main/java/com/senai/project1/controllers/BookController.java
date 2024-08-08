package com.senai.project1.controllers;

import com.senai.project1.dtos.BookDTO;
import com.senai.project1.models.BookModel;
import com.senai.project1.services.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/book")
    public ResponseEntity<BookModel> persist(@RequestBody BookDTO bookDTO) {
        return bookService.persist(bookDTO);
    }

    @GetMapping("/book")
    public ResponseEntity<List<BookModel>> getAll() {
        return bookService.getAll();
    }

    @GetMapping("/book/getByTitle/{title}")
    public ResponseEntity<BookModel> getByTitle(@PathVariable String title) {
        return bookService.getByTitle(title);
    }

    @GetMapping("/book/getByAuthor/{author}")
    public ResponseEntity<BookModel> getByAuthor(@PathVariable String author) {
        return bookService.getByAuthor(author);
    }

}
