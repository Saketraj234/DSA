/**
 * Problem: 39. Combination Sum
 *
 * Given an array of distinct integers candidates and a target integer target,
 * return a list of all unique combinations of candidates where the chosen numbers sum to target.
 *
 * You may use the same element unlimited times.
 *
 * --------------------------------------------------
 *
 * Approach:
 * We use Backtracking.
 *
 * - Try every element starting from current index.
 * - If we pick an element, we stay at same index (reuse allowed).
 * - If target becomes 0 → valid combination.
 * - If target becomes negative → stop (invalid path).
 *
 * --------------------------------------------------
 *
 * Key Idea:
 * At every step:
 * 1. Choose element
 * 2. Explore further
 * 3. Backtrack (remove element)
 *
 * --------------------------------------------------
 *
 * Time Complexity: O(2^target)  (approx exponential)
 * Space Complexity: O(target)   (recursion stack)
 */

class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();

        backtrack(0, candidates, target, new ArrayList<>(), result);

        return result;
    }

    private void backtrack(int index, int[] arr, int target,
                           List<Integer> curr, List<List<Integer>> result) {

        // Base Case: valid combination found
        if (target == 0) {
            result.add(new ArrayList<>(curr));
            return;
        }

        // Base Case: invalid path
        if (target < 0) return;

        // Try all choices from current index
        for (int i = index; i < arr.length; i++) {

            // Choose element
            curr.add(arr[i]);

            // Explore (same index → reuse allowed)
            backtrack(i, arr, target - arr[i], curr, result);

            // Backtrack (remove last element)
            curr.remove(curr.size() - 1);
        }
    }
}