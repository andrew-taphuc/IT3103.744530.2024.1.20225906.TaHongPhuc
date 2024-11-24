package lab02;

public class DigitalVideoDisc_phucth {
	private String title;
	private String category;
	private String director;
	private int length;
	private float cost;
	
	private static int nbDVD_phucth = 0;
	private int id;
	public int getId() {
        return id;
    }
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	
	
	//Create DVD by Title
	public DigitalVideoDisc_phucth(String title) {
		super();
		this.title = title;
		nbDVD_phucth++;
		this.id = nbDVD_phucth;
	}
	//Create DVD by Title, Category, Cost
	public DigitalVideoDisc_phucth(String title, String category, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.cost = cost;
		nbDVD_phucth++;
		this.id = nbDVD_phucth;
	}
	//Create DVD by Title, Category, Director, Cost
	public DigitalVideoDisc_phucth(String title, String category, String director, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.cost = cost;
		nbDVD_phucth++;
		this.id = nbDVD_phucth;
	}
	//Create DVD by Title, Category, Director, Length, Cost
	public DigitalVideoDisc_phucth(String title, String category, String director, int length, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.length = length;
		this.cost = cost;
		nbDVD_phucth++;
		this.id = nbDVD_phucth;
	}
	
	// Check Title    
    public boolean isMatch(String title) {
       if(this.title == null) {
            return false;
       }
       return this.title.equalsIgnoreCase(title);
    }
    
    
}








