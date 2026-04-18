/**
 * Problem: 90. Subsets II
 *
 * Given an integer array nums that may contain duplicates,
 * return all possible subsets (the power set).
 *
 * The solution set must not contain duplicate subsets.
 *
 * Example:
 * Input: nums = [1,2,2]
 * Output: [[], [1], [2], [1,2], [2,2], [1,2,2]]
 *
 * Approach:
 * We use Backtracking + Sorting.
 *
 * 1. Sort the array to bring duplicates together.
 * 2. Use recursion to generate all subsets.
 * 3. At each step, add current subset to answer.
 * 4. Skip duplicates using:
 *    if (i > index && nums[i] == nums[i-1]) continue;
 *
 * Time Complexity: O(2^n)
 * Space Complexity: O(n)
 */

class Solution {

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums); // Step 1: sort array

        findSubsets(0, nums, new ArrayList<>(), ans);

        return ans;
    }

    public void findSubsets(int index, int[] nums, List<Integer> ds, List<List<Integer>> ans) {

        // Step 3: add current subset
        ans.add(new ArrayList<>(ds));

        for (int i = index; i < nums.length; i++) {

            // Step 4: skip duplicates
            if (i > index && nums[i] == nums[i - 1]) continue;

            ds.add(nums[i]); // pick

            findSubsets(i + 1, nums, ds, ans); // recursive call

            ds.remove(ds.size() - 1); // backtrack
        }
    }
}