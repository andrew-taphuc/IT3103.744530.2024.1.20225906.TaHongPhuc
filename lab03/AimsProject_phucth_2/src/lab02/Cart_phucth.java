package lab02;

public class Cart_phucth {
	
	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc_phucth itemsOrdered[]=
			new DigitalVideoDisc_phucth[MAX_NUMBERS_ORDERED];
	
	private int qtyOrdered = 0;
	
	public void addDigitalVideoDisc_phucth(DigitalVideoDisc_phucth disc) {
        if(qtyOrdered < 20) {
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            if(qtyOrdered > 15)System.out.println("Your cart is almost full!");
            else System.out.println(disc.getId() +" - " + '"' + itemsOrdered[qtyOrdered-1].getTitle() + '"'+ " has been added successfully");
        } else {
            System.out.println("Your cart is full, please create new cart or remove other DVD!");
        }
    }
	
	//Insert list of DVDs
	public void addDigitalVideoDisc_phucth(DigitalVideoDisc_phucth [] disc) {
        for (DigitalVideoDisc_phucth phuc:disc) {
        	addDigitalVideoDisc_phucth(phuc);
        }
    }
	
	//Insert arbitrary numbers of arguments
	public void addDigitalVideoDisc_phucth_1(DigitalVideoDisc_phucth ... disc) {
        for (DigitalVideoDisc_phucth phuc:disc) {
        	addDigitalVideoDisc_phucth(phuc);
        }
    }
	
	//Overloading by differing in number of parameters 
	public void addDigitalVideoDisc_phucth(
			DigitalVideoDisc_phucth dvd1,
			DigitalVideoDisc_phucth dvd2) {
		addDigitalVideoDisc_phucth_1(dvd1, dvd2);
    }

	
	public void removeDigitalVideoDisc_phucth(DigitalVideoDisc_phucth disc) {
		boolean found = false;
		String rmvTitle = "";
	    for (int i = 0; i < itemsOrdered.length; i++) {
	        if (itemsOrdered[i] != null && itemsOrdered[i].equals(disc)) {
	        	rmvTitle = itemsOrdered[i].getTitle();
	            itemsOrdered[i] = null;
	            for (int j = i; j < itemsOrdered.length - 1; j++) {
	                itemsOrdered[j] = itemsOrdered[j + 1];
	            }
	            itemsOrdered[itemsOrdered.length - 1] = null;
	            found = true;
	            break;
	        }
	    }qtyOrdered--;
	    
	    if (found) {
	        	System.out.println('"' + rmvTitle + '"' + " was removed successfully.");
	        	if (itemsOrdered[0] == null) System.out.println("Cart is empty!.");
	    } else {
	    	if (itemsOrdered[0] == null) System.out.println("Cart is empty!");
	    	else System.out.println("DVD not found.");

	    }
	   
	}
	
	public float totalCost() {
	    float totalCost = 0.0f;

	    for (DigitalVideoDisc_phucth disc : itemsOrdered) {
	        if (disc != null) {
	            totalCost += disc.getCost();
	        }
	    }
	    return totalCost;
	}	

    // print the list of ordered items of a cart
    public void printItemsInCart() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        for(int i=0; i<qtyOrdered; i++) {
            DigitalVideoDisc_phucth dvd = itemsOrdered[i];
            System.out.printf("%d. DVD -  %s - %s - %s - %d: %.2f$ \n",i+1, dvd.getTitle(), dvd.getCategory(), dvd.getDirector(), dvd.getLength(), dvd.getCost() );
        }

        float totalCost = totalCost();
        System.out.printf("Total cost: %.2f $ \n", totalCost);
        System.out.println("***************************************************");
    }

    // search by ID
    public boolean searchById(int id) {
        int n = qtyOrdered;
        for(int i=0; i<n; i++) {
            if(itemsOrdered[i].getId() == id) return true;
        }
        return false;
    }

    //search by title 
    public void searchByTitle(String title) {
        int n = qtyOrdered;
        boolean check = false;
        for(int i=0; i<n; i++) {
            if(itemsOrdered[i].isMatch(title)) {
                System.out.println("Your cart has a DVD as title name is: " + title);
                check = true;
            } 
        }
        if(!check) {
            System.out.println("No data is matching");
        }
    }
}
