package lab04;

import java.util.ArrayList;
import java.util.List;

import hust.soict.dsai.aims.media.Media_phucth;

public class Store_phucth {
    public static final int MAX_DVD = 50;
    private List<Media_phucth> itemsInStore = new ArrayList<Media_phucth>();
    private int qtyOrdered = 0;

    public int getQtyOrdered() {
        return qtyOrdered;
    }

    public void setQtyOrdered(int n) {
        qtyOrdered += n;
    }
    
    public void addMedia_phucth(Media_phucth product) {
		if(!itemsInStore.contains(product)) {
			itemsInStore.add(product);
			System.out.println("Media added successfully!");
		}
		else {
			System.out.println("Media existed!");
		}
	}
	
//	public void removeMedia_phucth(Media_phucth product) {
//		if(itemsInStore.contains(product)) {
//			itemsInStore.remove(product);
//			System.out.println("Media removed.");
//		}
//		else {
//			System.out.println("Media not exist!");
//		}
//	}
	
	public void removeMedia_phucth(String title) {
	    boolean removed = false;
	    for (int i = 0; i < itemsInStore.size(); i++) {
	        if (itemsInStore.get(i).getTitle().equalsIgnoreCase(title)) {
	            itemsInStore.remove(i); // Remove the media by index
	            System.out.println("Media with title '" + title + "' removed.");
	            removed = true;
	            break; //exit
	        }
	    }
	    if (!removed) {
	        System.out.println("Media with title '" + title + "' does not exist!");
	    }
	}
	
    // Print items in cart
    public void printItemsInStore() {
        System.out.println("***********************CART***********************");
        System.out.println("Available Items:");
        for(int i=0; i<itemsInStore.size(); i++) {
            Media_phucth dvd = itemsInStore.get(i);
            System.out.printf("%d. %s - %s: %.2f$ \n",i+1,
            		dvd.getTitle(), dvd.getCategory(), dvd.getCost() );
        }
        System.out.println("***************************************************");
    }
	
 // Search by title 
    public Media_phucth searchByTitle(String title) {
        int n = itemsInStore.size();
        for (int i = 0; i < n; i++) {
            if (itemsInStore.get(i).isMatch(title)) {
//                System.out.println(title + " - " + itemsInStore.get(i).getCost());
                return itemsInStore.get(i); // Return the matching media
            }
        }
        return null; // Return null if no match is found
    }
    
    
}
