// for n, if there is 1 in ith row jth column, i knows j. find celebrity (knows no one, known by all)

import java.util.Scanner;
import java.util.Stack;

public class celebrityProblem {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter the number: ");
        int n = scn.nextInt();
        int[][] arr = new int[n][n];
        System.out.println("Enter the elements: ");
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                arr[i][j] = scn.nextInt();
            }
        }

        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < arr.length; i++) {
            st.push(i);
        }
        while(st.size() >= 2) {
            int i = st.pop();
            int j = st.pop();
            if(arr[i][j] == 1) {
                // i knows j, so i is not celebrity
                st.push(j);
            }
            else {
                // i does not know j, so j is not celebrity
                st.push(i);
            }
        }
        // remaining row in stack has potential to be a celebrity
        int potential = st.pop();
        boolean value = true;
        for(int i = 0; i < arr.length; i++) {
            if(i != potential) {
                if(arr[i][potential] == 0) {
                    value = false;
                    break;
                }
            }
        }
        System.out.println("Celebrity");
        if(value == true) {
            System.out.println(potential);
        }
        else {
            System.out.println("None");
        }
    }
}
