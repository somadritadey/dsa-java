// for n given elements of an array, find span of array (maximum element - minimum element of array)

import java.util.Scanner;

public class spanOfArray {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter the number of elements: ");
        int n = scn.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements: ");
        for(int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }

        int max = arr[0];
        int min = arr[0];
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
            if(arr[i] < min) {
                min = arr[i];
            }
        }

        System.out.println("Span of array: ");
        int span = max - min;
        System.out.println(span);
    }
}
