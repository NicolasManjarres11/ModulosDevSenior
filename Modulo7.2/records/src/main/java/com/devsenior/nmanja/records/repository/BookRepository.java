package com.devsenior.nmanja.records.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsenior.nmanja.records.model.entity.Book;

public interface BookRepository extends JpaRepository<Book,Long>{

    Optional<Book> findByTitle(String title);
    
}
