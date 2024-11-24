package lab02;
public class Aims_phucth {

	public static void main(String[] args) {
		//create new cart
        Cart_phucth anOrder = new Cart_phucth();
        
        //create new DVD and add to cart
        DigitalVideoDisc_phucth dvd1 = 
        		new DigitalVideoDisc_phucth("Mắt biếc", "Tình cảm", "Victor Vũ", 120, 20.5f);
        DigitalVideoDisc_phucth dvd2 = 
        		new DigitalVideoDisc_phucth("Bố già", "Hà", "Thánh Trần", 87, 24.15f);
        DigitalVideoDisc_phucth dvd3 = 
        		new DigitalVideoDisc_phucth("Despicable Me 3", "Animation", 15.35f);
        DigitalVideoDisc_phucth dvd4 = 
        		new DigitalVideoDisc_phucth("Rush Hour", "Acation", 20f);
        DigitalVideoDisc_phucth dvd5 = 
        		new DigitalVideoDisc_phucth("Ngày xưa có một chuyện tình", "Tình cảm", 20f);
        
        DigitalVideoDisc_phucth[] phuc123 = {dvd2, dvd3};
        
        //add 1 dvd
        anOrder.addDigitalVideoDisc_phucth(dvd1);
        //add 2 dvd
        anOrder.addDigitalVideoDisc_phucth(dvd2, dvd3);
        
        anOrder.printItemsInCart();
//        //add a list of dvds
//        anOrder.addDigitalVideoDisc_phucth(phuc123);
//        //add arbitrary number of dvds
//        anOrder.addDigitalVideoDisc_phucth_1(dvd4, dvd5);
//        //
//        
        //print total price of the items in the cart
        System.out.println("\nTotal cost is: " + anOrder.totalCost() + "$\n");
	}
}
	

