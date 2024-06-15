package com.bookstore.inventory.repository;


import com.bookstore.inventory.entity.Book;
import com.bookstore.inventory.entity.Order;
import com.bookstore.inventory.service.BookServiceImpl;
import com.bookstore.inventory.service.OrderServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BookstoreController {

	@Autowired
    private  BookServiceImpl bookService;
    private  OrderServiceImpl orderService;

    
   

    @GetMapping("/books")
    public String getAllBooks(Model model) {
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        return "book-list"; // Return the view name for displaying the list of books
    }

    @GetMapping("/books/{id}")
    public String getBookDetails(@PathVariable Long id, Model model) {
        com.bookstore.inventory.entity.Book book = bookService.getBookById(id);
        model.addAttribute("book", book);
        return "book-details"; // Return the view name for displaying book details
    }

    @PostMapping("/cart/add")
    public String addToCart(@RequestParam Long bookId, @RequestParam int quantity) {
        return "redirect:/cart"; // Redirect to the shopping cart view
    }

    @PostMapping("/cart/remove")
    public String removeFromCart(@RequestParam Long bookId) {
        return "redirect:/cart"; // Redirect to the shopping cart view
    }

    @PostMapping("/cart/update")
    public String updateCart(@RequestParam Long bookId, @RequestParam int quantity) {
        return "redirect:/cart"; // Redirect to the shopping cart view
    }

    @PostMapping("/checkout")
    public String checkout() {
        return "redirect:/order-confirmation"; // Redirect to the order confirmation view
    }

    @GetMapping("/orders")
    public String getAllOrders(Model model) {
        List<Order> orders = orderService.getAllOrders();
        model.addAttribute("orders", orders);
        return "order-list"; // Return the view name for displaying the list of orders
    }

    @GetMapping("/orders/{id}")
    public String getOrderDetails(@PathVariable Long id, Model model) {
        Order order = orderService.getOrderById(id);
        model.addAttribute("order", order);
        return "order-details"; // Return the view name for displaying order details
    }
}
