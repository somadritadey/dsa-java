// rotate a number n, k times. if k +ve, right rotate and if k -ve, left rotate
// ex.- 23157 for +2, 57231
// ex.- 23157 for -2, 15723

import java.util.Scanner;

public class rotateNumber {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter number to be rotated: ");
        int n = scn.nextInt();
        System.out.println("Enter number of times of rotation: ");
        int k = scn.nextInt();

        int dig = 0;
        int temp = n;
        while(temp != 0) {
            temp = temp / 10;
            dig++;
        }

        k = k % dig;
        if(k < 0) {
            k = k + dig;
        }

        int div = (int)Math.pow(10, k);
        int mul = (int)Math.pow(10, dig - k);

        int q = n / div;
        int r = n % div;

        int rot = r * mul + q;
        System.out.println("The rotatated number is: ");
        System.out.println(rot);
    }
}
