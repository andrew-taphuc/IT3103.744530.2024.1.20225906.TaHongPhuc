package lab01;
import java.util.Scanner;

public class DayMonth {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập năm:");
        int year = scanner.nextInt();
        while(year < 0){
            System.out.println("Vui lòng nhập năm hợp lệ: ");
            year = scanner.nextInt();
        }
        scanner.nextLine();
        System.out.println("Nhập tháng:");
        String month = scanner.nextLine();
        
        
        while (true) {
            switch (month) {
                case "1","3","5","7","8","10","12":
                case "Jan", "Mar", "May", "Jul", "Aug", "Oct", "Dec":
                case "Jan.", "Mar.", "May.", "Jul.", "Aug.", "Oct.", "Dec.":
                case "January", "March", "July", "August", "October", "December":
                    System.out.println(String.format("There is 31 days", year));
                    break;
                case "4","6","9","11":
                case "Apr", "Jun", "Sep", "Nov":
                case "Apr.", "Jun.", "Sep.", "Nov.":
                case "April", "June", "September", "November":
                    System.out.println(String.format("There is 30 days", year));
                    break;
                case "2", "Feb", "Feb.", "Febuary":
                    {
                        if (year % 4 == 0){
                            if (year % 100 == 0 && year % 400 != 0){
                                System.out.println(String.format("There is 28 days", year));
                            }
                            else System.out.println(String.format("There is 29 days", year));
                        }
                        else System.out.println(String.format("There is 28 days", year));
                    }
                    break;
                default:{
                    System.out.println("Vui lòng nhập tháng hợp lệ: ");
                    month = scanner.nextLine();
                }
            }
            scanner.close();
            return ;
        }
    }
}




