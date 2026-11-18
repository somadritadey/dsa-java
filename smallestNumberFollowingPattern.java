// for a pattern upto 8 length containing i & d (increasing and decreasing), print smallest number
// digits cannot be repeated, d for decreasing digits and i for increasing digits

import java.util.Scanner;
import java.util.Stack;

public class smallestNumberFollowingPattern {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter the expression (8 length of ds & is only): ");
        String str = scn.nextLine();

        System.out.println("Number is: ");
        Stack<Integer> st = new Stack<>();
        int num = 1; // keeps count and avoids repetition
        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch == 'd') {
                st.push(num);
                num++;
            }
            else {
                st.push(num);
                num++;
                while(st.size() > 0) {
                    System.out.print(st.pop());
                }
            }
        }
        st.push(num);
        while(st.size() > 0) {
            System.out.print(st.pop());
        }
    }
}
