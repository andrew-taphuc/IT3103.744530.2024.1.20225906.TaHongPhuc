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
            else System.out.println('"' + itemsOrdered[qtyOrdered-1].getTitle() + '"'+ " has been added successfully");
        } else {
            System.out.println("Your cart is full, please create new cart or remove other DVD!");
        }
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
}
