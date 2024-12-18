package hust.soict.dsai.aims.media;

public class Disc_phucth extends Media_phucth{
	private String director;
	private int length;
	
	
	public String getDirector() {
		return director;
	}

	public int getLength() {
		return length;
	}
	
	public Disc_phucth() {
        super();
    }
    // Create Disk with title
    public Disc_phucth(String title) {
        super();
        setTitle(title);
    }
    
    // Create Disk with title, category, cost
    public Disc_phucth(String title, String category, float cost) {
        super();
        setTitle(title);
        setCategory(category);
        setCost(cost);
    }
    
    // Create Disk with title, category, director, length, cost
    public Disc_phucth(String title, String category, String director, int length, float cost) {
        super();
        setTitle(title);
        setCategory(category);
        this.director = director;
        this.length = length;
        setCost(cost);
    }
}
