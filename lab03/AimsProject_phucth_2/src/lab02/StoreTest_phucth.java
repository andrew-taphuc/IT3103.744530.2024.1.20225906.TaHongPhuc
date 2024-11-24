package lab02;

public class StoreTest_phucth {
    public static void main(String[] args) {
        Store_phucth myStore_phucth = new Store_phucth();

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
        
        myStore_phucth.addDVDStore(dvd1);
        myStore_phucth.addDVDStore(dvd2);
        myStore_phucth.addDVDStore(dvd3);
        myStore_phucth.addDVDStore(dvd4);
        myStore_phucth.addDVDStore(dvd5);
        myStore_phucth.removeDVDStore(dvd3);
    }
}