// print all possible permutations of a given string

import java.util.Scanner;

public class printPermutationsOfString {
    public static void printPermutations(String ques, String ans) {
        if(ques.length() == 0) {
            System.out.println(ans);
            return;
        }
        for(int i = 0; i < ques.length(); i++) {
            char ch = ques.charAt(i);
            String roq = ques.substring(0, i) + ques.substring(i + 1);
            printPermutations(roq, ans + ch);
        }
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter the string: ");
        String str = scn.next();
        printPermutations(str, "");
    }
}
