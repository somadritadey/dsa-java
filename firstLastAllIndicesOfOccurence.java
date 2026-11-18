// find first, last and all indices of occurence of given element in an array

import java.util.Scanner;

public class firstLastAllIndicesOfOccurence {
    public static int firstIndex(int[] arr, int idx, int d) {
        if(idx == arr.length - 1) {
            return idx;
        }
        if(arr[idx] == d) {
            return idx;
        }
        else {
            int fi = firstIndex(arr, idx + 1, d);
            return fi;
        }
    }

    public static int lastIndex(int[] arr, int idx, int d) {
        if(idx == arr.length) {
            return -1;
        }
        int li = lastIndex(arr, idx + 1, d);
        if(li != -1) {
            return li;
        }
        else if(arr[idx] == d) {
            return idx;
        }
        else {
            return -1;
        }
    }

    public static int[] allIndices(int[] arr, int idx, int d, int fsf) { // fsf is no. of elements found so far
        if(idx == arr.length) {
            return new int[fsf];
        }
        if(arr[idx] == d) {
            int[] iarr = allIndices(arr, idx + 1, d, fsf + 1);
            iarr[fsf] = idx;
            return iarr;
        }
        else {
            int[] iarr = allIndices(arr, idx + 1, d, fsf);
            return iarr;
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter the number of elements in array: ");
        int n = scn.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of array: ");
        for(int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        System.out.println("Enter the element whose occurence indices are to be found: ");
        int d = scn.nextInt();
        System.out.println("First Index of Occurence: " + firstIndex(arr, 0, d));
        System.out.println("Last Index of Occurence: " + lastIndex(arr, 0, d));
        System.out.println("All Indices of Occurence: ");
        int[] allIdx = allIndices(arr, 0, d, 0);
        for(int i = 0; i < allIdx.length; i++) {
            System.out.print(allIdx[i] + " ");
        }
    }
}
