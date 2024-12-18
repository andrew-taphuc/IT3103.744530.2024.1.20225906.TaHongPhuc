package CoHoa;

import java.util.Scanner;

public class quanly_5906 {
	private static SchoolManagement_5906 mana_5906 = new SchoolManagement_5906();

	public static void main(String[] args) {
		
		Child_5906 c1 = new PreSchooler_5906("John", 5, "AA", "Kate");
		Child_5906 c2 = new PreSchooler_5906("Ki", 5, "AA", "Bo");
		Child_5906 c3 = new Kindergarten_5906("Koko", 3, "BB", "Nat");
		Child_5906 c4 = new Kindergarten_5906("Bubu", 2, "BB", "Ket");
		Child_5906 c5 = new Kindergarten_5906("Jiji", 1, "BB", "Hi");
		
		mana_5906.addChild_5906(c1);
		mana_5906.addChild_5906(c2);
		mana_5906.addChild_5906(c3);
		mana_5906.addChild_5906(c4);
		mana_5906.addChild_5906(c5);
		
		Scanner scanner = new Scanner(System.in);
        int choice;
        
        do {
            showMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (choice) {
                case 1:
                    menuAdd(scanner);
                    break;
                case 2:
                    showAll();
                    break;
                case 3:
                    findName(scanner);
                    break;
                case 4:
                    System.out.println("Thoát khỏi chương trình - Tạ Hồng Phúc - 744530");
                    break;
                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
            }
        } while (choice != 4);
        scanner.close();
	}
	
	public static void findName(Scanner scanner) {
		System.out.print("Nhập tên cần tìm: ");
        String name = scanner.nextLine();
        Child_5906 ccc = mana_5906.searchByName(name);
        if (ccc != null) {
            System.out.println(ccc.toString());
        } else {
            System.out.println("Không tìm thấy");
        }
	}
	
	public static void showAll() {
        mana_5906.displayAll_5906();
	}
	
	public static void showMenu() {
        System.out.println("--------------------------------------------------------------------------------------");

        System.out.println("Quản lý các cháu trường mầm non - 20225906 - Tạ hồng Phúc - kỳ 2024.1 - Ngày XX");
        System.out.println("1. Thêm cháu( ít nhất 5 cháu, bao gồm Mầm non (1 -> 3 tuổi), Mẫu giáo (4 -> 5 tuổi");
        System.out.println("2. Hiển thị danh sách tất cả các cháu");
        System.out.println("3. Tìm kiếm và hiển thị thông tin Cháu từ bàn phím");
        System.out.println("4. Thoát - Tạ Hồng Phúc - 20225906");
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("Lựa chọn: ");
        

    }
	
	public static void menuAdd(Scanner scanner) {
        System.out.println("Nhập dữ liệu - Tạ Hồng Phúc - 20225906");
        System.out.println("--------------------------------");
        System.out.println("a. Thêm Preschooler_5906");
        System.out.println("b. Thêm Kindergarten_5906");
        
        String choice = scanner.nextLine();

        switch (choice.toLowerCase()) {
            case "a":
                addPreschooler(scanner);
                break;
            case "b":
                addKindergarten(scanner);
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
                break;
        }
    }
        
        private static void addPreschooler(Scanner scanner) {
            System.out.print("Họ tên _5906: ");
            String name = scanner.nextLine();
            System.out.print("Tuổi_5906: ");
            int age = scanner.nextInt();
            scanner.nextLine(); 
            System.out.print("Lớp_5906: ");
            String className = scanner.nextLine();
            System.out.print("Người giám hộ_5906");
            String guardian = scanner.nextLine();
            mana_5906.addChild_5906(new PreSchooler_5906(name, age, className, guardian));
            mana_5906.displayAll_5906();
        }

        private static void addKindergarten(Scanner scanner) {
        	System.out.print("Họ tên _5906: ");
            String name = scanner.nextLine();
            System.out.print("Tuổi_5906: ");
            int age = scanner.nextInt();
            scanner.nextLine(); 
            System.out.print("Lớp_5906: ");
            String className = scanner.nextLine();
            System.out.print("Đồ chơi yêu thích_5906: ");
            String favoriteToy = scanner.nextLine();
            mana_5906.addChild_5906(new Kindergarten_5906(name, age, className, favoriteToy));
            mana_5906.displayAll_5906();
        }
}
