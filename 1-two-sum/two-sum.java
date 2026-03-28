/**
 * Problem: 1. Two Sum
 *
 * Given an array of integers nums and an integer target,
 * return indices of the two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution,
 * and you may not use the same element twice.
 *
 * Approach:
 * We use HashMap for fast lookup.
 *
 * Idea:
 * For each element nums[i], we calculate:
 * need = target - nums[i]
 *
 * If 'need' already exists in map,
 * then we found our answer.
 *
 * Otherwise, store current element in map.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

class Solution {

    public int[] twoSum(int[] nums, int target) {

        // Map to store:
        // key   = number
        // value = index
        HashMap<Integer, Integer> map = new HashMap<>();

        // Traverse array
        for (int i = 0; i < nums.length; i++) {

            // Find required number
            int need = target - nums[i];

            // Check if already exists
            if (map.containsKey(need)) {

                // Return indices
                return new int[] { map.get(need), i };
            }

            // Store current number
            map.put(nums[i], i);
        }

        // Safety (though problem guarantees answer)
        return new int[] {};
    }
}
