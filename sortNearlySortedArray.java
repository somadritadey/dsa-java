// sort an array where each element is displaced by upto k positions at max

import java.util.PriorityQueue;
import java.util.Scanner;

public class sortNearlySortedArray {
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

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i <= k; i++) { // for a total of k + 1 elements
            pq.add(arr[i]);
        }
        System.out.println("Sorted Array: ");
        for(int i = k + 1; i < n; i++) {
            System.out.println(pq.remove());
            pq.add(arr[i]); // add the current element to pq
        }
        while(pq.size() > 0) {
            System.out.println(pq.remove());
        }
    }
}
