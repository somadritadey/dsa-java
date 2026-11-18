// find k largest elements of an array

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class kLargestElementsInArray {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = scn.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements: ");
        for(int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        System.out.print("Enter the value of k: ");
        int k = scn.nextInt();

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int val: arr) {
            pq.add(val);
        }
        for(int i = 0; i < k; i++) {
            System.out.println(pq.remove());
        }
    }
}