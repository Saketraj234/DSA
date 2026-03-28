/**
 * Problem: 15. 3Sum
 *
 * Find all unique triplets such that:
 * nums[i] + nums[j] + nums[k] == 0
 *
 * ----------------------------------------------------
 * Optimal Approach: Sorting + Two Pointer
 *
 * Why Optimal?
 * - Brute Force: O(n^3)
 * - Better (Hashing): O(n^2) but extra space
 * - Optimal: O(n^2) + O(1) space
 *
 * ----------------------------------------------------
 * Time Complexity: O(n^2)
 * Space Complexity: O(1) (excluding result)
 */

class Solution {

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;

        Arrays.sort(nums);

        for (int i = 0; i < n - 2; i++) {

            // Optimization 1: skip duplicates
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            // Optimization 2: early break (IMPORTANT 🔥)
            if (nums[i] > 0) break;

            int j = i + 1;
            int k = n - 1;

            while (j < k) {

                int sum = nums[i] + nums[j] + nums[k];

                if (sum < 0) {
                    j++;
                }
                else if (sum > 0) {
                    k--;
                }
                else {

                    ans.add(Arrays.asList(nums[i], nums[j], nums[k]));

                    j++;
                    k--;

                    // skip duplicates
                    while (j < k && nums[j] == nums[j - 1]) j++;
                    while (j < k && nums[k] == nums[k + 1]) k--;
                }
            }
        }

        return ans;
    }
}