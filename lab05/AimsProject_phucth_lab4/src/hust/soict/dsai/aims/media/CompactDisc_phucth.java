package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc_phucth extends Disc_phucth implements Playable_phucth{
	private String artist;
	private List<Track_phucth> tracks_phucth = new ArrayList<Track_phucth>();
	private static int nbCD_phucth = 0;
	
	public String getArtist() {
		return artist;
	}
	
	//Default constructor
	public CompactDisc_phucth() {
		super();
	}

	// Create CD with title, category, artist and cost
	public CompactDisc_phucth(String title, String category, String artist, float cost) {
		super();
		nbCD_phucth++;
		setId(nbCD_phucth);
		setTitle(title);
		setCategory(category);
		this.artist=artist;
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
		System.out.println("Playing CD: " + this.getTitle());
		System.out.println("Number of track: " + tracks_phucth.size());
		
		for (int i = 0; i < tracks_phucth.size(); i++) {
            System.out.print("Track " + (i + 1) + ": ");
            tracks_phucth.get(i).play(); // Call the play method of each Track
        }
	}
}
