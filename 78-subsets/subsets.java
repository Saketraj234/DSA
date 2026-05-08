/**
 * Problem: 78. Subsets
 *
 * Given an integer array nums of unique elements,
 * return all possible subsets (power set).
 *
 * The solution set must not contain duplicate subsets.
 * Return the answer in any order.
 *
 * Approach:
 * We use Backtracking.
 *
 * At every step:
 * 1. Add current subset into answer
 * 2. Pick next element
 * 3. Recurse for further subsets
 * 4. Backtrack by removing last element
 *
 * Time Complexity: O(2^n)
 * Space Complexity: O(2^n)
 */

class Solution {

    public List<List<Integer>> subsets(int[] nums) {

        // Final answer list
        List<List<Integer>> ans = new ArrayList<>();

        // Start backtracking from index 0
        backtrack(0, nums, new ArrayList<>(), ans);

        return ans;
    }

    private void backtrack(int index, int[] nums,
                           List<Integer> current,
                           List<List<Integer>> ans) {

        // Add current subset into answer
        ans.add(new ArrayList<>(current));

        // Try all possible elements from current index
        for (int i = index; i < nums.length; i++) {

            // Include current element
            current.add(nums[i]);

            // Move to next index
            backtrack(i + 1, nums, current, ans);

            // Backtrack: remove last added element
            current.remove(current.size() - 1);
        }
    }
}