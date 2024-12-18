package hust.soict.dsai.aims.screen;

import javax.swing.JFrame;

import lab04.Cart_phucth;
import lab04.Store_phucth;
import hust.soict.dsai.aims.media.DigitalVideoDisc_phucth;
import hust.soict.dsai.aims.media.CompactDisc_phucth;
import hust.soict.dsai.aims.cart.CartScreen;
import hust.soict.dsai.aims.media.Book_phucth;

import hust.soict.dsai.aims.media.Disc_phucth;
import hust.soict.dsai.aims.media.Media_phucth;
import hust.soict.dsai.aims.media.Playable_phucth;
import hust.soict.dsai.aims.media.Track_phucth;

import javax.swing.*;
import java.awt.*;

import java.util.ArrayList;

public class StoreScreen extends JFrame {
    private static final long serialVersionUID = 1L;
	private Store_phucth store;
    private Cart_phucth cart;
    private JPanel centerPanel; // Declare centerPanel as a class field

    // Constructor
    public StoreScreen(Store_phucth store, Cart_phucth cart) {
        this.store = store;
        this.cart = cart;
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(createNorth(), BorderLayout.NORTH);
        
        // Initialize centerPanel when creating the store screen
        centerPanel = createCenter();
        cp.add(centerPanel, BorderLayout.CENTER);

        setVisible(true);
        setTitle("Store");
        setSize(1024, 768);
    }

    // Method to create the NORTH component
    JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    // Method to create the Menu Bar
    JMenuBar createMenuBar() {
    	JMenu menu = new JMenu("Options");

        JMenu smUpdateStore = new JMenu("Update Store");
        
        // Add Book menu item
        JMenuItem addBookItem = new JMenuItem("Add Book");
        addBookItem.addActionListener(e -> {
            new AddBookToStoreScreen(this, store);
        });
        smUpdateStore.add(addBookItem);

        // Add CD menu item
        JMenuItem addCDItem = new JMenuItem("Add CD");
        addCDItem.addActionListener(e -> {
            new AddCompactDiscToStoreScreen(this, store);
        });
        smUpdateStore.add(addCDItem);

        // Add DVD menu item
        JMenuItem addDVDItem = new JMenuItem("Add DVD");
        addDVDItem.addActionListener(e -> {
            new AddDigitalVideoDiscToStoreScreen(this, store);
        });
        smUpdateStore.add(addDVDItem);

        menu.add(smUpdateStore);
        menu.add(new JMenuItem("View store"));
        
        // Add View Cart menu item with action
        JMenuItem viewCartItem = new JMenuItem("View cart");
        viewCartItem.addActionListener(e -> {
            new CartScreen(cart); // Open CartScreen with the current cart
        });
        menu.add(viewCartItem);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        return menuBar;
    }

    // Method to create the Header
    JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);

        JButton cart = new JButton("View cart");
        cart.addActionListener(e -> {
            new CartScreen(this.cart); // Open CartScreen with the current cart
        });
        cart.setPreferredSize(new Dimension(100, 50));
        cart.setMaximumSize(new Dimension(100, 50));

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(cart);
        header.add(Box.createRigidArea(new Dimension(10, 10)));

        return header;
    }
    
    public void refreshStoreScreen() {
        // Remove existing center panel
        Container cp = getContentPane();
        cp.remove(centerPanel);

        // Recreate center panel with updated store items
        centerPanel = createCenter();
        cp.add(centerPanel, BorderLayout.CENTER);

        // Revalidate and repaint the frame
        revalidate();
        repaint();
    }

    JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(4, 4, 2, 2));

        ArrayList<Media_phucth> mediaInStore = store.getItemsInStore_phucth();
        for (int i = 0; i < mediaInStore.size(); i++) {
            MediaStore cell = new MediaStore(mediaInStore.get(i), cart);
            center.add(cell);
        }

        return center;
    }

    public static void main(String[] args) {
        // Example: Initialize Store and StoreScreen
    	Store_phucth store1 = new Store_phucth();
    	Cart_phucth cart = new Cart_phucth(); // Create a cart
    	DigitalVideoDisc_phucth dvd1 = 
    	        new DigitalVideoDisc_phucth("Doraemon", "Viễn tưởng", "Fujiko F. Fujio", 120, 20f);
    	DigitalVideoDisc_phucth dvd2 = 
    	        new DigitalVideoDisc_phucth("Conan", "Trinh thám", "Gosho Aoyama", 120, 50f);
    	DigitalVideoDisc_phucth dvd3 = 
    	        new DigitalVideoDisc_phucth("Shin - crayon boy", "Hài hước", "Yoshito Usui", 120, 10f);
    	DigitalVideoDisc_phucth dvd4 = 
    	        new DigitalVideoDisc_phucth("Miko", "Tình cảm", "Eriko Ono", 120, 40f);
    	DigitalVideoDisc_phucth dvd5 = 
    	        new DigitalVideoDisc_phucth("Dragonball", "Hành động", "Akira Toriyama", 120, 20f);
    	DigitalVideoDisc_phucth dvd6 = 
    	        new DigitalVideoDisc_phucth("Diep Van", "Hành động", "Akira Toriyama", 120, 25f);
    	
    	CompactDisc_phucth cd1 = 
    			new CompactDisc_phucth("Thriller", "Pop", "Michael Jackson", 29.99f);
        CompactDisc_phucth cd2 = 
        		new CompactDisc_phucth("Back in Black", "Rock", "AC/DC", 24.99f);
        CompactDisc_phucth cd3 = 
        		new CompactDisc_phucth("The Dark Side of the Moon", "Progressive Rock", "Pink Floyd", 34.99f);
        CompactDisc_phucth cd4 = 
        		new CompactDisc_phucth("Nhac tre 2k hay nhat", "Progressive Rock", "Pink Floyd", 300f);
    	
        Track_phucth track1 = new Track_phucth("Track 1", 180); 
        Track_phucth track2 = new Track_phucth("Track 2", 240);
        Track_phucth track3 = new Track_phucth("Track 3", 300);
        Track_phucth track4 = new Track_phucth("Track 4", 360);
        
        cd1.addTrack(track1);
        cd1.addTrack(track2);
        cd2.addTrack(track2);
        cd2.addTrack(track3);
        cd3.addTrack(track3);
        cd3.addTrack(track4);
        
        Book_phucth book1 = new Book_phucth("1984", "Dystopian", 15.99f);
        Book_phucth book2 = new Book_phucth("Mat Biec", "Fiction", 15f);
        
    	store1.addMedia_phucth(dvd1);
    	store1.addMedia_phucth(dvd2);
        store1.addMedia_phucth(dvd3);
        store1.addMedia_phucth(dvd4);
        store1.addMedia_phucth(dvd5);
        store1.addMedia_phucth(cd1);
    	store1.addMedia_phucth(cd2);
        store1.addMedia_phucth(cd3);
        store1.addMedia_phucth(book1);
        store1.addMedia_phucth(book2);
    	store1.addMedia_phucth(cd4);
    	store1.addMedia_phucth(dvd6);
    	
    	
        new StoreScreen(store1, cart);
        
        
        
    }
}
