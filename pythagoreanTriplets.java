// check if a given set of numbers follow the pythagoras formula or not (in true or false)

import java.util.Scanner;

public class pythagoreanTriplets {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter three numbers: ");
        int a = scn.nextInt();
        int b = scn.nextInt();
        int c = scn.nextInt();

        int max = a;
        if(b > max) {
            max = b;
        }
        if(c > max) {
            max = c;
        }

        System.out.println("Are they a Pythagoream Triplet? ");
        if(max == a) {
            boolean flag = ((b*b) + (c*c) == (a*a));
            System.out.println(flag);

        }
        else if(max == b) {
            boolean flag = ((a*a) + (c*c) == (b*b));
            System.out.println(flag);
        }
        else {
            boolean flag = ((a*a) + (b*b) == (c*c));
            System.out.println(flag);
        }
    }
}
