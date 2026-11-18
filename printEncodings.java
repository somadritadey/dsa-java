// encode a string of numbers to alphabetical corresponding strings

import java.util.Scanner;

public class printEncodings {
    public static void printEncodings(String ques, String ans) {
        if(ques.length() == 0) { // found answer
            System.out.println(ans);
            return;
        }
        else if(ques.length() == 1) { // single digit code to be encoded
            char ch = ques.charAt(0);
            if(ch == '0') {
                return;
            }
            else {
                int chv = ch - '0';
                char code = (char)('a' + chv - 1); // convert number to its corresponding character
                ans = ans + code;
                System.out.println(ans);
            }
        }
        else { // two or more digits to be encoded
            char ch = ques.charAt(0);
            String roq = ques.substring(1);
            if(ch == '0') {
                return;
            }
            else {
                int chv = ch - '0';
                char code = (char)('a' + chv - 1);
                printEncodings(roq, ans + code);
            }
            String ch12 = ques.substring(0, 2);
            String roq12 = ques.substring(2);
            int ch12v = Integer.parseInt(ch12);
            if(ch12v <= 26) {
                char code = (char)('a' + ch12v - 1);
                printEncodings(roq12, ans + code);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter the string: ");
        String str = scn.next();
        printEncodings(str, "");
    }
}
