package com.devsenior.nmanja.records.service;

import java.util.List;

import com.devsenior.nmanja.records.model.dto.BookDto;


public interface BookService {

    List<BookDto> getAll();

    BookDto getByTitle(String title);

    BookDto create(BookDto entity);
    
}
