// sort dates in an array given in DDMMYYYY format

import java.util.Scanner;

public class sortDates {
    public static void countSort(String[] arr, int div, int mod, int range) {
        int[] farr = new int[range];
        for(int i = 0; i < arr.length; i++) {
            int idx = Integer.parseInt(arr[i], 10) / div % mod;
            farr[idx]++;
        }
        for(int i = 1; i < farr.length; i++) {
            farr[i] += farr[i - 1];
        }

        String[] ans = new String[arr.length];
        for(int i = arr.length - 1; i >= 0; i--) {
            int val = Integer.parseInt(arr[i], 10) / div % mod;
            int pos = farr[val];
            int idx = pos - 1;
            ans[idx] = arr[i];
            farr[val]--;
        }
        for(int i = 0; i < ans.length; i++) {
            arr[i] = ans[i];
        }
    }

    public static void sortDates(String[] arr) {
        countSort(arr, 1000000, 100, 32); // days
        countSort(arr, 10000, 100, 13); // months
        countSort(arr, 1, 10000, 2501); // years
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter number of dates: ");
        int n = scn.nextInt();
        String[] arr = new String[n];
        System.out.println("Enter elements: ");
        for(int i = 0; i < n; i++) {
            arr[i] = scn.next();
        }
        sortDates(arr);
        System.out.println("Elements are: ");
        for(String str : arr) {
            System.out.println(str);
        }
    }
}
