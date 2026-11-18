// sort elements such that 0s come first, then 1s, then 2s
// 0 to j - 1 = 0s
// j to i - 1 = 1s
// i to k = unknown
// k + 1 to end = 2

import java.util.Scanner;

public class sort012 {
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void sort012(int[] arr) {
        int i = 0;
        int j = 0;
        int k = arr.length - 1;
        while(i <= k) {
            if(arr[i] == 0) {
                swap(arr, i, j);
                i++;
                j++;
            }
            else if(arr[i] == 1) {
                i++;
            }
            else {
                swap(arr, i, k);
                k--;
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
        sort012(arr);
        for(int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
