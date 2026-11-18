// print true if unnecessary duplicate brackets are present, else print false

import java.util.Scanner;
import java.util.Stack;

public class duplicateBrackets {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter the expression: ");
        String str = scn.nextLine();

        Stack<Character> st = new Stack<>();

        boolean val = false;
        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch == ')') {
                if(st.peek() == '(') {
                    val = true;
                    break;
                }
                else {
                    while(st.peek() != '(') {
                        st.pop();
                    }
                    st.pop();
                }
            }
            else {
                st.push(ch);
            }
        }
        System.out.println("Duplicate Brackets? ");
        System.out.println(val);
    }
}
