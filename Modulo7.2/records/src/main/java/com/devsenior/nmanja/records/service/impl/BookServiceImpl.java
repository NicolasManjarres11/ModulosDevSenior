package com.devsenior.nmanja.records.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.devsenior.nmanja.records.mapper.BookMapper;
import com.devsenior.nmanja.records.model.dto.BookDto;
import com.devsenior.nmanja.records.repository.BookRepository;
import com.devsenior.nmanja.records.service.BookService;

@Service
public class BookServiceImpl implements BookService{

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    

    public BookServiceImpl(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    @Override
    public List<BookDto> getAll() {

        return bookRepository.findAll().stream()
                .map(bookMapper::toDto)
                .toList();

    }

    @Override
    public BookDto getByTitle(String title) {
        return bookRepository.findByTitle(title)
        .map(bookMapper::toDto)
        .orElseThrow(() -> new RuntimeException("No se encontró el libro"));
    }

    @Override
    public BookDto create(BookDto entity) {
        var book = bookMapper.toEntity(entity);
        book = bookRepository.save(book);
        return bookMapper.toDto(book);
    }
    
}
