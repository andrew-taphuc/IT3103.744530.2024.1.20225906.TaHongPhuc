package hust.soict.dsai.aims.media;

import java.util.Comparator;

public class Media_phucth {
	
	public static final Comparator<Media_phucth> COMPARE_BY_TITLE_COST = 
			new MediaComparatorByTitleCost();
	
	public static final Comparator<Media_phucth> COMPARE_BY_COST_TITLE = 
			new MediaComparatorByCostTitle();
	
	private int id;
	private String title;
	private String category;
	private float cost;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}
	//Default constructor
	public Media_phucth() {
		// TODO Auto-generated constructor stub
	}
    // Constructor with title
    public Media_phucth(String title) {
        this(title, "", 0.0f);
    }

    // Constructor with title and category
    public Media_phucth(String title, String category) {
        this(0, title, category, 0.0f);
    }

    // Constructor with title, category, and cost
    public Media_phucth(String title, String category, float cost) {
        this(0, title, category, cost);
    }
	public Media_phucth(int id, String title, String category, float cost) {
		this.id = id;
		this.title = title;
		this.category = category;
		this.cost = cost;
	}

	public boolean isMatch(String title) {
        if (getTitle() == null) {
            return false;
        }
        return getTitle().equalsIgnoreCase(title);
    }
	
	@Override
	public boolean equals(Object obj_phucth) {
	    // Check if the object is null or not an instance of Media
	    if (this == obj_phucth) {
	        return true; // If they refer to the same object, they are equal
	    }
	    if (obj_phucth == null || !(obj_phucth instanceof Media_phucth)) {
	        return false; // Not equal if the object is null or not a Media
	    }

	    // Cast obj to Media and compare their titles and costs
	    Media_phucth other = (Media_phucth) obj_phucth;
	    return this.title.equals(other.title) && this.cost == other.cost;
	}

	
	
	// Overriding toString() method
    @Override
    public String toString() {
        return "Media_phucth{" +
                "title='" + title + '\'' +
                ", cost=" + cost +
                '}';
    }
    
    
}

