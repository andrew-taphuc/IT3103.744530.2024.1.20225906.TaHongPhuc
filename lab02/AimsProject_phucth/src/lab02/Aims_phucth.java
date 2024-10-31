package lab02;

public class Aims_phucth {

	public static void main(String[] args) {
		//create new cart
        Cart_phucth anOrder = new Cart_phucth();

        //create new DVD and add to cart
        DigitalVideoDisc_phucth dvd1 = 
        		new DigitalVideoDisc_phucth("Mắt biếc", "Tình cảm", "Victor Vũ", 120, 20.5f);
        anOrder.addDigitalVideoDisc_phucth(dvd1);
        DigitalVideoDisc_phucth dvd2 = 
        		new DigitalVideoDisc_phucth("Bố già", "Hà", "Thánh Trần", 87, 24.15f);
        anOrder.addDigitalVideoDisc_phucth(dvd2);
        DigitalVideoDisc_phucth dvd3 = 
        		new DigitalVideoDisc_phucth("Despicable Me 3", "Animation", 15.35f);
        anOrder.addDigitalVideoDisc_phucth(dvd3);
        
        //print total price of the items in the cart
        System.out.println("Total cost is: " + anOrder.totalCost() + "$\n");
        
        //remove DVDs 
        anOrder.removeDigitalVideoDisc_phucth(dvd3);
        anOrder.removeDigitalVideoDisc_phucth(dvd2);
        anOrder.removeDigitalVideoDisc_phucth(dvd1);

        //print total price of the items in the cart
        System.out.println("Total cost is: " + anOrder.totalCost() + "$");
	}
}
	

