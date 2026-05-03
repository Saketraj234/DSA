/**
 * Problem: 216. Combination Sum III
 *
 * Find all valid combinations of k numbers that sum up to n
 * such that:
 * - Only numbers from 1 to 9 are used
 * - Each number is used at most once
 *
 * Approach:
 * We use Backtracking.
 *
 * We try numbers from 1 to 9 and:
 * - Pick the number
 * - Reduce k and target
 * - Move to next number (i+1) to avoid reuse
 *
 * Pruning (Optimization):
 * - If target < 0 → stop
 * - If k == 0 and target != 0 → stop
 * - If i > target → break (no need to continue)
 *
 * Time Complexity: O(C(9, k))
 * Space Complexity: O(k)
 */

class Solution {

    public void solve(int start, int k, int target,
                      List<Integer> ds,
                      List<List<Integer>> ans) {

        // valid case
        if (k == 0 && target == 0) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        // pruning
        if (k == 0 || target < 0) return;

        for (int i = start; i <= 9; i++) {

            // optimization
            if (i > target) break;

            ds.add(i);

            solve(i + 1, k - 1, target - i, ds, ans);

            // backtrack
            ds.remove(ds.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {

        List<List<Integer>> ans = new ArrayList<>();

        solve(1, k, n, new ArrayList<>(), ans);

        return ans;
    }
}