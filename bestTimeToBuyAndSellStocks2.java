// for n days & prices of each day given, find max profit
// infinite transactions allowed but in BSBS order not BBSS i.e. first buy then sell then move onto next buy & so on

import java.util.Scanner;

public class bestTimeToBuyAndSellStocks2 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = scn.nextInt();
        System.out.println("Enter the prices in each day: ");
        int[] prices = new int[n];
        for(int i = 0; i < n; i++) {
            prices[i] = scn.nextInt();
        }

        // sir's approach
        /*int bd = 0;
        int sd = 0;
        int profit = 0;
        for(int i = 1; i < n; i++) {
            if(prices[i] > prices[i - 1]) {
                sd++;
            }
            else {
                profit += prices[sd] - prices[bd];
                bd = sd = i;
            }
        }
        profit += prices[sd] - prices[bd];
        System.out.println("Maximum Profit: " + profit);*/
        
        // my approach
        int maxProfit = 0;
        for(int i = 1; i < n; i++) {
            if(prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        System.out.println("Maximum Profit: " + maxProfit);
    }
}
