/**
 * Problem: 410. Split Array Largest Sum
 * 
 * Given an integer array nums and an integer k,
 * split nums into k non-empty subarrays such that
 * the largest sum among these subarrays is minimized.
 * 
 * Return the minimized largest sum.
 * 
 * Approach:
 * - Use Binary Search on Answer.
 * - Low = max element in array.
 * - High = sum of all elements.
 * - For each mid, calculate required partitions.
 * - If partitions > k → increase low.
 * - Else → decrease high.
 * 
 * Time Complexity: O(n * log(sum))
 * Space Complexity: O(1)
 */

class Solution {

    // Helper function:
    // Counts how many partitions are required
    // if maximum allowed subarray sum is maxSum.
    private int countPartitions(int[] nums, int maxSum) {
        int partitions = 1;   // At least one partition
        int currentSum = 0;

        for (int num : nums) {

            // If adding num doesn't exceed maxSum
            if (currentSum + num <= maxSum) {
                currentSum += num;
            } 
            // Otherwise, start new partition
            else {
                partitions++;
                currentSum = num;
            }
        }
        return partitions;
    }

    public int splitArray(int[] nums, int k) {

        int n = nums.length;

        // Edge case
        if (k > n) return -1;

        int low = 0;
        int high = 0;

        // Initialize binary search boundaries
        for (int num : nums) {
            low = Math.max(low, num); // minimum possible answer
            high += num;              // maximum possible answer
        }

        // Binary Search
        while (low <= high) {

            int mid = low + (high - low) / 2;

            int partitions = countPartitions(nums, mid);

            // If more partitions needed, increase allowed sum
            if (partitions > k) {
                low = mid + 1;
            } 
            // Else try to minimize further
            else {
                high = mid - 1;
            }
        }

        return low;
    }
}
