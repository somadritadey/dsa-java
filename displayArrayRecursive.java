// print array elements in normal order & in reverse using recursion

import java.util.Scanner;

public class displayArrayRecursive {
    public static void displayNormal(int[] arr, int idx) {
        if(idx == arr.length) {
            return;
        }
        System.out.print(arr[idx] + " ");
        displayNormal(arr, idx + 1);
    }

    public static void displayReverse(int[] arr, int idx) {
        if(idx == arr.length) {
            return;
        }
        displayReverse(arr, idx + 1);
        System.out.print(arr[idx] + " ");
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter number of elements in array: ");
        int n = scn.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the array elements: ");
        for(int i = 0; i < n; i ++) {
            arr[i] = scn.nextInt();
        }
        System.out.print("Normal: ");
        displayNormal(arr, 0);
        System.out.println("");
        System.out.print("Reverse: ");
        displayReverse(arr, 0);
    }
}
