// return all subsets of elements in array that add upto a given target sum

import java.util.Scanner;

public class targetSumSubsets {
    // tar = target; set = subset; sos = sum of subsets
    public static void printTargetSumSubsets(int[] arr, int idx, String set, int sos, int tar) {
        if(idx == arr.length) {
            if(sos == tar) {
                System.out.println(set + ".");
            }
            return;
        }
        printTargetSumSubsets(arr, idx + 1, set + arr[idx] + ", ", sos + arr[idx], tar);
        printTargetSumSubsets(arr, idx + 1, set, sos, tar);
    }
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        int n = scn.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements: ");
        for(int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        System.out.print("Enter target sum: ");
        int tar = scn.nextInt();
        printTargetSumSubsets(arr, 0, "", 0, tar);
    }
}
