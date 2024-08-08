package com.senai.project1.services;

import com.senai.project1.dtos.BookDTO;
import com.senai.project1.models.BookModel;
import com.senai.project1.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public ResponseEntity<BookModel> persist(BookDTO bookDTO) {
        BookModel bookModel = new BookModel();
        try {
            bookModel.setId(bookDTO.bok_id());
            bookModel.setTitle(bookDTO.bok_title());
            bookModel.setAuthor(bookDTO.bok_author());
            bookModel.setIsbn(bookDTO.bok_isbn());
            bookModel.setPubDate(bookDTO.bok_pub_date());
            bookRepository.save(bookModel);
            return new ResponseEntity<>(bookModel, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(bookModel, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<List<BookModel>> getAll() {
        List<BookModel> bookModel = null;
        try {
            bookModel = bookRepository.findAll();
            return new ResponseEntity<>(bookModel, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(bookModel, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<BookModel> getByTitle(String title) {
        BookModel bookModel = new BookModel();
        try {
            bookModel = bookRepository.findByTitle(title);
            return new ResponseEntity<>(bookModel, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(bookModel, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<BookModel> getByAuthor(String author) {
        BookModel bookModel = new BookModel();
        try {
            bookModel = bookRepository.findByAuthor(author);
            return new ResponseEntity<>(bookModel, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(bookModel, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
