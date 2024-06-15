package com.bookstore.inventory.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bookstore.inventory.entity.Book;

import java.util.List;

@Repository
public class BookDAOImpl implements BookDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BookDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Book> getAllBooks() {
        String sql = "SELECT * FROM books";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Book.class));
    }

    @Override
    public Book getBookById(Long id) {
        String sql = "SELECT * FROM books WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(Book.class));
    }

    @Override
    public void addBook(Book book) {
        String sql = "INSERT INTO books (title, author, price) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, book.getBookName(), book.getBookAuthor(), book.getPrice());
    }

    @Override
    public void updateBook(Book book) {
        String sql = "UPDATE books SET title = ?, author = ?, price = ? WHERE id = ?";
        jdbcTemplate.update(sql, book.getBookName(), book.getBookAuthor(), book.getPrice(), book.getBookId());
    }

    @Override
    public void deleteBook(Long id) {
        String sql = "DELETE FROM books WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}

