/**
 * Problem: 123. Best Time to Buy and Sell Stock III
 *
 * Given an array prices where prices[i] is the price of a stock
 * on the ith day.
 *
 * Return the maximum profit you can achieve.
 * You may complete at most two transactions.
 *
 * Approach:
 * We use Dynamic Programming.
 *
 * buy1  = Maximum profit after first buy
 * sell1 = Maximum profit after first sell
 * buy2  = Maximum profit after second buy
 * sell2 = Maximum profit after second sell
 *
 * We update all four values for every price.
 *
 * Final Answer = sell2
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {

    public int maxProfit(int[] prices) {

        int buy1 = Integer.MIN_VALUE;
        int sell1 = 0;

        int buy2 = Integer.MIN_VALUE;
        int sell2 = 0;

        for (int price : prices) {

            buy1 = Math.max(buy1, -price);

            sell1 = Math.max(sell1, buy1 + price);

            buy2 = Math.max(buy2, sell1 - price);

            sell2 = Math.max(sell2, buy2 + price);
        }

        return sell2;
    }
}