package lab04;

import java.util.Scanner;

import hust.soict.dsai.aims.media.DigitalVideoDisc_phucth;
import hust.soict.dsai.aims.media.Media_phucth;
import hust.soict.dsai.aims.media.Playable_phucth;

public class Aims_phucth {
    private static Store_phucth store = new Store_phucth();
    private static Cart_phucth cart = new Cart_phucth();
    
    public static void main(String[] args) {
    	
    	DigitalVideoDisc_phucth dvd1 = 
    	        new DigitalVideoDisc_phucth("Doraemon", "Viễn tưởng", "Fujiko F. Fujio", 120, 20f);
    	DigitalVideoDisc_phucth dvd2 = 
    	        new DigitalVideoDisc_phucth("Conan", "Trinh thám", "Gosho Aoyama", 120, 50f);
    	DigitalVideoDisc_phucth dvd3 = 
    	        new DigitalVideoDisc_phucth("Shin - crayon boy", "Hài hước", "Yoshito Usui", 120, 10f);
    	DigitalVideoDisc_phucth dvd4 = 
    	        new DigitalVideoDisc_phucth("Miko", "Tình cảm", "Eriko Ono", 120, 40f);
    	DigitalVideoDisc_phucth dvd5 = 
    	        new DigitalVideoDisc_phucth("Dragonball", "Hành động", "Akira Toriyama", 120, 20f);
        
        //add 2 dvd
        cart.addMedia_phucth(dvd1);
        cart.addMedia_phucth(dvd2);
        cart.addMedia_phucth(dvd3);
        cart.addMedia_phucth(dvd4);
        cart.addMedia_phucth(dvd5);
        
        store.addMedia_phucth(dvd1);
        store.addMedia_phucth(dvd2);
        store.addMedia_phucth(dvd3);
        store.addMedia_phucth(dvd4);
        store.addMedia_phucth(dvd5);
    	
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            showMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (choice) {
                case 1:
                    viewStore(scanner);
                    break;
                case 2:
                    updateStore(scanner);
                    break;
                case 3:
                    seeCart(scanner);
                    break;
                case 0:
                    System.out.println("Exiting AIMS. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
            }
        } while (choice != 0);

        scanner.close();
    }
    
    //Show default menu
    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: ");
    }

    public static void viewStore(Scanner scanner) {
        store.printItemsInStore(); // Display all media in the store
        int choice;

        do {
            storeMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (choice) {
                case 1:
                    seeMediaDetails(scanner);
                    break;
                case 2:
                    addMediaToCart(scanner);
                    break;
                case 3:
                    playMedia(scanner);
                    break;
                case 4:
                    cart.printItemsInCart(); // Display cart details
                    break;
                case 0:
                    System.out.println("Returning to main menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
            }
        } while (choice != 0);
    }

    public static void storeMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media’s details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");
    }

    public static void seeMediaDetails(Scanner scanner) {
        System.out.println("Enter the title of the media:");
        String title = scanner.nextLine();
        Media_phucth media = store.searchByTitle(title);
        
        if (media != null) {
            System.out.println(media.toString());
            mediaDetailsMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (choice) {
                case 1:
                    cart.addMedia_phucth(media);
                    break;
                case 2:
                    if (media instanceof Playable_phucth) {
                        ((Playable_phucth) media).play();
                    } else {
                        System.out.println("This media cannot be played.");
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } else {
            System.out.println("Media not found.");
        }
    }

    public static void mediaDetailsMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }

    public static void addMediaToCart(Scanner scanner) {
        System.out.println("Enter the title of the media to add to cart:");
        String title = scanner.nextLine();
        Media_phucth media = store.searchByTitle(title);

        if (media != null) {
            cart.addMedia_phucth(media);
        } else {
            System.out.println("Media not found.");
        }
    }

    public static void playMedia(Scanner scanner) {
        System.out.println("Enter the title of the media to play:");
        String title = scanner.nextLine();
        Media_phucth media = store.searchByTitle(title);

        if (media != null) {
            if (media instanceof Playable_phucth) {
                ((Playable_phucth) media).play();
            } else {
                System.out.println("This media cannot be played.");
            }
        } else {
            System.out.println("Media not found.");
        }
    }

    public static void updateStore(Scanner scanner) {
        System.out.println("Enter 1 to add media, 2 to remove media:");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (choice == 1) {
            // Code to add media
            System.out.println("Enter media details (title, category, cost):");
            String title = scanner.nextLine();
            String category = scanner.nextLine();
            float cost = scanner.nextFloat();
            scanner.nextLine(); // Consume newline
            store.addMedia_phucth(new Media_phucth(title, category, cost));
        } else if (choice == 2) {
            // Code to remove media
            System.out.println("Enter the title of the media to remove:");
            String title = scanner.nextLine();
            store.removeMedia_phucth(title);
        } else {
            System.out.println("Invalid choice.");
        }
    }
    
    private static void filter(Scanner scanner) {
        System.out.println("1. Filter by ID");
        System.out.println("2. Filter by title");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Đọc bỏ dòng trống sau nextInt()
        
        switch (choice) {
            case 1:
                System.out.print("Nhập ID cần tìm: ");
                int id = scanner.nextInt();
                scanner.nextLine(); // Đọc bỏ dòng trống sau nextInt()
                Media_phucth media1 = cart.searchById(id);
                if (media1 != null) {
                    System.out.println(media1.toString());
                } else {
                    System.out.println("Không tìm thấy media với ID: " + id);
                }
                break;
            case 2:
                System.out.print("Nhập title cần tìm: ");
                String title = scanner.nextLine();
                Media_phucth media2 = cart.searchByTitle(title);
                if (media2 != null) {
                    System.out.println(media2.toString());
                } else {
                    System.out.println("Không tìm thấy media với title: " + title);
                }
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ!");
        }
    }

    
    private static void sort(Scanner scanner) {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Sort medias in cart by title");
        System.out.println("2. Sort medias in cart by cost");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
        
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:{
            	cart.sortByTitleCost();
            	cart.printItemsInCart(); // Display cart details
            	break;
            }
            case 2: {
            	cart.sortByCostTitle();
            	cart.printItemsInCart(); // Display cart details
            	break;
            }
            case 0: return;
            default:
                System.out.println("Lựa chọn không hợp lệ!");
        }
    }
    
    private static void dlt(Scanner scanner) {
        System.out.println("Enter ID to delete: ");
        int choice = scanner.nextInt();
        cart.removeMedia_phucth(choice);
    }
    
    private static void placeOrder() {
    	System.out.println("Your order is submitted!");
    	cart.emptyMedia_phucth();
    }
    

    public static void seeCart(Scanner scanner) {
        cart.printItemsInCart(); // Display cart details
        int choice;

        do {
            cartMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (choice) {
                case 1:
                    filter(scanner);
                    break;
                case 2:
                    sort(scanner);
                    break;
                case 3:
                    dlt(scanner);
                    break;
                case 4:
                    playMedia(scanner);
                    break;
                case 5:
                    placeOrder();
                    break;
                case 0:
                    System.out.println("Returning to main menu...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }

    public static void cartMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");
    }
}
