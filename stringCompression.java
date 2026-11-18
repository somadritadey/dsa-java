// compress string:
// 1. aaabbcadd -> abcad
// 2. aaabbcadd -> a3b2cad2

import java.util.Scanner;

public class stringCompression {
    public static String comp1(String str) {
        String s = str.charAt(0) + "";
        for(int i = 1; i < str.length(); i++) {
            char curr = str.charAt(i);
            char prev = str.charAt(i - 1);
            if(curr != prev) {
                s += curr;
            }
        }
        return s;
    }

    public static String comp2(String str) {
        String s = str.charAt(0) + "";
        int count = 1;
        for(int i = 1; i < str.length(); i++) {
            char curr = str.charAt(i);
            char prev = str.charAt(i - 1);
            if(curr == prev) {
                count++;
            }
            else {
                if(count > 1) {
                    s += count;
                    count = 1;
                }
                s += curr;
            }
        }
        if(count > 1) {
            s += count;
        }
        return s;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter the string: ");
        String str = scn.next();
        System.out.println(comp1(str));
        System.out.println(comp2(str));
    }
}
