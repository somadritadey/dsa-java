// print subsets of given array

import java.util.Scanner;

public class subsetsOfArray {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter number of elements of array: ");
        int n = scn.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter elements of array: ");
        for(int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        System.out.println("Subsets of given array: ");
        int limit = (int)Math.pow(2, arr.length);
        for(int i = 0; i < limit; i++) {
            // convert i to binary and use 0's and 1's
            String set = "";
            int temp = i;
            for(int j = arr.length - 1; j >= 0; j--) {
                int r = temp % 2;
                temp = temp / 2;
                if(r == 0) {
                    set = "-" + set;
                }
                else {
                    set = arr[j] + set;
                }
            }
            System.out.println(set);
        }
    }
}
