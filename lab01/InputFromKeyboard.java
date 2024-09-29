package lab01;

import java.util.Scanner;

public class InputFromKeyboard {
    public static void main(String[] args) {
        Scanner sacnner = new Scanner(System.in);
        System.out.println("Please enter your name: ");
        String name = sacnner.nextLine();
        System.out.println("How old are you? ");
        int age = sacnner.nextInt();
        System.out.println("How tall are you? (cm) ");
        double height = sacnner.nextDouble();

        System.out.println("I am Hong Phuc, Hi " + name + ", " + age + " years old, your heigt is " + height + "cm.");

        sacnner.close();
    }
}
