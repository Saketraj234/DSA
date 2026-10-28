/**
 * Problem: 724. Find Pivot Index
 *
 * Given an integer array nums,
 * return the pivot index.
 *
 * Approach:
 * We use Prefix Sum.
 *
 * First, calculate the total sum.
 *
 * leftSum = sum of elements before index i
 *
 * rightSum = totalSum - leftSum - nums[i]
 *
 * If leftSum == rightSum,
 * return index i.
 *
 * Otherwise, update leftSum.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public int pivotIndex(int[] nums) {
        int totalSum = 0;

        for(int num : nums){
            totalSum += num;
        }

        int leftSum = 0;

        for(int i = 0; i < nums.length; i++){
            int rightSum = totalSum - leftSum - nums[i];

            if(leftSum == rightSum){
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }
}