/**
 * Problem: 55. Jump Game
 *
 * Given an integer array nums,
 * each element nums[i] represents the maximum jump length from that position.
 *
 * Return true if you can reach the last index,
 * otherwise return false.
 *
 * Approach:
 * We use Greedy.
 *
 * maxReach stores the farthest index we can reach so far.
 *
 * If at any index i, i > maxReach,
 * then that index is unreachable, so return false.
 *
 * Update:
 * maxReach = max(maxReach, i + nums[i])
 *
 * If we finish traversing the array,
 * then reaching the last index is possible.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {

    public boolean canJump(int[] nums) {

        int maxReach = 0;

        for (int i = 0; i < nums.length; i++) {

            // Current index is unreachable
            if (i > maxReach) {
                return false;
            }

            // Update the farthest reachable index
            maxReach = Math.max(maxReach, i + nums[i]);
        }

        // Last index is reachable
        return true;
    }
}