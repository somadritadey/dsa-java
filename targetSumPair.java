// find pairs in an array which add upto a target sum

import java.util.Arrays;
import java.util.Scanner;

public class targetSumPair {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = scn.nextInt();
        System.out.println("Enter the elements: ");
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        System.out.print("Enter the target: ");
        int target = scn.nextInt();

        Arrays.sort(arr); // takes o(nlogn)
        int left = 0;
        int right = arr.length - 1;
        System.out.println("Pairs are: ");
        while(left < right) {
            if(arr[left] + arr[right] < target) {
                left++;
            }
            else if(arr[left] + arr[right] > target) {
                right--;
            }
            else {
                System.out.println(arr[left] + " - " + arr[right]);
                left++;
                right--;
            }
        }
    }
}
