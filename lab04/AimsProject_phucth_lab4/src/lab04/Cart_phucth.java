package lab04;

import java.util.ArrayList;
import java.util.Collections;
//import java.util.Comparator;
import java.util.List;
import hust.soict.dsai.aims.media.Media_phucth;

public class Cart_phucth {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private List<Media_phucth> itemsOrdered = new ArrayList<Media_phucth>();
	
	public void addMedia_phucth(Media_phucth product) {
		if(!itemsOrdered.contains(product)) {
			itemsOrdered.add(product);
			System.out.println("Media added successfully!");
		}
		else {
			System.out.println("Media existed!");
		}
	}
	
	public void removeMedia_phucth(String title) {
	    boolean found = false;
	    for (int i = 0; i < itemsOrdered.size(); i++) {
	        if (itemsOrdered.get(i).getTitle().equalsIgnoreCase(title)) {
	            itemsOrdered.remove(i);
	            System.out.println("Media removed: " + title);
	            found = true;
	            break;
	        }
	    }
	    if (!found) {
	        System.out.println("Media not exist!");
	    }
	}
	
	public void removeMedia_phucth(int id) {
	    boolean found = false;
	    for (int i = 0; i < itemsOrdered.size(); i++) {
	    	id--;
	        if (itemsOrdered.get(i).getId() == id) {
	        	String remove = itemsOrdered.get(i).getTitle();
	            itemsOrdered.remove(i);
	            System.out.println("Media removed: " + remove);
	            found = true;
	            break;
	        }
	        id++;
	    }
	    if (!found) {
	        System.out.println("Media not exist!");
	    }
	}
	
	public void emptyMedia_phucth() {
	    for (int i = 0; i < itemsOrdered.size(); i++) {
	    	itemsOrdered.clear();
	    }
	}

	
	public float totalCost() {
	    float totalCost = 0.0f;

	    for (int i=0; i<itemsOrdered.size(); i++) {
	        if (itemsOrdered.get(i) != null) {
	            totalCost += itemsOrdered.get(i).getCost();
	        }
	    }
	    return totalCost;
	}	

    // Print items in cart
    public void printItemsInCart() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        for(int i=0; i<itemsOrdered.size(); i++) {
            Media_phucth dvd = itemsOrdered.get(i);
            System.out.printf("%d. %s - %s: %.2f$ \n",i+1,
            		dvd.getTitle(), dvd.getCategory(), dvd.getCost() );
        }

        float totalCost = totalCost();
        System.out.printf("Total cost: %.2f $ \n", totalCost);
        System.out.println("***************************************************");
    }
    
    // Print with toString()
    public void printCart() {
    	for (Media_phucth m : itemsOrdered) {
    		System.out.println(m.toString());
    	}
    }

    // Search by ID
 // Search by ID
    public Media_phucth searchById(int id) {
        int n = itemsOrdered.size();
        for (int i = 0; i < n; i++) {
            if (itemsOrdered.get(i).getId() == id) {
                return itemsOrdered.get(i); // Trả về đối tượng Media_phucth nếu tìm thấy
            }
        }
        return null; // Trả về null nếu không tìm thấy
    }


    // Search by title 
    public Media_phucth searchByTitle(String title) {
        int n = itemsOrdered.size();
        for (int i = 0; i < n; i++) {
            if (itemsOrdered.get(i).isMatch(title)) {
                return itemsOrdered.get(i); // Return the matching media
            }
        }
        return null; // Return null if no match is found
    }
    
    public void sortByTitleCost() {
        Collections.sort(itemsOrdered, Media_phucth.COMPARE_BY_TITLE_COST);
    }

    public void sortByCostTitle() {
        Collections.sort(itemsOrdered, Media_phucth.COMPARE_BY_COST_TITLE);
    }
    
}
