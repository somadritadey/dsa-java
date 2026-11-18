// search for an element in a sorted matrix

import java.util.Scanner;

public class searchInSortedMatrix {
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
        System.out.println("Enter element to be searched for: ");
        int key = scn.nextInt();
        // first go to (0, arr[0].length - 1)th element = x
        // if arr[i][j] = key then stop right there
        // if arr[i][j] < key, go down
        // if arr[i][j] > key, go left
        System.out.println("Position of this element: ");
        int i = 0;
        int j = arr[0].length - 1;
        while(i < arr.length && j >= 0) {
            if(arr[i][j] == key) {
                System.out.println(i);
                System.out.println(j);
                return;
            }
            else if(arr[i][j] > key) {
                j--;
            }
            else {
                i++;
            }
        }
        System.out.println("Not Found!");
    }
}
