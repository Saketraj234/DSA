/**
 * Problem: 47. Permutations II
 *
 * Given an array nums that may contain duplicates,
 * return all possible unique permutations.
 *
 * Approach:
 * We use Backtracking.
 *
 * First, we sort the array so duplicate elements
 * come together.
 *
 * We use a boolean[] used to track which elements
 * are already used in the current permutation.
 *
 * If the current number is same as the previous number
 * and the previous number is not used at this level,
 * we skip it to avoid duplicate permutations.
 *
 * Time Complexity: O(n * n!)
 * Space Complexity: O(n)
 */

class Solution {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {

        Arrays.sort(nums);

        boolean[] used = new boolean[nums.length];

        backtrack(nums, used, new ArrayList<>());

        return result;
    }

    void backtrack(int[] nums, boolean[] used, List<Integer> current) {

        // If permutation is complete
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            // Skip element if already used
            if (used[i]) {
                continue;
            }

            // Skip duplicate at the same level
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }

            // Choose
            current.add(nums[i]);
            used[i] = true;

            // Explore
            backtrack(nums, used, current);

            // Backtrack
            current.remove(current.size() - 1);
            used[i] = false;
        }
    }
}