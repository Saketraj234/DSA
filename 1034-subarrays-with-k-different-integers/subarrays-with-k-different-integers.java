/**
 * Problem: 992. Subarrays with K Different Integers
 *
 * Given an integer array nums and an integer k,
 * return the number of good subarrays of nums.
 *
 * A good subarray is a contiguous subarray that contains
 * exactly k distinct integers.
 *
 * Approach:
 * We use Sliding Window + HashMap.
 *
 * Exactly(K) = AtMost(K) - AtMost(K - 1)
 *
 * 1. Count subarrays having at most K distinct integers.
 * 2. Count subarrays having at most (K - 1) distinct integers.
 * 3. Their difference gives subarrays with exactly K distinct integers.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(k)
 */

class Solution {

    public int subarraysWithKDistinct(int[] nums, int k) {

        return atMostK(nums, k) - atMostK(nums, k - 1);
    }

    private int atMostK(int[] nums, int k) {

        int left = 0;
        int count = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int right = 0; right < nums.length; right++) {

            map.put(nums[right],
                    map.getOrDefault(nums[right], 0) + 1);

            while (map.size() > k) {

                map.put(nums[left],
                        map.get(nums[left]) - 1);

                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }

                left++;
            }

            // All subarrays ending at right
            count += (right - left + 1);
        }

        return count;
    }
}