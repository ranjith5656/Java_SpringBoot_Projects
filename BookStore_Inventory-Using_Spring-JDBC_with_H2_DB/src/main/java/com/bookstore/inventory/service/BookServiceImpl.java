package com.bookstore.inventory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bookstore.inventory.dto.BookDAO;
import com.bookstore.inventory.entity.Book;

public class BookServiceImpl {
	
	 @Autowired
	    private BookDAO bookDAO;

	    

	    public List<Book> getAllBooks() {
	        return bookDAO.getAllBooks();
	    }

	    public Book getBookById(Long id) {
	        return bookDAO.getBookById(id);
	    }

	    public void addBook(Book book) {
	        bookDAO.addBook(book);
	    }

	    public void updateBook(Book book) {
	        bookDAO.updateBook(book);
	    }

	    public void deleteBook(Long id) {
	        bookDAO.deleteBook(id);
	    }
	}



