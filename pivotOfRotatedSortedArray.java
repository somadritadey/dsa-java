// find pivot (smallest element) of rotated sorted array

import java.util.Scanner;

public class pivotOfRotatedSortedArray {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = scn.nextInt();
        System.out.println("Enter the elements: ");
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int lo = 0;
        int hi = n - 1;
        while(lo < hi) {
            int mid = (lo + hi) / 2;
            if(arr[mid] < arr[hi]) {
                hi = mid;
            }
            else {
                lo = mid + 1;
            }
        }
        System.out.println("Pivot: " + arr[hi]);
    }
}
