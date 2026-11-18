// create MinStack class with two stacks, all data and min data. apart from normal functions, ass min()
// next is same but with one data stack and another min variable

import java.util.Stack;

public class minStack {
    // normal
    /*public static class MinStack {
        Stack<Integer> ad; // all data stack
        Stack<Integer> md; // min data stack
        public MinStack() {
            ad = new Stack<>();
            md = new Stack<>();
        }
        int size() {
            return ad.size();
        }
        void push(int val) {
            ad.push(val);
            if(md.size() == 0 || val <= md.peek()) {
                md.push(val);
            }
        }
        int pop() {
            if(size() == 0) {
                System.out.println("Stack Underflow");
                return -1;
            }
            else {
                int val = ad.pop();
                if(val == md.peek()) {
                    md.pop();
                }
                return val;
            }
        }
        int top() {
            if(size() == 0) {
                System.out.println("Stack Underflow");
                return -1;
            }
            else {
                return ad.peek();
            }
        }
        int min() {
            if(size() == 0) {
                System.out.println("Stack Underflow");
                return -1;
            }
            else {
                return md.peek();
            }
        }
    }*/

    // constant space
    /*public static class MinStack {
        Stack<Integer> data;
        int min = -1;
        public MinStack() {
            data = new Stack<>();
        }
        int size() {
            return data.size();
        }
        void push(int val) {
            if(data.size() == 0) {
                data.push(val);
                min = val;
            }
            else if(val >= min) {
                data.push(val);
            }
            else {
                data.push(val + val - min); // val - min is -ve; we're storing fake value here
                min = val;
            }
        }
        int pop() {
            if(size() == 0) {
                System.out.println("Stack Underflow");
                return -1;
            }
            else {
                int val = data.pop();
                if(val >= min) {
                    return val;
                }
                else {
                    int oldmin = min;
                    min = 2 * min - data.peek();
                    return oldmin;
                }
            }
        }
        int top() {
            if(size() == 0) {
                System.out.println("Stack Underflow");
                return -1;
            }
            else {
                if(data.peek() >= min) {
                    return data.peek();
                }
                else {
                    return min;
                }
            }
        }
        int min() {
            if(size() == 0) {
                System.out.println("Stack Underflow");
                return -1;
            }
            else {
                return min;
            }
        }
    }*/
    
    public static void main(String[] args) {
        //MinStack st = new MinStack();

        // do any operations
        /*st.push(10);
        st.push(20);
        st.push(30);
        st.push(5);
        System.out.println(st.size());
        System.out.println(st.min());*/
    }
}
