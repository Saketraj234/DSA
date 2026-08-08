/**
 * Problem: 228. Summary Ranges
 *
 * Given a sorted unique integer array nums.
 * Return the smallest sorted list of ranges that covers all
 * the numbers in the array exactly.
 *
 * Approach:
 * We use a simple traversal.
 *
 * We keep a 'start' variable which stores the starting
 * number of the current range.
 *
 * If nums[i] == nums[i - 1] + 1,
 * then the numbers are consecutive, so we continue.
 *
 * Otherwise, the current range ends at nums[i - 1].
 * We add that range to the answer and start a new range
 * from nums[i].
 *
 * After the loop, we add the last remaining range.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1) excluding the output list.
 */

class Solution {

    public List<String> summaryRanges(int[] nums) {

        List<String> ans = new ArrayList<>();

        // Handle empty array
        if (nums.length == 0) {
            return ans;
        }

        // Start of current range
        int start = nums[0];

        for (int i = 1; i < nums.length; i++) {

            // Numbers are consecutive
            if (nums[i] == nums[i - 1] + 1) {
                continue;
            }

            // Current range has only one number
            if (start == nums[i - 1]) {
                ans.add(String.valueOf(start));
            } 
            // Current range has multiple numbers
            else {
                ans.add(start + "->" + nums[i - 1]);
            }

            // Start a new range
            start = nums[i];
        }

        // Add the last range
        if (start == nums[nums.length - 1]) {
            ans.add(String.valueOf(start));
        } 
        else {
            ans.add(start + "->" + nums[nums.length - 1]);
        }

        return ans;
    }
}