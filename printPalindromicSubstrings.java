// for a given string, print all it's palindromic substrings

import java.util.Scanner;

public class printPalindromicSubstrings {
    public static boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while(i <= j) {
            if(s.charAt(i) != s.charAt(j)) {
                return false;
            }
            else {
                i++;
                j--;
            }
        }
        return true;
    }

    public static void printPalindromes(String s) {
        for(int i = 0; i < s.length(); i++) {
            for(int j = i + 1; j < s.length(); j++) {
                String ss = s.substring(i, j);
                if(isPalindrome(ss)) {
                    System.out.println(ss);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter string: ");
        String str = scn.next();
        System.out.println("Palindromes are: ");
        printPalindromes(str);
    }
}
