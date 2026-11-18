// infix, prefix, postfix evaluation and conversions

import java.util.Scanner;
import java.util.Stack;

public class infixPrefixPostfix {
    public static int precedence(char operator) {
        if(operator == '+' || operator == '-') {
            return 1;
        }
        else if(operator == '*' || operator == '/') {
            return 2;
        }
        else {
            return 0;
        }
    }

    public static int operation(int v1, int v2, char operator) {
        if(operator == '+') {
            return v1 + v2;
        }
        else if(operator == '-') {
            return v1 - v2;
        }
        else if(operator == '*') {
            return v1 * v2;
        }
        else if(operator == '/') {
            return v1 / v2;
        }
        else {
            return 0;
        }
    }
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter the expression: ");
        String str = scn.nextLine();

        // infix evaluation
        /*
        Stack<Integer> operands = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch == '(') {
                operators.push(ch);
            }
            else if(Character.isDigit(ch)) {
                operands.push(ch - '0'); // ch - '0' converts char number to real integer
            }
            else if(ch == ')') {
                while(operators.peek() != '(') {
                    char operator = operators.pop();
                    int v2 = operands.pop();
                    int v1 = operands.pop();
                    int op = operation(v1, v2, operator);
                    operands.push(op);
                }
                operators.pop();
            }
            else if(ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                while(operators.size() > 0 && operators.peek() != '(' && precedence(ch) <= precedence(operators.peek())) {
                    char operator = operators.pop();
                    int v2 = operands.pop();
                    int v1 = operands.pop();
                    int op = operation(v1, v2, operator);
                    operands.push(op);
                }
                operators.push(ch);
            }
        }
        // for remaining operations in stacks
        while(operators.size() != 0) {
            char operator = operators.pop();
            int v2 = operands.pop();
            int v1 = operands.pop();
            int op = operation(v1, v2, operator);
            operands.push(op);
        }

        System.out.println("Infix Value: ");
        System.out.println(operands.peek());
        */

        // infix conversions to prefix and postfix
        /*
        Stack<String> pre = new Stack<>();
        Stack<String> post = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch == '(') {
                operators.push(ch);
            }
            else if((ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch >= 'Z')) {
                // "" converts to string
                pre.push(ch + "");
                post.push(ch + "");
            }
            else if(ch == ')') {
                while(operators.peek() != '(') {
                    char op = operators.pop();
                    String prev2 = pre.pop();
                    String prev1 = pre.pop();
                    String prev = op + prev1 + prev2;
                    pre.push(prev);
                    String post2 = post.pop();
                    String post1 = post.pop();
                    String postv = post1 + post2 + op;
                    post.push(postv);
                }
                operators.pop();
            }
            else if(ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                while(operators.size() > 0 && operators.peek() != '(' && precedence(ch) <= precedence(operators.peek())) {
                    char op = operators.pop();
                    String prev2 = pre.pop();
                    String prev1 = pre.pop();
                    String prev = op + prev1 + prev2;
                    pre.push(prev);
                    String post2 = post.pop();
                    String post1 = post.pop();
                    String postv = post1 + post2 + op;
                    post.push(postv);
                }
                operators.push(ch);
            }
        }
        while(operators.size() != 0) {
            char op = operators.pop();
            String prev2 = pre.pop();
            String prev1 = pre.pop();
            String prev = op + prev1 + prev2;
            pre.push(prev);
            String post2 = post.pop();
            String post1 = post.pop();
            String postv = post1 + post2 + op;
            post.push(postv);
        }

        System.out.println("Prefix value: ");
        System.out.println(pre.peek());
        System.out.println("Postfix value: ");
        System.out.println(post.peek());
        }
        */

        // postfix evaluation and conversion
        /*
        Stack<Integer> values = new Stack<>();
        Stack<String> infix = new Stack<>();
        Stack<String> prefix = new Stack<>();

        for(int i = 0; i < str.length(); i ++) {
            char ch = str.charAt(i);
            if(ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                int v2 = values.pop();
                int v1 = values.pop();
                int val = operation(v1, v2, ch);
                values.push(val);
                String inv2 = infix.pop();
                String inv1 = infix.pop();
                String inval = '(' + inv1 + ch + inv2 + ')';
                infix.push(inval);
                String prev2 = prefix.pop();
                String prev1 = prefix.pop();
                String preval = ch + prev1 + prev2;
                prefix.push(preval);
            }
            else {
                values.push(ch - '0');
                infix.push(ch + "");
                prefix.push(ch + "");
            }
        }

        System.out.println("Value: ");
        System.out.println(values.pop());
        System.out.println("Infix expression: ");
        System.out.println(infix.pop());
        System.out.println("Prefix expression: ");
        System.out.println(prefix.pop());
        }
        */

        // prefix evaluation and conversion
        /*
        Stack<Integer> values = new Stack<>();
        Stack<String> infix = new Stack<>();
        Stack<String> postfix = new Stack<>();

        for(int i = str.length() - 1; i >= 0; i --) {
            char ch = str.charAt(i);
            if(ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                int v1 = values.pop();
                int v2 = values.pop();
                int val = operation(v1, v2, ch);
                values.push(val);
                String inv1 = infix.pop();
                String inv2 = infix.pop();
                String inval = '(' + inv1 + ch + inv2 + ')';
                infix.push(inval);
                String postv1 = postfix.pop();
                String postv2 = postfix.pop();
                String postval = postv1 + postv2 + ch;
                postfix.push(postval);
            }
            else {
                values.push(ch - '0');
                infix.push(ch + "");
                postfix.push(ch + "");
            }
        }

        System.out.println("Value: ");
        System.out.println(values.pop());
        System.out.println("Infix expression: ");
        System.out.println(infix.pop());
        System.out.println("Postfix expression: ");
        System.out.println(postfix.pop());
        */
    }
}
