// print first element on right of the current element which is greater than it

import java.util.Scanner;
import java.util.Stack;

public class nextGreaterElementOnRight {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter the number of elements: ");
        int n = scn.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements: ");
        for(int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int[] nge = new int[arr.length];
        Stack<Integer> st = new Stack<>();

        st.push(arr[n - 1]);
        nge[n - 1] = -1;
        for(int i = n - 2; i >= 0; i--) {
            while(st.size() > 0 && arr[i] >= st.peek()) {
                st.pop();
            }
            if(st.size() == 0) {
                nge[i] = -1;
            }
            else {
                nge[i] = st.peek();
            }
            st.push(arr[i]);
        }

        System.out.println("Next Greatest Elements are: ");
        for(int i = 0; i < n; i++) {
            System.out.println(nge[i]);
        }
    }
}
