// remove all primes from arraylist

import java.util.ArrayList;
import java.util.Scanner;

public class removePrimesFromArraylist {
    public static boolean isPrime(int myNum) {
        if(myNum == 0 || myNum == 1) {
            return false;
        }
        else if(myNum == 2) {
            return true;
        }
        int count = 0;
        for(int div = 2; div * div <= myNum; div++) {
            if(myNum % div == 0) {
                count++;
                break;
            }
        }
        if(count == 0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter no. of elements: ");
        int n = scn.nextInt();
        System.out.println("Enter elements: ");
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            int val = scn.nextInt();
            list.add(val);
        }
        
        for(int i = n - 1; i >= 0; i--) {
            int val = list.get(i);
            if(isPrime(val)) {
                list.remove(i);
            }
        }
    }
}
