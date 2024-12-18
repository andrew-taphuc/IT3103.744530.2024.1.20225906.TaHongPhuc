package CoHoa;

public class PreSchooler_5906 extends Child_5906{
	String guardian_5906;
	public PreSchooler_5906() {
		// TODO Auto-generated constructor stub
	}
	
	public String getGuardian_5906() {
		return guardian_5906;
	}

	public void setGuardian_5906(String guardian_5906) {
		this.guardian_5906 = guardian_5906;
	}
	
	public PreSchooler_5906(String name, int age, String className, String guardian) {
        this.name_5906 = name;
        this.age_5906 = age;
        this.className_5906 = className;
        this.guardian_5906 = guardian;
    }

    @Override
    public String toString() {
        return "Preschooler_20225906  " + super.toString() + String.format(", nguoi giam ho: %s", 
            guardian_5906 != null ? guardian_5906 : "Chua co thong tin");
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Nguoi giam ho: " + (guardian_5906 != null ? guardian_5906 : "Chua co thong tin"));
    }

}
