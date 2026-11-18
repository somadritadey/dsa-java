// get the subsequence of a given string

import java.util.ArrayList;
import java.util.Scanner;

public class getSubsequenceOfString {
    public static ArrayList<String> getSS(String str) { // ex.- abc
        if(str.length() == 0) {
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }
        char ch = str.charAt(0); // a
        String secondPart = str.substring(1); // bc
        ArrayList<String> rres = getSS(secondPart); // recursion for bc, then c and so on
        ArrayList<String> mres = new ArrayList<>(); // final result where _ and a are added to bc subsequence
        for(String rstr: rres) {
            mres.add("_" + rstr);
        }
        for(String rstr: rres) {
            mres.add(ch + rstr);
        }
        return mres;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter the string: ");
        String str = scn.next(); // next for string and nextline for char
        System.out.println("Subsequence: ");
        ArrayList<String> res = getSS(str);
        System.out.println(res);
    }
}
