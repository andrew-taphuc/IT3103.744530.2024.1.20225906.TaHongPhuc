package hust.soict.dsai.aims.screen;

import javax.swing.*;
import java.awt.*;

import hust.soict.dsai.aims.media.Book_phucth;
import lab04.Store_phucth;

public class AddBookToStoreScreen extends JDialog {
    private static final long serialVersionUID = 1L;
    private JFrame parentFrame;
	private Store_phucth store;
    private JTextField titleField;
    private JTextField categoryField;
    private JTextField priceField;
    private JTextArea authorsArea;

    public AddBookToStoreScreen(JFrame parent, Store_phucth store) {
        super(parent, "Add Book", true);
        this.store = store;
        this.parentFrame = parent;
        
        setLayout(new GridLayout(0, 2, 10, 10));
        setSize(1024, 768);
        setLocationRelativeTo(parent);

        // Title
        add(new JLabel("Title:"));
        titleField = new JTextField();
        add(titleField);

        // Category
        add(new JLabel("Category:"));
        categoryField = new JTextField();
        add(categoryField);

        // Price
        add(new JLabel("Price:"));
        priceField = new JTextField();
        add(priceField);

        // Authors
        add(new JLabel("Authors (comma-separated):"));
        authorsArea = new JTextArea(3, 20);
        add(new JScrollPane(authorsArea));

        // Submit Button
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(e -> submitBook());
        add(submitButton);

        // Cancel Button
        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(e -> dispose());
        add(cancelButton);
        
     // Make sure to call pack() to size the dialog appropriately
        pack();
        
        // Set the dialog to be visible AFTER all components are added
        setVisible(true);
    }

    private void submitBook() {
        // Validate input
        if (!validateInput()) return;

        // Create Book
        String title = titleField.getText();
        String category = categoryField.getText();
        float price = Float.parseFloat(priceField.getText());
        
        Book_phucth book = new Book_phucth(title, category, price);
        
        // Add authors
        String authorsText = authorsArea.getText();
        if (!authorsText.isEmpty()) {
            String[] authors = authorsText.split(",");
            for (String author : authors) {
                book.addAuthor(author.trim());
            }
        }
        
        // Add to store
        store.addMedia_phucth(book);
        
        // Show success message
        JOptionPane.showMessageDialog(this, 
            "Book added successfully!", 
            "Success", 
            JOptionPane.INFORMATION_MESSAGE);
        
     // Refresh the store screen
        if (parentFrame instanceof StoreScreen) {
            ((StoreScreen) parentFrame).refreshStoreScreen();
        }
        
        // Close dialog
        dispose();
    }

    private boolean validateInput() {
        // Check if fields are empty
        if (titleField.getText().isEmpty() || 
            categoryField.getText().isEmpty() || 
            priceField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                "Please fill in all fields", 
                "Validation Error", 
                JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        // Validate price
        try {
            Float.parseFloat(priceField.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, 
                "Price must be a valid number", 
                "Validation Error", 
                JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        return true;
    }

}