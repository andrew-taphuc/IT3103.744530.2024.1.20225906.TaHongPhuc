package hust.soict.dsai.aims.screen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import hust.soict.dsai.aims.media.Disc_phucth;
import hust.soict.dsai.aims.media.Media_phucth;
import hust.soict.dsai.aims.media.Playable_phucth;
import lab04.Cart_phucth;

// MediaStore Class
class MediaStore extends JPanel {
	private static final long serialVersionUID = 1L;
    private Cart_phucth cart; // Change this to be passed in constructor
    private Media_phucth media;

    // Modify constructor to accept cart
    public MediaStore(Media_phucth media, Cart_phucth cart) {
        this.media = media;
        this.cart = cart; // Store the cart
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // Title Label
        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
        title.setAlignmentX(CENTER_ALIGNMENT);

        // Cost Label
        JLabel cost = new JLabel("" + media.getCost() + " $");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        // Button Container
        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        // Add to Cart Button
        JButton addToCartButton = new JButton("Add to cart");
        addToCartButton.addActionListener(e -> {
            cart.addMedia_phucth(media);
            JOptionPane.showMessageDialog(null, media.getTitle() + " added to cart!");
        });
        container.add(addToCartButton);

        // Play Button for Playable items (like DVD or CD)
        if (media instanceof Playable_phucth) {
            JButton playButton = new JButton("Play");
            playButton.addActionListener(e -> showPlayDialog((Playable_phucth) media));
            container.add(playButton);
        }

        // Assemble the panel
        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    // Method to display Play information in a JDialog
    private void showPlayDialog(Playable_phucth playableMedia) {
        // Format the message for Playable items
        String playMessage = "Now Playing:\n" +
                             "Title: " + ((Media_phucth) playableMedia).getTitle() + "\n" +
                             "Length: " + ((Disc_phucth) playableMedia).getLength() + " minutes";

        // Display the message in a JDialog
        JDialog playDialog = new JDialog((JFrame) SwingUtilities.getWindowAncestor(this), "Play Media", true);
        playDialog.setLayout(new BorderLayout());

        // Text area for the message
        JTextArea messageArea = new JTextArea(playMessage);
        messageArea.setFont(new Font("Arial", Font.PLAIN, 16));
        messageArea.setEditable(false);

        playDialog.add(new JScrollPane(messageArea), BorderLayout.CENTER);

        // Close Button
        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(e -> playDialog.dispose());
        playDialog.add(closeButton, BorderLayout.SOUTH);

        playDialog.setSize(400, 200);
        playDialog.setLocationRelativeTo(this);
        playDialog.setVisible(true);
    }
}
