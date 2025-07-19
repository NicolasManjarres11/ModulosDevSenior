package com.devsenior.nmanja.service_layer.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.devsenior.nmanja.service_layer.model.Book;
import com.devsenior.nmanja.service_layer.model.User;

//Servicio de la aplicación
@Service
public class LibraryService {

    private List<Book> books;
    private List<User> users;

    public LibraryService(){
        // Initialize books
        books = new ArrayList<>(
            List.of(
            new Book("978-0451524935", "1984", 1949, "A dystopian novel by George Orwell"),
            new Book("978-0061120084", "To Kill a Mockingbird", 1960, "Harper Lee's masterpiece about justice and racism in the American South"),
            new Book("978-0141439518", "Pride and Prejudice", 1813, "Jane Austen's beloved novel of manners and marriage"),
            new Book("978-0743273565", "The Great Gatsby", 1925, "F. Scott Fitzgerald's tale of the American Dream"),
            new Book("978-0618640157", "The Lord of the Rings", 1954, "J.R.R. Tolkien's epic fantasy trilogy")
            )
        );

        // Initialize users
        users = new ArrayList<>(
            List.of(
                new User("1", "John Doe", "john.doe@example.com", "ADMIN", "admin123", true),
                new User("2", "Jane Smith", "jane.smith@example.com", "USER", "user123", true),
                new User("3", "Bob Johnson", "bob.johnson@example.com", "USER", "user456", false),
                new User("4", "Alice Brown", "alice.brown@example.com", "LIBRARIAN", "lib123", true)
            )
        );
    }

    // Book methods
    public List<Book> findAllBooks(){
        return books;
    }

    public Book findBookByIsbn(String isbn){
        var book = books.stream()
            .filter(b -> b.getIsbn().equals(isbn))
            .findFirst()
            .orElseThrow();
        return book;
    }

    // User methods
    public List<User> findAllUsers() {
        return users;
    }

    public User findUserById(String id) {
        return users.stream()
            .filter(u -> u.getId().equals(id))
            .findFirst()
            .orElseThrow();
    }
}

