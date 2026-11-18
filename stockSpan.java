// print difference between current day anf first day before today, when price was higher than today

import java.util.Scanner;
import java.util.Stack;

public class stockSpan {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter the number of days: ");
        int n = scn.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the prices: ");
        for(int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int[] span = new int[n];
        Stack<Integer> st = new Stack<>();

        st.push(0); // to print indexes, we must push index and not element
        span[0] = 1;
        for(int i = 1; i < n; i++) {
            while(st.size() > 0 && arr[i] >= arr[st.peek()]) {
                st.pop();
            }
            if(st.size() == 0) {
                span[i] = i + 1;
            }
            else {
                span[i] = i - st.peek();
            }
            st.push(i);
        }

        System.out.println("Stock Span: ");
        for(int i = 0; i < n; i++) {
            System.out.println(span[i]);
        }
    }
}
