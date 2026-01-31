package com.example.bai2.services;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.bai2.models.Book;

@Service
public class BookService {

    private List<Book> books = new ArrayList<>(List.of(
            new Book(3, "The Great Gatsby", "F. Scott Fitzgerald"),
            new Book(4, "The Catcher in the Rye", "J.D. Salinger"),
            new Book(5, "Moby-Dick", "Herman Melville")
    ));

    private int nextId = 6;

    public List<Book> getAllBooks() {
        return books;
    }

    public Book getBookById(int id) {
        return books.stream()
                .filter(book -> book.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void addBook(Book book) {
        book.setId(nextId++);
        books.add(book);
    }

    public void updateBook(Book updatedBook) {
        books.stream()
                .filter(book -> book.getId() == updatedBook.getId())
                .findFirst()
                .ifPresent(book -> {
                    book.setTitle(updatedBook.getTitle());
                    book.setAuthor(updatedBook.getAuthor());
                });
    }

    public void deleteBook(int id) {
        books.removeIf(book -> book.getId() == id);
    }
}

