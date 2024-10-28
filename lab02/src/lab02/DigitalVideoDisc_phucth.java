package lab02;

public class DigitalVideoDisc_phucth {
	private String title;
	private String category;
	private String director;
	private int length;
	private float cost;

	public String getTitle() {
		return title;
	}
	public String getCategory() {
		return category;
	}
	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}
	public float getCost() {
		return cost;
	}
	
	
	//Create DVD by Title
	public DigitalVideoDisc_phucth(String title) {
		super();
		this.title = title;
	}
	//Create DVD by Title, Category, Cost
	public DigitalVideoDisc_phucth(String title, String category, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.cost = cost;
	}
	//Create DVD by Title, Category, Director, Cost
	public DigitalVideoDisc_phucth(String title, String category, String director, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.cost = cost;
	}
	//Create DVD by Title, Category, Director, Length, Cost
	public DigitalVideoDisc_phucth(String title, String category, String director, int length, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.length = length;
		this.cost = cost;
	}
}




