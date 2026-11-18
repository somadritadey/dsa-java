// create two stacks using a single array

import java.util.Scanner;

public class twoStacksInAnArray {
    public static class TwoStack {
        int[] data;
        int top1;
        int top2;
        public TwoStack(int n) {
            data = new int[n];
            top1 = -1;
            top2 = n;
        }

        int size1() {
            if(top1 == -1) {
                System.out.println("Stack 1 is empty");
                return -1;
            }
            else {
                return top1 + 1;
            }
        }
        int size2() {
            if(top2 == data.length) {
                System.out.println("Stack 2 is empty");
                return -1;
            }
            else {
                return data.length - top2;
            }
        }

        void push1(int val) {
            if(top2 == top1 + 1) {
                System.out.println("Stack Overflow");
            }
            else {
                top1++;
                data[top1] = val;
            }
        }
        void push2(int val) {
            if(top2 == top1 + 1) {
                System.out.println("Stack Overflow");
            }
            else {
                top2--;
                data[top2] = val;
            }
        }

        int pop1() {
            if(top1 == -1) {
                System.out.println("Stack Underflow");
                return -1;
            }
            else {
                int val = data[top1];
                top1--;
                return val;
            }
        }
        int pop2() {
            if(top2 == data.length) {
                System.out.println("Stack Underflow");
                return -1;
            }
            else {
                int val = data[top2];
                top2++;
                return val;
            }
        }

        int top1() {
            if(top1 == -1) {
                System.out.println("Stack Underflow");
                return -1;
            }
            else {
                return data[top1];
            }
        }
        int top2() {
            if(top2 == data.length) {
                System.out.println("Stack Underflow");
                return -1;
            }
            else {
                return data[top2];
            }
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter the size of array: ");
        int n = scn.nextInt();
        TwoStack st = new TwoStack(n);

        // do any operations
        st.push1(10);
        st.push1(20);
        st.push2(30);
        st.push2(40);
        st.push2(50);
        System.out.println(st.top1());
        System.out.println(st.top2());
        System.out.println(st.size1());
        System.out.println(st.size2());
        st.pop2();
        System.out.println(st.top2());
    }
}
