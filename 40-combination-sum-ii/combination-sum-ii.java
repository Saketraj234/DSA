/**
 * Problem: 40. Combination Sum II
 *
 * Given a collection of candidate numbers (candidates) and a target number (target),
 * find all unique combinations in candidates where the candidate numbers sum to target.
 *
 * Each number in candidates may only be used once in the combination.
 *
 * Note:
 * The solution set must not contain duplicate combinations.
 *
 * Approach:
 * We use Backtracking.
 *
 * Steps:
 * 1. Sort the array to handle duplicates and allow early stopping.
 * 2. Use recursion to try all combinations.
 * 3. Skip duplicates using:
 *      if(i > ind && arr[i] == arr[i-1]) continue;
 * 4. Stop early if arr[i] > target.
 * 5. Pick element → recursive call → backtrack.
 *
 * Time Complexity: O(2^n)
 * Space Complexity: O(k * x)
 */

class Solution {

    public void findCombination(int ind, int target, int[] arr,
                                List<List<Integer>> ans, List<Integer> ds) {

        // Base case: target achieved
        if (target == 0) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        for (int i = ind; i < arr.length; i++) {

            // Skip duplicates
            if (i > ind && arr[i] == arr[i - 1]) continue;

            // If element exceeds target, break (sorted array)
            if (arr[i] > target) break;

            // Pick the element
            ds.add(arr[i]);

            // Recursive call (move to next index)
            findCombination(i + 1, target - arr[i], arr, ans, ds);

            // Backtrack (remove last element)
            ds.remove(ds.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates); // Step 1: sort

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();

        findCombination(0, target, candidates, ans, ds);

        return ans;
    }
}