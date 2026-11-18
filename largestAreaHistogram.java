// for array elements representing bar chart, find largest area of possible rectangle

import java.util.Scanner;
import java.util.Stack;

public class largestAreaHistogram {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter the number of days: ");
        int n = scn.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the prices: ");
        for(int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        // arrays of index of nse (next smallest element)
        int[] rb = new int[n]; // right boundary is index of nse on right
        int[] lb = new int[n]; // left boundary is index of nse on left

        Stack<Integer> st = new Stack<>();
        st.push(n - 1);
        rb[n - 1] = n;
        for(int i = n - 2; i >= 0; i--) {
            while(st.size() > 0 && arr[i] < arr[st.peek()]) {
                st.pop();
            }
            if(st.size() == 0) {
                rb[i] = n;
            }
            else {
                rb[i] = st.peek();
            }
            st.push(i);
        }
        st = new Stack<>();
        st.push(0);
        lb[0] = -1;
        for(int i = 1; i < n; i++) {
            while(st.size() > 0 && arr[i] < arr[st.peek()]) {
                st.pop();
            }
            if(st.size() == 0) {
                lb[i] = -1;
            }
            else {
                lb[i] = st.peek();
            }
            st.push(i);
        }

        int maxArea = 0;
        for(int i = 0; i < n; i++) {
            int width = rb[i] - lb[i] - 1;
            int area = arr[i] * width;
            if(area > maxArea) {
                maxArea = area;
            }
        }
        System.out.println("Largest Area of Histogram is: ");
        System.out.println(maxArea);
    }
}
