package lab01;

import java.util.Scanner;

public class Matrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows, columns;
        System.out.print("Please enter the numbers of row: ");
        rows = scanner.nextInt();
        System.out.print("Please enter the numbers of column: ");
        columns = scanner.nextInt();
        double[][] firstMatrix = new double[rows][columns];
        double[][] secondMatrix = new double[rows][columns];

        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                System.out.print("Enter A" + "[" + (i+1) + "]" + "[" + (j+1) + "]: ") ;
                firstMatrix[i][j] = scanner.nextDouble();
            }
        }

        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                System.out.print("Enter B" + "[" + (i+1) + "]" + "[" + (j+1) + "]: ") ;
                secondMatrix[i][j] = scanner.nextDouble();
            }
        }

        double[][] sum = new double[rows][columns];
        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                sum[i][j] = firstMatrix[i][j] + secondMatrix[i][j];
            }
        }

        System.out.println("Sum: ");
        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                System.out.print(sum[i][j] + "   ");
            }
            System.out.println();
        }

        scanner.close();
    }
}
