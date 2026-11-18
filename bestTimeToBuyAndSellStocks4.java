// for n days & prices of each day given, find max profit
// infinite transactions with 1 day minimum cooldown

import java.util.Scanner;

public class bestTimeToBuyAndSellStocks4 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = scn.nextInt();
        System.out.println("Enter the prices in each day: ");
        int[] prices = new int[n];
        for(int i = 0; i < n; i++) {
            prices[i] = scn.nextInt();
        }

        int obsp = -prices[0]; // old bought-state profit
        int ossp = 0; // old sold-state profit
        int ocsp = 0; // old cool-state profit
        for(int i = 1; i < n; i++) {
            int nbsp = 0; // new bought-state profit
            int nssp = 0; // new sold-state profit
            int ncsp = 0; // new cool-state profit
            nbsp = Math.max(obsp, ocsp - prices[i]);
            nssp = Math.max(ossp, obsp + prices[i]);
            ncsp = Math.max(ocsp, ossp);
            obsp = nbsp;
            ossp = nssp;
            ocsp = ncsp;
        }
        System.out.println("Maximum Profit: " + ossp);
    }
}
