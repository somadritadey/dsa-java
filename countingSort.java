// sort elements using counting sort

import java.util.Scanner;

public class countingSort {
    public static void countingSort(int[] arr, int min, int max) {
        int range = max - min + 1;
        int[] farr = new int[range];
        for(int i = 0; i < arr.length; i++) {
            int idx = arr[i] - min;
            farr[idx]++;
        }
        for(int i = 1; i < farr.length; i++) {
            farr[i] += farr[i - 1];
        }

        int[] ans = new int[arr.length];
        for(int i = arr.length - 1; i >= 0; i--) {
            int val = arr[i];
            int pos = farr[val - min];
            int idx = pos - 1;
            ans[idx] = val;
            farr[val - min]--;
        }
        for(int i = 0; i < ans.length; i++) {
            arr[i] = ans[i];
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = scn.nextInt();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        System.out.println("Enter elements: ");
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }
        System.out.println("Sorted array: ");
        countingSort(arr, min, max);
        for(int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
