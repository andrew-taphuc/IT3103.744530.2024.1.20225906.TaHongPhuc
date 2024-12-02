package hust.soict.dsai.aims.media;
import java.util.List; // Import the List interface
import java.util.ArrayList; // Import the ArrayList class

public class Book_phucth extends Media_phucth{
	private List<String> authors = new ArrayList<String>();
	
	
	public Book_phucth() {
		// TODO Auto-generated constructor stub
	}
	
	public void addAuthor(String authorName) {
		if(!authors.contains(authorName)) {	
			authors.add(authorName);
			System.out.println("Author " + authorName +" added successfully!");
		}
		else {
			System.out.println("Author already exists!");
		}
	}

	public void removeAuthor(String authorName) {
		if(!authors.contains(authorName)) {
			authors.remove(authorName);
			System.out.println("Author " + authorName +" removed!");
		}
		else {
			System.out.println("Author do not exist.");
		}
	}
}



