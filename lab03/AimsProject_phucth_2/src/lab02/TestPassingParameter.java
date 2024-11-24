package lab02;

public class TestPassingParameter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DigitalVideoDisc_phucth jungleDVD= new DigitalVideoDisc_phucth("Jungle");
		DigitalVideoDisc_phucth cinderellaDVD= new DigitalVideoDisc_phucth("Cinderella");

	    // Fuctional SWAP
		swap_1(jungleDVD, cinderellaDVD);
//		swap (jungleDVD, cinderellaDVD);
		System.out.println("jungle DVD title: " + jungleDVD.getTitle());
		System.out.println("cinderella DVD title: " + cinderellaDVD.getTitle());

//		changeTitle(jungleDVD, cinderellaDVD.getTitle());
//		System.out.println("jungle DVD title: " + jungleDVD.getTitle());
	}
	
	public static void swap (Object o1, Object o2) {
		Object tmp = o1;
		o1 = o2;
		o2 = tmp;
	}
	
	public static void swap_1(DigitalVideoDisc_phucth dvd0, DigitalVideoDisc_phucth dvd1) {
        DigitalVideoDisc_phucth tmp = new DigitalVideoDisc_phucth("Jungle");
        tmp.setTitle(dvd0.getTitle());
        dvd0.setTitle(dvd1.getTitle());
        dvd1.setTitle(tmp.getTitle());
    }
	
	public static void changeTitle(DigitalVideoDisc_phucth dvd, String title) {
		String oldTitle = dvd.getTitle();
		dvd.setTitle(title);
		dvd = new DigitalVideoDisc_phucth (oldTitle);
	}

}
