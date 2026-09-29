/**
 * Problem: 561. Array Partition I
 *
 * Given an integer array nums of 2n integers,
 * group these integers into n pairs.
 * Return the maximum possible sum of min(ai, bi).
 *
 * Approach:
 * We first sort the array.
 * After sorting, pair adjacent elements.
 * The smaller element of each pair will be at index 0, 2, 4...
 *
 * Example:
 * nums = [2,5,3,4,7,6]
 * sorted = [2,3,4,5,6,7]
 *
 * Pairs:
 * [2,3] -> 2
 * [4,5] -> 4
 * [6,7] -> 6
 *
 * Answer = 2 + 4 + 6 = 12
 *
 * Time Complexity: O(n log n)
 * Space Complexity: O(1)
 */

class Solution {
    public int arrayPairSum(int[] nums) {
        int n = nums.length;
        int ans = 0;
        Arrays.sort(nums);

        for(int i = 0; i < n; i+=2){
            ans += nums[i];
        }
        return ans;
    }
}