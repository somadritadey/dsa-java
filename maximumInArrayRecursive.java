// recursively find the maximum element in an array

import java.util.Scanner;

public class maximumInArrayRecursive {
    public static int maxInArray(int[] arr, int idx) {
        if(idx == arr.length - 1) {
            return arr[idx];
        }
        int max = maxInArray(arr, idx + 1);
        if(max > arr[idx]) {
            return max;
        }
        else {
            return arr[idx];
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter number of elements: ");
        int n = scn.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter array elements: ");
        for(int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int maximum = maxInArray(arr, 0);
        System.out.println("Maximum Element: " + maximum);
    }
}
