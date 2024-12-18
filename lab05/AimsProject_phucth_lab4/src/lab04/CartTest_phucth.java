package lab04;

import hust.soict.dsai.aims.media.DigitalVideoDisc_phucth;

public class CartTest_phucth {
    public static void main(String[] args) {
        Cart_phucth ordered = new Cart_phucth();
        
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
        
//        ordered.addDigitalVideoDisc_phucth_1(dvd1, dvd2, dvd3, dvd4, dvd5);

        // Tìm kiếm theo ID
//        if(ordered.searchById(2)) {
//            System.out.println("Items has id = 2 is ordered");
//        } else {
//            System.out.println("No data");
//        }
        // tìm kiếm DVD theo tên
        ordered.searchByTitle("Rush Hour"); 
    }
}
