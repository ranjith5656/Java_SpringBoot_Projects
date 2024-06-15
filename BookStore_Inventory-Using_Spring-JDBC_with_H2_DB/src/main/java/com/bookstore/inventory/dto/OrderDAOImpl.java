package com.bookstore.inventory.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bookstore.inventory.entity.Book;
import com.bookstore.inventory.entity.Order;

import java.util.List;

@Repository
public class OrderDAOImpl implements OrderDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public OrderDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Order> getAllOrders() {
        String sql = "SELECT * FROM orders";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Order.class));
    }

    @Override
    public Order getOrderById(Long id) {
        String sql = "SELECT * FROM orders WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(Order.class));
    }

    @Override
    public void addOrder(Order order) {
        String insertOrderSql = "INSERT INTO orders (id, customer_id, customer_name, shipping_address, total_amount) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(insertOrderSql, order.getId(),order.getCustomerId(),order.getCustomerName(), order.getShippingAddress(),order.getTotalAmount());

        Long orderId = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Long.class);

        String insertOrderItemsSql = "INSERT INTO orders (id, customer_id, customer_name, shipping_address, total_amount) VALUES (?, ?, ?, ?, ?)";
        for (Book book : order.getBooks()) {
            jdbcTemplate.update(insertOrderItemsSql, order.getId(),order.getCustomerId(),order.getCustomerName(), order.getShippingAddress(),order.getTotalAmount());
        }
    }

    @Override
    public void updateOrder(Order order) {
        String updateOrderSql = "UPDATE orders SET order_date = ?, customer_id = ? WHERE id = ?";
        jdbcTemplate.update(updateOrderSql, order.getId(),order.getCustomerId(),order.getCustomerName(), order.getShippingAddress(),order.getTotalAmount()  );

        String deleteOrderItemsSql = "DELETE FROM order_items WHERE order_id = ?";
        jdbcTemplate.update(deleteOrderItemsSql, order.getId());

        String insertOrderItemsSql = "INSERT INTO order_items (order_id, book_id, ) VALUES (?, ?, ?)";
        for (Book book : order.getBooks()) {
            jdbcTemplate.update(insertOrderItemsSql, order.getId(),order.getCustomerId(),order.getCustomerName(), order.getShippingAddress(),order.getTotalAmount());
        }
    }

    @Override
    public void deleteOrder(Long id) {
        String deleteOrderItemsSql = "DELETE FROM order_items WHERE order_id = ?";
        jdbcTemplate.update(deleteOrderItemsSql, id);

        String deleteOrderSql = "DELETE FROM orders WHERE id = ?";
        jdbcTemplate.update(deleteOrderSql, id);
    }
}
