/**
 * Problem: 70. Climbing Stairs
 *
 * You are climbing a staircase. It takes n steps to reach the top.
 * Each time you can either climb 1 or 2 steps.
 * Return the number of distinct ways to climb to the top.
 *
 *
 * Approach:
 * We use Dynamic Programming.
 *
 * dp[i] = dp[i - 1] + dp[i - 2]
 *
 * We can reach step i from:
 * 1. Step i - 1 (1 step)
 * 2. Step i - 2 (2 steps)
 *
 * Base Cases:
 * dp[1] = 1
 * dp[2] = 2
 *
 * We optimize space by using two variables.
 *
 * Final Answer = prev1
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public int climbStairs(int n) {

        if(n <= 2) return n;

        int prev2 = 1;
        int prev1 = 2;

        for(int i = 3; i <= n; i++) {

            int curr = prev1 + prev2;

            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}