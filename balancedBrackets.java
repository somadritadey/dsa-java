// print true if balanced brackets are present, else print false

import java.util.Scanner;
import java.util.Stack;

public class balancedBrackets {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter the expression: ");
        String str = scn.nextLine();

        Stack<Character> st = new Stack<>();

        boolean val = true;
        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            }
            else if (ch == ')') {
                if(st.size() == 0) {
                    val = false;
                    break;
                }
                else if(st.peek() != '(') {
                    val = false;
                    break;
                }
                else {
                    st.pop();
                }
            }
            else if (ch == '}') {
                if(st.size() == 0) {
                    val = false;
                    break;
                }
                else if(st.peek() != '{') {
                    val = false;
                    break;
                }
                else {
                    st.pop();
                }
            }
            else if (ch == ']') {
                if(st.size() == 0) {
                    val = false;
                    break;
                }
                else if(st.peek() != '[') {
                    val = false;
                    break;
                }
                else {
                    st.pop();
                }
            }
        }
        if(st.peek() != null) {
            val = false;
        }
        System.out.println("Balanced Brackets? ");
        System.out.println(val);
    }
}
