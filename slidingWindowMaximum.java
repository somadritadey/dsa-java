// for window size k, find maximum element in each window of array

import java.util.Scanner;
import java.util.Stack;

public class slidingWindowMaximum {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter the number of elements: ");
        int n = scn.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements: ");
        for(int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        System.out.println("Enter the window size: ");
        int k = scn.nextInt();

        Stack<Integer> st = new Stack<>();
        int[] nge = new int[n];
        st.push(n - 1);
        nge[n - 1] = n;
        for(int i = n - 2; i >= 0; i--) {
            while(st.size() > 0 && arr[i] >= arr[st.peek()]) {
                st.pop();
            }
            if(st.size() == 0) {
                nge[i] = n;
            }
            else {
                nge[i] = st.peek();
            }
            st.push(i);
        }

        System.out.println("Maximum in each window: ");
        int j = 0;
        for(int i = 0; i <= n - k; i++) {
            // loop finds maximum of each window
            if(j < i) {
                // if j wasn't able to reach end element of current window, for new window update it
                j = i;
            }
            while(nge[j] < i + k) {
                // it means that nge is within the current window, and we must go to nge now
                j = nge[j];
            }
            System.out.println(arr[j]);
        }
    }
}
