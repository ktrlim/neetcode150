package SlidingWindow;

import java.util.Arrays;

public class BestTimeBuySellStock {
    public static void main(String[] args) {
        int[] prices1 = {7,6,4,3,1};
        int[] prices2 = {7,1,5,3,6,4};
        System.out.println("Max profit for " + Arrays.toString(prices1) + " is " + maxProfit(prices1));
        System.out.println("Max profit for " + Arrays.toString(prices2) + " is " + maxProfit(prices2));
    }

    public static int maxProfit(int[] prices) {
        // left and right pointers
        int l = 0;
        int r = 1;
        int maxProfit = 0; // start max profit at 0
        // max profit will remain 0 if best profit is negative
        while (r < prices.length) { // iterate until right pointer reaches the end
            if (prices[r] < prices[l]) {
                // if no profit then scoot each pointer
                l = r;
            }
            else {
                // if there is a profit or equal to eachother
                // then check to see if it is a new maximum profit
                if (prices[r] - prices[l] > maxProfit) maxProfit = prices[r] - prices[l];
            }
            r++; // increment right pointer each time
        }
        return maxProfit;
    }
}
