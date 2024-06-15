package com.bookstore.inventory.dto;

import java.util.List;

import com.bookstore.inventory.entity.Book;

public interface BookDAO {

	List<Book> getAllBooks();
    Book getBookById(Long id);
    void addBook(Book book);
    void updateBook(Book book);
    void deleteBook(Long id);
}
