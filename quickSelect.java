// find kth smallest element in an array using quick select algorithm

import java.util.Scanner;

public class quickSelect {
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static int partition(int[] arr, int pivot, int lo, int hi) {
        int i = lo;
        int j = lo;
        while(i < hi) {
            if(arr[i] > pivot) {
                i++;
            }
            else {
                swap(arr, i, j);
                i++;
                j++;
            }
        }
        swap(arr, j, hi); // place pivot in its correct position
        return j; // pivot index
    }

    public static int quickSelect(int[] arr, int lo, int hi, int k) {
        int pivot = arr[hi];
        int pi = partition(arr, pivot, lo, hi);
        if(k > pi) {
            return quickSelect(arr, pi + 1, hi, k);
        }
        else if(k < pi) {
            return quickSelect(arr, lo, pi - 1, k);
        }
        else {
            return arr[pi];
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
        System.out.print("Enter k: ");
        int k = scn.nextInt();
        System.out.println("Sorted array: ");
        int element = quickSelect(arr, 0, arr.length - 1, k - 1);
        System.out.println(k + "th smallest element: " + element);
    }
}
