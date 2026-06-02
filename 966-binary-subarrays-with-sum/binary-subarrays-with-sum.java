/**
 * Problem: 930. Binary Subarrays With Sum
 *
 * Given a binary array nums and an integer goal,
 * return the number of non-empty subarrays with sum = goal.
 *
 * Approach:
 * We use Sliding Window + At Most Technique.
 *
 * Count of subarrays with sum exactly goal =
 * Count(sum <= goal) - Count(sum <= goal - 1)
 *
 * helper(goal) returns number of subarrays
 * having sum less than or equal to goal.
 *
 * If sum becomes greater than goal,
 * move left pointer forward.
 *
 * Time Complexity: O(2N) ≈ O(N)
 * Space Complexity: O(1)
 */

class Solution {

    public int numSubarraysWithSum(int[] nums, int goal) {

        return helper(nums, goal) - helper(nums, goal - 1);
    }

    public int helper(int[] nums, int goal) {

        // Invalid case
        if (goal < 0) {
            return 0;
        }

        int l = 0;
        int r = 0;

        int sum = 0;
        int cnt = 0;

        while (r < nums.length) {

            // Include current element
            sum += nums[r];

            // Shrink window if sum > goal
            while (sum > goal) {

                sum -= nums[l];
                l++;
            }

            // Add all valid subarrays ending at r
            cnt += (r - l + 1);

            r++;
        }

        return cnt;
    }
}