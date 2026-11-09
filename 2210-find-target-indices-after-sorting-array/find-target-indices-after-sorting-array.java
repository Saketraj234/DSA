/**
 *
 * Problem: 2089. Find Target Indices After Sorting Array
 *
 * Given an array nums and an integer target,
 * sort the array and return all indices
 * where nums[i] == target.
 *
 *
 * Approach:
 *
 * 1. First sort the array using Arrays.sort().
 *
 * 2. Traverse the sorted array.
 *
 * 3. If nums[i] == target,
 *    add index i to the result.
 *
 * 4. Return the result.
 *
 *
 * Time Complexity: O(n log n)
 * Space Complexity: O(n)
 *
 */

class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {

        Arrays.sort(nums);
        List<Integer> ans = new ArrayList<>();

        for(int i = 0; i < nums.length; i++){
            if(nums[i] == target){
                ans.add(i);
            }
        } 
        return ans;
    }
}