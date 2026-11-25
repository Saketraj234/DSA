/**
 * Problem: 3934. Smallest Unique Subarray
 *
 * Given an integer array nums.
 * Find the minimum length of a subarray
 * that is not identical to any other subarray.
 *
 *
 * Approach:
 * We use Binary Search + Sliding Window + Rolling Hash.
 *
 * We binary search the possible subarray length.
 *
 * For each length:
 * - Calculate hash of the first window.
 * - Slide the window one step at a time.
 * - Update hash in O(1).
 * - Store hash frequency in HashMap.
 *
 * We use Double Rolling Hash to reduce hash collisions.
 *
 * If any hash appears exactly once:
 * A unique subarray exists.
 *
 * Then we search for a smaller length.
 *
 * Otherwise, search for a larger length.
 *
 * Final Answer = low
 *
 * Time Complexity: O(n log n)
 * Space Complexity: O(n)
 */

class Solution {
    public int smallestUniqueSubarray(int[] nums) {

        int n = nums.length;

        long base1 = 100019;
        long base2 = 100043;

        long mod1 = 1000000007;
        long mod2 = 1000000009;

        int low = 1;
        int high = n;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (check(nums, mid, base1, base2, mod1, mod2)) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }

        return low;
    }

    private boolean check(int[] nums, int len,
                          long base1, long base2,
                          long mod1, long mod2) {

        int n = nums.length;

        long pow1 = 1;
        long pow2 = 1;

        for (int i = 0; i < len; i++) {
            pow1 = (pow1 * base1) % mod1;
            pow2 = (pow2 * base2) % mod2;
        }

        long hash1 = 0;
        long hash2 = 0;

        HashMap<Long, Integer> map = new HashMap<>();

        // Calculate first window hash
        for (int i = 0; i < len; i++) {

            hash1 = (hash1 * base1 + nums[i]) % mod1;
            hash2 = (hash2 * base2 + nums[i]) % mod2;
        }

        long key = (hash1 << 32) | hash2;

        map.put(key, 1);

        // Sliding Window
        for (int i = len; i < n; i++) {

            hash1 = (hash1 * base1
                    - (nums[i - len] * pow1) % mod1
                    + nums[i] + mod1) % mod1;

            hash2 = (hash2 * base2
                    - (nums[i - len] * pow2) % mod2
                    + nums[i] + mod2) % mod2;

            key = (hash1 << 32) | hash2;

            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        // Check if any subarray is unique
        for (int count : map.values()) {
            if (count == 1) {
                return true;
            }
        }

        return false;
    }
}