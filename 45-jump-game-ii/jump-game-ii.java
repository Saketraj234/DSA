/**
 * Problem: 45. Jump Game II
 *
 * Given an integer array nums, where nums[i] represents the
 * maximum number of steps you can jump forward from index i,
 * return the minimum number of jumps required to reach the
 * last index.
 *
 * Approach:
 * We use Greedy.
 *
 * currentEnd = end of current jump range.
 * farthest = farthest index reachable within current range.
 *
 * Traverse the array and continuously update farthest.
 * When we reach currentEnd, it means the current jump is over,
 * so we take one more jump and set currentEnd = farthest.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {

    public int jump(int[] nums) {

        int jumps = 0;
        int currentEnd = 0;
        int farthest = 0;

        // No need to process the last index
        for (int i = 0; i < nums.length - 1; i++) {

            // Find the farthest index reachable till now
            farthest = Math.max(farthest, i + nums[i]);

            // If current jump range ends here
            if (i == currentEnd) {

                // Take one more jump
                jumps++;

                // Update the range for next jump
                currentEnd = farthest;
            }
        }

        return jumps;
    }
}