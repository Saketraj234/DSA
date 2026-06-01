/**
 * Problem: 1004. Max Consecutive Ones III
 *
 * Given a binary array nums and an integer k,
 * return the maximum number of consecutive 1's
 * if you can flip at most k zeros.
 *
 * Approach:
 * We use Sliding Window.
 *
 * Keep expanding the window using r pointer.
 *
 * If nums[r] == 0, increase zero count.
 *
 * If zeros become greater than k,
 * shrink the window from left side.
 *
 * Window Length = r - l + 1
 *
 * Update maximum length continuously.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {

    public int longestOnes(int[] nums, int k) {

        int l = 0;
        int r = 0;

        int zeros = 0;

        int maxLen = 0;

        while (r < nums.length) {

            // count zeros
            if (nums[r] == 0) {
                zeros++;
            }

            // shrink window if zeros > k
            while (zeros > k) {

                if (nums[l] == 0) {
                    zeros--;
                }

                l++;
            }

            // current valid window length
            int len = r - l + 1;

            maxLen = Math.max(maxLen, len);

            r++;
        }

        return maxLen;
    }
}