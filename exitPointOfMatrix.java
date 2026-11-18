// to find exit point of matrix, where traversal is such that on 0 encounter, normal traversal and on 1 encounter, turn right by 90 degrees

import java.util.Scanner;

public class exitPointOfMatrix {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter the number of rows: ");
        int m = scn.nextInt();
        System.out.println("Enter the number of columns: ");
        int n = scn.nextInt();
        int[][] arr = new int[m][n];
        System.out.println("Enter elements: ");
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                arr[i][j] = scn.nextInt();
            }
        }
        System.out.println("Exit Point: ");
        // 0 e, 1 s, 2 w, 3 n
        int dir = 0;
        int i = 0;
        int j = 0;
        while(true) {
            dir = (dir + arr[i][j]) % 4; // if it is 1, only then 1 will be added to dir and then mod
            if(dir == 0) {
                j++;
            }
            else if(dir == 1) {
                i++;
            }
            else if(dir == 2) {
                j--;
            }
            else if(dir == 3) {
                i--;
            }
            if(i < 0) {
                i++;
                break;
            }
            else if(j < 0) {
                j++;
                break;
            }
            else if(i == arr.length) {
                i--;
                break;
            }
            else if(j == arr[0].length) {
                j--;
                break;
            }
        }
        System.out.print(i + ", " + j);
    }
}
