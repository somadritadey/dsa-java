// for n days & prices of each day given, find max profit
// 2 transactions allowed

import java.util.Scanner;

public class bestTimeToBuyAndSellStocks5 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = scn.nextInt();
        System.out.println("Enter the prices in each day: ");
        int[] prices = new int[n];
        for(int i = 0; i < n; i++) {
            prices[i] = scn.nextInt();
        }

        int mpist = 0; // max profit if sold today
        int lsf = prices[0];
        int[] dpl = new int[n];
        for(int i = 1; i < n; i++) {
            lsf = Math.min(lsf, prices[i]);
            mpist = prices[i] - lsf;
            dpl[i] = Math.max(mpist, dpl[i - 1]);
        }
        int mpibt = 0; // max profit if sold today
        int msf = prices[n - 1];
        int[] dpr = new int[n];
        for(int i = n - 2; i >= 0; i--) {
            msf = Math.max(msf, prices[i]);
            mpibt = msf - prices[i];
            dpr[i] = Math.max(mpibt, dpr[i + 1]);
        }
        int op = 0;
        for(int i = 0; i < n; i++) {
            op = Math.max(op, dpl[i] + dpr[i]);
        }
        System.out.println("Maximum Profit: " + op);
    }
}
