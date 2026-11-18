// inverse an array (exchange positions with values and vice-versa)

import java.util.Scanner;

public class inverseArray {
    public static int[] inverseArray(int[] arr) {
        int[] inv = new int[arr.length];
        for(int i = 0; i < arr.length; i++) {
            int v = arr[i];
            inv[v] = i;
        }
        return inv;
    }

    public static void displayArray(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter number of elements of array: ");
        int n = scn.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter elements of array: ");
        for(int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        System.out.println("Inverse Of Array: ");
        displayArray(inverseArray(arr));
    }
}
