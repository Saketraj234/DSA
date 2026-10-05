/**
 * Problem: 1518. Water Bottles
 *
 * Given numB full water bottles and numE empty bottles needed
 * to exchange for 1 full bottle.
 *
 * Return the maximum number of water bottles you can drink.
 *
 * Approach:
 * We first drink all the full bottles.
 *
 * Then we exchange empty bottles for new full bottles.
 *
 * n = numB / numE
 * This tells how many new bottles we can get.
 *
 * rem = numB % numE
 * This tells how many empty bottles are left after exchange.
 *
 * New empty bottles = rem + n
 *
 * We repeat until we don't have enough empty bottles to exchange.
 *
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */

class Solution {
    public int numWaterBottles(int numB, int numE) {
        
        int ans = numB;

        while(numB >= numE){
            int n = numB / numE;
            int rem = numB % numE;
            ans += n;
            numB = rem + n;
        }
        return ans;
    }
}