package CoHoa;

public class Kindergarten_5906 extends Child_5906{
	String favoriteToy_5906;
	public Kindergarten_5906() {
		// TODO Auto-generated constructor stub
	}
	
	public String getFavoriteToy_5906() {
		return favoriteToy_5906;
	}

	public void setFavoriteToy_5906(String favoriteToy_5906) {
		this.favoriteToy_5906 = favoriteToy_5906;
	}
	
	public Kindergarten_5906(String name, int age, String className, String toy) {
        this.name_5906 = name;
        this.age_5906 = age;
        this.className_5906 = className;
        this.favoriteToy_5906 = toy;
    }

    @Override
    public String toString() {
        return "Kindergarten_20225906   " +super.toString() + String.format(", do choi yeu thich: %s", 
            favoriteToy_5906 != null ? favoriteToy_5906 : "Chua co thong tin");
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Do choi yeu thich: " + (favoriteToy_5906 != null ? favoriteToy_5906 : "Chua co thong tin"));
    }
}