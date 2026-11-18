// input n numbers and check if each number is prime or not

import java.util.Scanner;

public class primeNumber {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter the number of values to be entered: ");
        int n = scn.nextInt();

        for(int i = 1; i <= n; i++) {
            System.out.println("Enter a number: ");
            int myNum = scn.nextInt();

            if(myNum == 0 || myNum == 1) {
                System.out.println("Not Valid");
            }
            else if(myNum == 2) {
                System.out.println("Prime Number");
            }
            else {
            int count = 0;
            for(int div = 2; div*div <= myNum; div++) {
                if(myNum % div == 0) {
                    count++;
                    break;
                }
            }

            if(count == 0) {
                System.out.println("Prime Number");
            }
            else {
                System.out.println("Composite Number");
            }
            }
        }
    }
}
