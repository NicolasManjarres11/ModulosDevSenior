package com.devsenior.nmanja.records.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.devsenior.nmanja.records.model.dto.BookDto;
import com.devsenior.nmanja.records.model.entity.Book;


@Mapper(componentModel = "spring")
public interface BookMapper {

    @Mapping(target = "id",ignore = true)
    Book toEntity(BookDto dto);

    BookDto toDto(Book entity);
    
}
