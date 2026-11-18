// print all prime numbers in a given range (low to high)

import java.util.Scanner;

public class printAllPrimesInRange {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter the lower value in range: ");
        int low = scn.nextInt();
        System.out.println("Enter the higher value in range: ");
        int high = scn.nextInt();

        System.out.println("All the prime numbers in range are: ");
        for(int i = low; i <= high; i++) {
            if(i == 0 || i == 1) {
                continue;
            }
            else if(i == 2) {
                System.out.println(i);
            }
            else {
                int count = 0;
                for(int div = 2; div*div <= i; div++) {
                    if(i % div == 0) {
                        count++;
                        break;
                    }
                }
                if(count == 0) {
                    System.out.println(i);
                }
            }
        }
    }
}
