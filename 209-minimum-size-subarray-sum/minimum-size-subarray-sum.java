/**
 * Problem: 209. Minimum Size Subarray Sum
 *
 * Given an array of positive integers nums and an integer target,
 * return the minimum length of a contiguous subarray
 * whose sum is greater than or equal to target.
 *
 * If there is no such subarray, return 0.
 *
 * Approach:
 * We use Sliding Window.
 *
 * Expand the window using the right pointer and add elements to sum.
 *
 * When sum >= target:
 * - Update minimum length.
 * - Shrink the window from the left.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
       int n = nums.length;

       int left = 0;
       int sum = 0;
       int minLen = Integer.MAX_VALUE;

       for(int right = 0; right < n; right++) {

        sum = sum + nums[right];

        while(sum >= target){
            minLen = Math.min(minLen, right - left + 1);

            sum = sum - nums[left];
            left++;
        }
       } 
       return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}