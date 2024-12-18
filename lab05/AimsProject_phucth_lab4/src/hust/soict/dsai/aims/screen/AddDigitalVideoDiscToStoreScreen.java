package hust.soict.dsai.aims.screen;

import javax.swing.*;
import java.awt.*;

import hust.soict.dsai.aims.media.DigitalVideoDisc_phucth;
import lab04.Store_phucth;

public class AddDigitalVideoDiscToStoreScreen extends JDialog {
    private JFrame parentFrame; // Add this to refresh store screen
    private Store_phucth store;
    private JTextField titleField;
    private JTextField categoryField;
    private JTextField priceField;
    private JTextField directorField;
    private JTextField lengthField;

    public AddDigitalVideoDiscToStoreScreen(JFrame parent, Store_phucth store) {
        super(parent, "Add Digital Video Disc", true);
        this.store = store;
        this.parentFrame = parent;
        
        setLayout(new GridLayout(0, 2, 10, 10));
        setSize(400, 300);
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

        // Director
        add(new JLabel("Director:"));
        directorField = new JTextField();
        add(directorField);

        // Length
        add(new JLabel("Length (minutes):"));
        lengthField = new JTextField();
        add(lengthField);

        // Submit Button
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(e -> submitDVD());
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

    private void submitDVD() {
        // Validate input
        if (!validateInput()) return;

        try {
            // Create DVD
            String title = titleField.getText();
            String category = categoryField.getText();
            float price = Float.parseFloat(priceField.getText());
            String director = directorField.getText();
            int length = Integer.parseInt(lengthField.getText());

            DigitalVideoDisc_phucth dvd = new DigitalVideoDisc_phucth(
                title, category, director, length, price
            );

            // Add to store
            store.addMedia_phucth(dvd);
            
            // Show success message
            JOptionPane.showMessageDialog(this, 
                "DVD added successfully!", 
                "Success", 
                JOptionPane.INFORMATION_MESSAGE);
            
         // Refresh the store screen
            if (parentFrame instanceof StoreScreen) {
                ((StoreScreen) parentFrame).refreshStoreScreen();
            }
            
            // Close dialog
            dispose();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, 
                "Length must be a valid number", 
                "Validation Error", 
                JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean validateInput() {
        // Check if fields are empty
        if (titleField.getText().isEmpty() || 
            categoryField.getText().isEmpty() || 
            priceField.getText().isEmpty() ||
            directorField.getText().isEmpty() ||
            lengthField.getText().isEmpty()) {
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