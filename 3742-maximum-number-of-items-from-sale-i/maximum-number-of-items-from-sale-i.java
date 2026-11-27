/**
 * Problem: 3946. Maximum Number of Items From Sale I
 *
 * Given a 2D array items where items[i] = [factor, price]
 * and an integer budget.
 *
 * We need to maximize the total number of items,
 * including purchased and free items.
 *
 * Approach:
 * We use Dynamic Programming (0/1 Knapsack).
 *
 * Buying an item for the first time gives:
 * 1 purchased item + free items based on divisibility.
 *
 * count = Number of items whose factor is divisible
 *         by the current item's factor.
 *
 * We calculate the maximum benefit using DP.
 *
 * dp[j] = max(dp[j], dp[j - price] + count)
 *
 * Remaining budget is used to buy the cheapest item.
 *
 * Final Answer:
 * max(dp[i] + (budget - i) / minPrice)
 *
 * Time Complexity: O(n * n + n * budget)
 * Space Complexity: O(budget)
 */

class Solution {

    public int maximumSaleItems(int[][] items, int budget) {

        int n = items.length;

        int minPrice = Integer.MAX_VALUE;

        int[] dp = new int[budget + 1];

        for (int[] item : items) {

            int factor = item[0];
            int price = item[1];

            minPrice = Math.min(minPrice, price);

            // Count free items
            int count = 0;

            for (int[] j : items) {

                if (j[0] % factor == 0) {
                    count++;
                }
            }

            // 0/1 Knapsack
            for (int j = budget; j >= price; j--) {

                dp[j] = Math.max(
                    dp[j],
                    dp[j - price] + count
                );
            }
        }

        int ans = 0;

        // Use remaining budget to buy cheapest items
        for (int i = 0; i <= budget; i++) {

            int total = dp[i] + (budget - i) / minPrice;

            ans = Math.max(ans, total);
        }

        return ans;
    }
}