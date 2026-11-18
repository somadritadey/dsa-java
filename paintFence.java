// find no. of ways to paint n fences with k colors such that not more than 2 consecutive fences are of same color

import java.util.Scanner;

public class paintFence {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter the number of fences: ");
        int n = scn.nextInt();
        System.out.print("Enter the number of colors: ");
        int k = scn.nextInt();
        
        long same = k;
        long different = k * (k - 1);
        long total = same + different;
        for(int i = 3; i <= n; i++) {
            same = different;
            different = total * (k - 1);
            total = same + different;
        }
        System.out.println("Number of ways: " + total);
    }
}
