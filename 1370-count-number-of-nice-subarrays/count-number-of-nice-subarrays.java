/**
 * Problem: 1248. Count Number of Nice Subarrays
 *
 * Given an integer array nums and an integer k,
 * return the number of continuous subarrays
 * containing exactly k odd numbers.
 *
 * Approach:
 * We use Sliding Window + At Most concept.
 *
 * exactly(k) = atMost(k) - atMost(k - 1)
 *
 * In atMost(goal):
 * - Count odd numbers using nums[i] % 2
 * - Expand window using r
 * - Shrink window when odd count > goal
 * - Add valid subarrays count:
 *      (r - l + 1)
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {

    // Returns count of subarrays having at most goal odd numbers
    public int func(int[] nums, int goal) {

        // Negative goal possible nahi
        if (goal < 0) {
            return 0;
        }

        int l = 0;
        int r = 0;

        int sum = 0;
        int cnt = 0;

        while (r < nums.length) {

            // Odd number count karo
            sum += (nums[r] % 2);

            // Window shrink karo
            while (sum > goal) {

                sum -= (nums[l] % 2);
                l++;
            }

            // Valid subarrays add karo
            cnt += (r - l + 1);

            r++;
        }

        return cnt;
    }

    public int numberOfSubarrays(int[] nums, int k) {

        // Exactly k odd numbers
        return func(nums, k) - func(nums, k - 1);
    }
}