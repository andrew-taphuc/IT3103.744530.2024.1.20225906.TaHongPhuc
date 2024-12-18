package CoHoa;

import java.util.ArrayList;
import java.util.List;

public class SchoolManagement_5906 extends Child_5906{
	private List<Child_5906> childMana_5906 = new ArrayList<Child_5906>();
	
	// Them 1 chau vao danh sach
	public void addChild_5906(Child_5906 c){
		if(!childMana_5906.contains(c)) {
			childMana_5906.add(c);
			System.out.println("Them hoc sinh thanh cong!");
		}
		else {
			System.out.println("Hoc sinh da ton tai tren he thong!");
		}
	}
	
	// Hien thi tat ca cac chau
	public void displayAll_5906() {
		System.out.println("Hien thi thong tin - Ta Hong Phuc - 20225906");
        System.out.println("Danh sach hoc sinh:");
        for(int i = 0; i < childMana_5906.size(); i++) {
        	Child_5906 c = childMana_5906.get(i);
            System.out.printf(c.toString() + '\n');
            
        }
	}
	
	
	
	// Tim chau theo ten
	public Child_5906 searchByName(String name) {
		int n = childMana_5906.size();
        for (int i = 0; i < n; i++) {
            if (childMana_5906.get(i).isMatch(name)) {
                return childMana_5906.get(i); // Return the matching media
            }
        }
        return null; // Return null if no match is found
	}
}


