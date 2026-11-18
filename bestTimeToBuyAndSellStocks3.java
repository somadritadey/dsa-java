// for n days & prices of each day given, find max profit
// infinite transactions with transaction fee

import java.util.Scanner;

public class bestTimeToBuyAndSellStocks3 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = scn.nextInt();
        System.out.println("Enter the prices in each day: ");
        int[] prices = new int[n];
        for(int i = 0; i < n; i++) {
            prices[i] = scn.nextInt();
        }
        System.out.print("Enter the transaction fee: ");
        int fee = scn.nextInt();

        int obsp = -prices[0]; // old bought-state profit
        int ossp = 0; // old sold-state profit
        for(int i = 1; i < n; i++) {
            int nbsp = 0; // new bought-state profit
            int nssp = 0; // new sold-state profit
            if(ossp - prices[i] > obsp) {
                nbsp = ossp - prices[i];
            }
            else {
                nbsp = obsp;
            }
            if(obsp + prices[i] - fee > ossp) {
                nssp = obsp + prices[i] - fee;
            }
            else {
                nssp = ossp;
            }
            obsp = nbsp;
            ossp = nssp;
        }
        System.out.println("Maximum Profit: " + ossp);
    }
}
