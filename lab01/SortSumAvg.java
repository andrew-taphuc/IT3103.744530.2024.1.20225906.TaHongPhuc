package lab01;

import java.util.Arrays;
import java.util.Scanner;

public class SortSumAvg {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        int size = scanner.nextInt();
        int[] arr = new int[size];

        for(int i=0; i<size; i++) {
            System.out.print("Enter the " + (i+1) + " element: ");
            arr[i] = scanner.nextInt();
        }

        System.out.println("Your array: " + Arrays.toString(arr));

        Arrays.sort(arr);
        
        int sum = 0;
        for(int i = 0; i < size; i++) {
            sum += arr[i];
        }

        System.out.println("Sorted array: " + Arrays.toString(arr));
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + (double)sum/size);

        scanner.close();
    }
}
