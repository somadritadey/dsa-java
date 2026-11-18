// saddle point of matrix (min. in row & max. in column)

import java.util.Scanner;

public class saddlePointOfMatrix {
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
        System.out.println("Saddle Point: ");
        for(int i = 0; i < arr.length; i++) {
            // minimum in row
            int svj = 0; // smallest valued element's j
            for(int j = 1; j < arr[0].length; j++) {
                if(arr[i][j] < arr[i][svj]) {
                    svj = j; // update smallest valued element's j
                }
            }
            // check for maximum in column
            boolean flag = true;
            for(int k = 0; k < arr.length; k++) {
                if(arr[k][svj] > arr[i][svj]) {
                    flag = false;
                    break;
                }
            }
            if(flag == true) {
                System.out.println(arr[i][svj]);
                return;
            }
        }
    }
}
