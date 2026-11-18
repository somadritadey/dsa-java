// sort elements using bubble sort

import java.util.Scanner;

public class bubbleSort {
    public static void swap(int[] arr, int i, int j) {
        System.out.println("Swapping" + arr[i] + "and" + arr[j]);
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static boolean isSmaller(int[] arr, int i, int j) {
        System.out.println("Comparing" + arr[i] + "and" + arr[j]);
        if(arr[i] < arr[j]) {
            return true;
        }
        else {
            return false;
        }
    }
    public static void bubbleSort(int[] arr) {
        for(int itr = 1; itr <= arr.length - 1; itr++) {
            for(int j = 0; j < arr.length - itr; j++) {
                if(isSmaller(arr, j + 1, j)) {
                    swap(arr, j + 1, j);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = scn.nextInt();
        System.out.println("Enter elements: ");
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        System.out.println("Sorted array: ");
        bubbleSort(arr);
        for(int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
