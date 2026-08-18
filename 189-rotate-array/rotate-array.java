/**
 * Problem: 189. Rotate Array
 *
 * Given an integer array nums, rotate the array to the right by k steps.
 *
 * Approach:
 * We use the Reverse method.
 *
 * Step 1: Reverse the complete array.
 * Step 2: Reverse the first k elements.
 * Step 3: Reverse the remaining elements.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {

    public void rotate(int[] nums, int k) {

        int n = nums.length;

        // Handle k greater than array length
        k = k % n;

        // Reverse the complete array
        reverse(nums, 0, n - 1);

        // Reverse first k elements
        reverse(nums, 0, k - 1);

        // Reverse remaining elements
        reverse(nums, k, n - 1);
    }

    public void reverse(int[] nums, int left, int right) {

        while (left < right) {

            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;

            left++;
            right--;
        }
    }
}