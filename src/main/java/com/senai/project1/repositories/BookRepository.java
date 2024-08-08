package com.senai.project1.repositories;

import com.senai.project1.models.BookModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<BookModel, Integer> {

    BookModel findByTitle(String title);
    BookModel findByAuthor(String author);

}
