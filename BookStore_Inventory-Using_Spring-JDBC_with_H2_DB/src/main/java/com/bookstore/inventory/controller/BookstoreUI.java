package com.bookstore.inventory.controller;



import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Vector;

public class BookstoreUI extends JFrame {
    private JTable booksTable;
    private JButton addToCartButton;
    private JButton removeFromCartButton;
    private JButton checkoutButton;
    // Add other Swing components as needed

    public BookstoreUI() {
        // Set JFrame properties
        setTitle("Bookstore");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);

        // Create a JPanel for the main content
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // Create a JTable to display the list of books
        Vector<String> columnNames = new Vector<>();
        columnNames.add("ID");
        columnNames.add("Title");
        columnNames.add("Author");
        columnNames.add("Price");
        Vector<Vector<Object>> data = new Vector<>(); // Replace this with actual book data
        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);
        booksTable = new JTable(tableModel);

        // Add the books table to a JScrollPane for scrollable view
        JScrollPane scrollPane = new JScrollPane(booksTable);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        // Create buttons for adding, removing, and checking out books
        addToCartButton = new JButton("Add to Cart");
        removeFromCartButton = new JButton("Remove from Cart");
        checkoutButton = new JButton("Checkout");

        // Add the buttons to a JPanel
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addToCartButton);
        buttonPanel.add(removeFromCartButton);
        buttonPanel.add(checkoutButton);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Add the main panel to the JFrame
        add(mainPanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new BookstoreUI().setVisible(true);
        });
    }
}


