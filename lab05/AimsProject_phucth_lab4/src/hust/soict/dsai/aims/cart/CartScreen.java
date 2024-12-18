package hust.soict.dsai.aims.cart;

import java.io.IOException;

import javax.swing.JFrame;

import hust.soict.dsai.aims.media.Book_phucth;
import hust.soict.dsai.aims.media.CompactDisc_phucth;
import hust.soict.dsai.aims.media.DigitalVideoDisc_phucth;
import hust.soict.dsai.aims.media.Track_phucth;
import lab04.Cart_phucth;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class CartScreen extends JFrame{
    private static final long serialVersionUID = 1L;
	private Cart_phucth cart;
    public CartScreen(Cart_phucth cart) {
        super();
        this.cart = cart;

        JFXPanel fxPanel = new JFXPanel();
        this.add(fxPanel);
        this.setTitle("Cart");
        this.setVisible(true);
        this.setSize(1024, 768);

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/hust/soict/dsai/aims/cart/cart.fxml"));
                    CartScreenController controller = new CartScreenController(cart);
                    loader.setController(controller);
                    Parent root = loader.load();
                    fxPanel.setScene(new Scene(root));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }            
        });
    }
    
    public static void main(String[] args) {
        Cart_phucth cart = new Cart_phucth();

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
    	
    	CompactDisc_phucth cd1 = 
    			new CompactDisc_phucth("Thriller", "Pop", "Michael Jackson", 29.99f);
        CompactDisc_phucth cd2 = 
        		new CompactDisc_phucth("Back in Black", "Rock", "AC/DC", 24.99f);
        CompactDisc_phucth cd3 = 
        		new CompactDisc_phucth("The Dark Side of the Moon", "Progressive Rock", "Pink Floyd", 34.99f);
    	
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
        Book_phucth book2 = new Book_phucth("To Kill a Mockingbird", "Fiction", 12.49f);
        
    	cart.addMedia_phucth(dvd1);
    	cart.addMedia_phucth(dvd2);
    	cart.addMedia_phucth(dvd3);
    	cart.addMedia_phucth(dvd4);
    	cart.addMedia_phucth(dvd5);
    	cart.addMedia_phucth(cd1);
    	cart.addMedia_phucth(cd2);
    	cart.addMedia_phucth(cd3);
    	cart.addMedia_phucth(book1);
    	cart.addMedia_phucth(book2);

        CartScreen cartScreen = new CartScreen(cart);
        System.out.println("Hi");
        cartScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
