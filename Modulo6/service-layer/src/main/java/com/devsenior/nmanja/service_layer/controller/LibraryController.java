package com.devsenior.nmanja.service_layer.controller;

import org.springframework.web.bind.annotation.RestController;

import com.devsenior.nmanja.service_layer.model.Book;
import com.devsenior.nmanja.service_layer.service.LibraryService;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.apache.tomcat.jni.Library;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
@RequestMapping("/api/library")

public class LibraryController {


    
    private final LibraryService libraryServices;

    
    public LibraryController(LibraryService libraryService){
        this.libraryServices = libraryService;
    }



    @GetMapping
    
    public List<Book> getAllBooks(){

        return libraryServices.findAllBooks();
    }

    @GetMapping("/{isbn}")

    public Book getBookByIsbn(@PathVariable String isbn){


        return libraryServices.findBookByIsbn(isbn);
    }

}
