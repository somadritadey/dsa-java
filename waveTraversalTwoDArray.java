// wave traversal of 2D array

import java.util.Scanner;

public class waveTraversalTwoDArray {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter number of rows: ");
        int m = scn.nextInt();
        System.out.println("Enter number of columns: ");
        int n = scn.nextInt();
        int[][] arr = new int[m][n];
        System.out.println("Enter the elements: ");
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                arr[i][j] = scn.nextInt();
            }
        }
        // display as wave traversal
        System.out.println("Wave Traversal: ");
        for(int j = 0; j < arr[0].length; j++) { // same no. of column
            if(j % 2 == 0) { // even column
                for(int i = 0; i < arr.length; i++) {
                    System.out.println(arr[i][j]);
                }
            }
            else { // odd column
                for(int i = arr.length - 1; i >= 0; i--) {
                    System.out.println(arr[i][j]);
                }
            }
        }
    }
}
