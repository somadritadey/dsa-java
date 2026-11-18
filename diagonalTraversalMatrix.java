// print elements of upper triangle of matrix diagonally

import java.util.Scanner;

public class diagonalTraversalMatrix {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter number of rows / columns: ");
        int m = scn.nextInt();
        int[][] arr = new int[m][m];
        System.out.println("Enter elements: ");
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < m; j++) {
                arr[i][j] = scn.nextInt();
            }
        }
        System.out.println("Upper Traingle of Matrix: ");
        for(int count = 0; count < m; count++) {
            int i = 0;
            int j = count;
            while(i < m && j < m) {
                System.out.println(arr[i][j]);
                i++;
                j++;
            }
        }
    }
}
