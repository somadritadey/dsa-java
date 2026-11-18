// sort elements such that 0s come first, then 1s
// 0 to j - 1 = 0s
// j to i - 1 = 1s
// i to end = unknown

import java.util.Scanner;

public class sort01 {
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void sort01(int[] arr) {
        int i = 0;
        int j = 0;
        while(i < arr.length) {
            if(arr[i] == 1) {
                i++;
            }
            else {
                swap(arr, i, j);
                i++;
                j++;
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
        sort01(arr);
        for(int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
