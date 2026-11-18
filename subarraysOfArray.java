// print all subarrays of a given array

import java.util.Scanner;

public class subarraysOfArray {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter number of elements of array: ");
        int n = scn.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter elements of array: ");
        for(int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        System.out.println("Subarrays of given array: ");
        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                for(int k = i; k <= j; k++) {
                    System.out.print(arr[k] + " ");
                }
                System.out.println("");
            }
        }
    }
}
