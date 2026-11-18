// multiply two matrices

import java.util.Scanner;

public class matrixMultiplication {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter first row: ");
        int r1 = scn.nextInt();
        System.out.println("Enter first column: ");
        int c1 = scn.nextInt();
        int[][] one = new int[r1][c1];
        System.out.println("Enter elements in first matrix: ");
        for(int i = 0; i < r1; i++) {
            for(int j = 0; j < c1; j++) {
                one[i][j] = scn.nextInt();
            }
        }
        System.out.println("Enter second row: ");
        int r2 = scn.nextInt();
        System.out.println("Enter second column: ");
        int c2 = scn.nextInt();
        int[][] two = new int[r2][c2];
        System.out.println("Enter elements in second matrix: ");
        for(int i = 0; i < r2; i++) {
            for(int j = 0; j < c2; j++) {
                two[i][j] = scn.nextInt();
            }
        }

        // if invalid
        if(c1 != r2) {
            System.out.println("Invalid Input!");
            return;
        }
        
        // if valid
        int[][] mul = new int[r1][c2];
        for(int i = 0; i < mul.length; i++) { // no. of rows of mul[][]
            for(int j = 0; j < mul[0].length; j++) { // no. of columns of mul[][]
                for(int k = 0; k < c1; k++) { // no. of columns c1 in one[][] or rows r2 in two[][]
                    mul[i][j] += one[i][k] * two[k][j];
                }
            }
        }
        // display
        System.out.println("Displaying the multiplied matrix: ");
        for(int i = 0; i < mul.length; i++) {
            for(int j = 0; j < mul[0].length; j++) {
                System.out.print(mul[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
