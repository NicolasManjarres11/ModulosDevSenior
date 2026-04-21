package com.devsenior.nmanja.records.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsenior.nmanja.records.model.dto.BookDto;
import com.devsenior.nmanja.records.service.BookService;

import jakarta.validation.Valid;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;


    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<BookDto> getAllBooks() {
        return bookService.getAll();
    }

    @GetMapping("/{title}")
    public BookDto getBookByTitle(@PathVariable String title) {


        return bookService.getByTitle(title);
    }
    

    @PostMapping
    public BookDto create(@Valid @RequestBody BookDto entity) {
        
        return bookService.create(entity);
    }
    
    
    
}
