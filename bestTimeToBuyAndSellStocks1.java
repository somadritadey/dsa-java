// for n days & prices of each day given, find max profit
// only 1 single transaction allowed

import java.util.Scanner;

public class bestTimeToBuyAndSellStocks1 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = scn.nextInt();
        System.out.println("Enter the prices in each day: ");
        int[] prices = new int[n];
        for(int i = 0; i < n; i++) {
            prices[i] = scn.nextInt();
        }
        
        int lsf = Integer.MAX_VALUE; // least so far
        int maxProfit = 0;
        int profitToday = 0;
        for(int i = 0; i < n; i++) {
            if(prices[i] < lsf) {
                lsf = prices[i];
            }
            profitToday = prices[i] - lsf;
            if(profitToday > maxProfit) {
                maxProfit = profitToday;
            }
        }
        System.out.println("Maximum Profit: " + maxProfit);
    }
}
