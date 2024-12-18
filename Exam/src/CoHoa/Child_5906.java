package CoHoa;

public class Child_5906 {
	String name_5906;
	int age_5906;
	String className_5906;
	
	
	public Child_5906() {
		// TODO Auto-generated constructor stub
	}
	
	public String getName_5906() {
		return name_5906;
	}

	public void setName_5906(String name_5906) {
		this.name_5906 = name_5906;
	}

	public int getAge_5906() {
		return age_5906;
	}

	public void setAge_5906(int age_5906) {
		this.age_5906 = age_5906;
	}

	public String getClassName_5906() {
		return className_5906;
	}

	public void setClassName_5906(String className_5906) {
		this.className_5906 = className_5906;
	}

	// Constructor to initialize the fields
    public Child_5906(String name_5906, int age_5906, String className_5906) {
        this.name_5906 = name_5906;
        this.age_5906 = age_5906;
        this.className_5906 = className_5906;
    }
    
    public boolean isMatch(String title) {
        if (getName_5906() == null) {
            return false;
        }
        return getName_5906().equalsIgnoreCase(title);
    }
    
    @Override
    public String toString() {
        return String.format("Hoc sinh %s, %d tuoi, lop %s", 
            name_5906 , 
            age_5906, 
            className_5906);
    }
    
    public void displayInfo() {
        System.out.println("THONG TIN HOC SINH");
        System.out.println("------------------");
        System.out.println("Ten: " + (name_5906 != null ? name_5906 : "Chua co ten"));
        System.out.println("Tuoi: " + age_5906);
        System.out.println("Lop: " + (className_5906 != null ? className_5906 : "Chua phan lop"));
    }
}
