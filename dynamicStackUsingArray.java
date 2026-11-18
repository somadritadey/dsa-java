// build a dynamic stack using array to eliminate overflow while push() operation is performed

import java.util.Scanner;

public class dynamicStackUsingArray {
    public static class CustomStack {
        int[] data;
        int tos; // top of stack

        public CustomStack(int n) {
            data = new int[n];
            tos = -1;
        }

        int size() {
            return tos + 1;
        }

        void display() {
            for(int i = tos; i >= 0; i--) {
                System.out.print(data[i] + " ");
            }
            System.out.println("");
        }

        void push(int val) {
            if(tos == data.length - 1) {
                // change in code from normal stack question
                int[] ndata = new int[2 * data.length];
                for(int i = 0; i < data.length; i++) {
                    ndata[i] = data[i];
                }
                data = ndata;
                tos++;
                data[tos] = val;
            }
            else {
                tos++;
                data[tos] = val;
            }
        }

        int pop() {
            if(tos == -1) {
                System.out.println("Stack Underflow");
                return -1;
            }
            else {
                int val = data[tos];
                tos--;
                return val;
            }
        }

        int top() {
            if(tos == -1) {
                System.out.println("Stack Underflow");
                return -1;
            }
            else {
                return data[tos];
            }
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter maximum size of stack: ");
        int n = scn.nextInt();
        CustomStack st = new CustomStack(n);

        // do any operations
        st.push(10);
        st.push(20);
        st.push(30);
        System.out.println(st.top());
    }
}
