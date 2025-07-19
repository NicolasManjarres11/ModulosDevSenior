package com.devsenior.nmanja.service_layer.model;

//DTO, VALUE OBJECT O POJO

public class Book {

    private String isbn;
    private String title;
    private Integer publicationDate;
    private String description;

    public Book() {
    }

    public Book(String isbn, String title, Integer publicationDate, String description) {
        this.isbn = isbn;
        this.title = title;
        this.publicationDate = publicationDate;
        this.description = description;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Integer publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
