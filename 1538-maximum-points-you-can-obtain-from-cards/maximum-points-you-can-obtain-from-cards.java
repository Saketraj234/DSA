/**
 * Problem: 1423. Maximum Points You Can Obtain from Cards
 *
 * Given an integer array cardPoints and an integer k,
 * we can take exactly k cards from:
 * - front (left)
 * - or back (right)
 *
 * Return the maximum score possible.
 *
 * Approach:
 * We use Sliding Window.
 *
 * First take first k cards from left.
 * Then:
 * remove one card from left side
 * and add one card from right side.
 *
 * Keep updating maximum sum.
 *
 * Time Complexity: O(k)
 * Space Complexity: O(1)
 */

class Solution {

    public int maxScore(int[] cardPoints, int k) {

        int n = cardPoints.length;

        int total = 0;

        // Take first k cards
        for (int i = 0; i < k; i++) {
            total += cardPoints[i];
        }

        int maxSum = total;

        int right = n - 1;

        // Shift window:
        // remove from left and add from right
        for (int i = k - 1; i >= 0; i--) {

            total -= cardPoints[i];

            total += cardPoints[right];

            right--;

            maxSum = Math.max(maxSum, total);
        }

        return maxSum;
    }
}