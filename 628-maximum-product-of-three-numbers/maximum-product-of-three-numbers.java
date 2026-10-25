
/**
 * Problem: 628. Maximum Product of Three Numbers
 *
 * Given an integer array nums,
 * return the maximum product of any three numbers.
 *
 * Approach:
 * We use Sorting.
 *
 * After sorting:
 * Case 1 = Product of 3 largest numbers.
 * Case 2 = Product of 2 smallest numbers and 1 largest number.
 *
 * We return the maximum of both cases.
 *
 * Time Complexity: O(n log n)
 * Space Complexity: O(1) auxiliary space
 * (Sorting space depends on the implementation.)
 */

import java.util.Arrays;

class Solution {

    public int maximumProduct(int[] nums) {

        Arrays.sort(nums);

        int n = nums.length;

        // Product of 3 largest numbers
        int case1 = nums[n - 1] * nums[n - 2] * nums[n - 3];

        // Product of 2 smallest and 1 largest number
        int case2 = nums[0] * nums[1] * nums[n - 1];

        // Return the maximum product
        return Math.max(case1, case2);
    }
}
