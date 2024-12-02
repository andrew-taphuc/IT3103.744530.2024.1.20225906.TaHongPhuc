package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc_phucth extends Disc_phucth{
	private String artist;
	private List<Track_phucth> tracks_phucth = new ArrayList<Track_phucth>();
	
	public String getArtist() {
		return artist;
	}
	//Default constructor
	public CompactDisc_phucth() {
		// TODO Auto-generated constructor stub
		super();
	}
	// Create CD with ID and title
	public CompactDisc_phucth(int id, String title) {
		super();
		setId(id);
		setTitle(title);
	}
	// Create CD with ID, title and category
	public CompactDisc_phucth(int id, String title, String category) {
		super();
		setId(id);
		setTitle(title);
		setCategory(category);
	}
	// Create CD with ID, title, category and cost
	public CompactDisc_phucth(int id, String title, String category, float cost) {
		super();
		setId(id);
		setTitle(title);
		setCategory(category);
		setCost(cost);
	}
	public void addTrack(Track_phucth track) {
		if(!tracks_phucth.contains(track)) {
			tracks_phucth.add(track);
			System.out.println("Track added successfully!");
		}
		else {
			System.out.println(track + " already exists!");
		}
	} 
	public void removeTrack(Track_phucth track) {
		if(tracks_phucth.contains(track)) {
			tracks_phucth.remove(track);
			System.out.println("Track removed!");
		}
		else {
			System.out.println(track + " not exist!");
		}
	} 

	public int getLength(){
		int totalLength = 0;
		for(Track_phucth track: tracks_phucth) {
			totalLength += track.getLength();
		}
		return totalLength;
	}
	
	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("Number of track: " + tracks_phucth.size());
		
		for (int i = 0; i < tracks_phucth.size(); i++) {
            System.out.print("Track " + (i + 1) + ": ");
            tracks_phucth.get(i).play(); // Call the play method of each Track
        }
	}
}
