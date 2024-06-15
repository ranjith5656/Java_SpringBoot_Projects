package com.swing;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class Library extends JFrame implements ActionListener {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField titleField, authorField, searchField;
    private JButton addButton, searchButton, updateButton, deleteButton;
    private JTable table;
    private DefaultTableModel tableModel;

    private String filePath = "library_data.txt";
    private String[] columnNames = {"Title", "Author"};

    public Library() {
        setTitle("Library Management System");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        // Create input fields
        JPanel inputPanel1 = new JPanel(new FlowLayout());
        JLabel titleLabel1 = new JLabel("User:");
        JLabel authorLabel1 = new JLabel("Password:");
        titleField = new JTextField(15);
        authorField = new JTextField(15);
        addButton = new JButton("Submit");
        addButton.addActionListener(this);
        inputPanel1.add(titleLabel1);
        inputPanel1.add(titleField);
        inputPanel1.add(authorLabel1);
        inputPanel1.add(authorField);
        inputPanel1.add(addButton);
        // Create input fields
        JPanel inputPanel = new JPanel(new FlowLayout());
        JLabel titleLabel = new JLabel("Title:");
        JLabel authorLabel = new JLabel("Author:");
        titleField = new JTextField(15);
        authorField = new JTextField(15);
        addButton = new JButton("Add");
        addButton.addActionListener(this);
        inputPanel.add(titleLabel);
        inputPanel.add(titleField);
        inputPanel.add(authorLabel);
        inputPanel.add(authorField);
        inputPanel.add(addButton);

        // Create search field and button
        JPanel searchPanel = new JPanel(new FlowLayout());
        searchField = new JTextField(20);
        searchButton = new JButton("Search");
        searchButton.addActionListener(this);
        searchPanel.add(searchField);
        searchPanel.add(searchButton);

        // Create table to display library resources
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);

        // Create buttons for update and delete operations
        JPanel buttonPanel = new JPanel(new FlowLayout());
        updateButton = new JButton("Update");
        deleteButton = new JButton("Delete");
        updateButton.addActionListener(this);
        deleteButton.addActionListener(this);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);

        // Add components to the main frame
        add(inputPanel, BorderLayout.NORTH);
        add(new JScrollPane(table), BorderLayout.CENTER);
        add(searchPanel, BorderLayout.SOUTH);
        add(buttonPanel, BorderLayout.SOUTH);

        loadLibraryData();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            String title = titleField.getText();
            String author = authorField.getText();
            if (!title.isEmpty() && !author.isEmpty()) {
                addResource(title, author);
                clearFields();
            }
        } else if (e.getSource() == searchButton) {
            String searchTerm = searchField.getText();
            searchResources(searchTerm);
        } else if (e.getSource() == updateButton) {
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                String title = titleField.getText();
                String author = authorField.getText();
                if (!title.isEmpty() && !author.isEmpty()) {
                    updateResource(selectedRow, title, author);
                    clearFields();
                }
            }
        } else if (e.getSource() == deleteButton) {
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                deleteResource(selectedRow);
                clearFields();
            }
        }
    }

    private void addResource(String title, String author) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(title + "," + author);
            writer.newLine();
            writer.flush();
            String[] row = {title, author};
            tableModel.addRow(row);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void searchResources(String searchTerm) {
        tableModel.setRowCount(0);
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data[0].toLowerCase().contains(searchTerm.toLowerCase()) ||
                        data[1].toLowerCase().contains(searchTerm.toLowerCase())) {
                    tableModel.addRow(data);
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void updateResource(int rowIndex, String title, String author) {
        try {
            File inputFile = new File(filePath);
            File tempFile = new File("temp.txt");
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));

            String line;
            int lineIndex = 0;
            while ((line = reader.readLine()) != null) {
                if (lineIndex == rowIndex) {
                    writer.write(title + "," + author);
                } else {
                    writer.write(line);
                }
                writer.newLine();
                lineIndex++;
            }
            writer.close();
            reader.close();

            inputFile.delete();
            tempFile.renameTo(inputFile);

            tableModel.setValueAt(title, rowIndex, 0);
            tableModel.setValueAt(author, rowIndex, 1);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void deleteResource(int rowIndex) {
        try {
            File inputFile = new File(filePath);
            File tempFile = new File("temp.txt");
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));

            String line;
            int lineIndex = 0;
            while ((line = reader.readLine()) != null) {
                if (lineIndex != rowIndex) {
                    writer.write(line);
                    writer.newLine();
                }
                lineIndex++;
            }
            writer.close();
            reader.close();

            inputFile.delete();
            tempFile.renameTo(inputFile);

            tableModel.removeRow(rowIndex);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void clearFields() {
        titleField.setText("");
        authorField.setText("");
        searchField.setText("");
        table.clearSelection();
    }

    private void loadLibraryData() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                tableModel.addRow(data);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Library system = new Library();
            system.setVisible(true);
        });
    }
}
