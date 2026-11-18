// find index / indices of any given element in an array, if not found return -1

import java.util.Scanner;

public class findElementInArray {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter the number of elements: ");
        int n = scn.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements: ");
        for(int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        System.out.println("Enter the element you want to find: ");
        int d = scn.nextInt();

        System.out.println("Index is: ");
        int index = -1;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == d) {
                index = i;
                System.out.println(index);
            }
        }
        if(index == -1) {
            System.out.println(index);
        }
    }
}
