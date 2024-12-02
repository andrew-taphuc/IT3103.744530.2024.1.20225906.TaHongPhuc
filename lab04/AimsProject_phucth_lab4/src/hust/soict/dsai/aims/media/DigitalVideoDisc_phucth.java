package hust.soict.dsai.aims.media;

public class DigitalVideoDisc_phucth extends Disc_phucth implements Playable_phucth{
	private String director;
	private int length;
	private static int nbDVD_phucth = 0;
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
	
	//Create DVD by Title
	public DigitalVideoDisc_phucth(String title) {
		super();
		setTitle(title);
		nbDVD_phucth++;
		setId(nbDVD_phucth);
	}
	//Create DVD by Title, Category, Cost
	public DigitalVideoDisc_phucth(String title, String category, float cost) {
		super();
        setTitle(title);
        setCategory(category); 
        setCost(cost);
        nbDVD_phucth++;
        setId(nbDVD_phucth);
	}
	//Create DVD by Title, Category, Director, Cost
	public DigitalVideoDisc_phucth(String title, String category, String director, float cost) {
		super();
        setTitle(title);
        setCategory(category);
        setDirector(director);
        setCost(cost);
        nbDVD_phucth++;
        setId(nbDVD_phucth);
	}
	//Create DVD by Title, Category, Director, Length, Cost
	public DigitalVideoDisc_phucth(String title, String category, String director, int length, float cost) {
		super();
        setTitle(title);
        setCategory(category);
        setDirector(director);
        setLength(length);
        setCost(cost);
        nbDVD_phucth++;
        setId(nbDVD_phucth);
	}
	
	// Check Title    
	public boolean isMatch(String title) {
        if (getTitle() == null) {
            return false;
        }
        return getTitle().equalsIgnoreCase(title);
    }
	
	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
	}
	
	@Override
    public String toString() {
        return "DVD_phucth{" +
                "director='" + director + '\'' +
                ", length=" + length +
                '}' + super.toString();
    }
    
}








