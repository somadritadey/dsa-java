// sort elements using insertion sort

import java.util.Scanner;

public class insertionSort {
    public static void swap(int[] arr, int i, int j) {
        System.out.println("Swapping" + arr[i] + "and" + arr[j]);
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static boolean isGreater(int[] arr, int i, int j) {
        System.out.println("Comparing" + arr[i] + "and" + arr[j]);
        if(arr[i] > arr[j]) {
            return true;
        }
        else {
            return false;
        }
    }
    public static void insertionSort(int[] arr) {
        for(int i = 1; i < arr.length; i++) {
            for(int j = i - 1; j >= 0; j--) {
                if(isGreater(arr, j, j + 1)) {
                    swap(arr, j, j + 1);
                }
                else {
                    break;
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
        insertionSort(arr);
        for(int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
