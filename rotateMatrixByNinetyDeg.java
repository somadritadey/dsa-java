// rotate square matrix elements by 90 degree clockwise

import java.util.Scanner;

public class rotateMatrixByNinetyDeg {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter the number of rows / columns: ");
        int m = scn.nextInt();
        int[][] arr = new int[m][m];
        System.out.println("Enter elements: ");
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < m; j++) {
                arr[i][j] = scn.nextInt();
            }
        }
        // transpose
        for(int i = 0; i < arr.length; i++) {
            for(int j = i; j < arr[0].length; j++) { // j from i as already swapped no.s do not need to be swapped again
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
        // reverse columns
        for(int i = 0; i < arr.length; i++) {
            int li = 0;
            int ri = arr[0].length - 1;
            while(li < ri) {
                int temp = arr[i][li];
                arr[i][li] = arr[i][ri];
                arr[i][ri] = temp;
                li++;
                ri--;
            }
        }
        System.out.println("Displaying elements: ");
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < m; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
