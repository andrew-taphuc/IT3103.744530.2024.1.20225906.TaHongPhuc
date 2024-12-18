package hust.soict.dsai.aims.media;

public class Track_phucth implements Playable_phucth{
	private String title;
	private int length;
	
	
	public String getTitle() {
		return title;
	}
	public int getLength() {
		return length;
	}


	public Track_phucth() {
		// TODO Auto-generated constructor stub
		super();
	}

	// Create Track with title and length
	public Track_phucth(String title, int length) {
		super();
		this.title = title;
		this.length = length;
	}
	public void play() {
		System.out.println("Playing Track: " + this.getTitle());
		System.out.println("Track length: " + this.getLength());
	}
	
	@Override
	public boolean equals(Object obj_phucth) {
	    // Check if the object is null or not an instance of Track
	    if (this == obj_phucth) {
	        return true; // If they refer to the same object, they are equal
	    }
	    if (obj_phucth == null || !(obj_phucth instanceof Track_phucth)) {
	        return false; // Not equal if the object is null or not a Track
	    }
	    
	    // Cast obj to Track and compare their titles and lengths
	    Track_phucth other = (Track_phucth) obj_phucth;
	    return this.title.equals(other.title) && this.length == other.length;
	}

}
