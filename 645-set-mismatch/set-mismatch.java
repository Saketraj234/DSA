/**
 * Problem: 645. Set Mismatch
 *
 * Given an array nums containing numbers from 1 to n,
 * one number is duplicated and one number is missing.
 *
 * return [duplicate, missing].
 *
 * Approach:
 * We use Frequency Array.
 *
 * freq[i] tells how many times number i occurs.
 *
 * If freq[i] == 2 → duplicate
 * If freq[i] == 0 → missing
 *
 * Final Answer = [duplicate, missing]
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

class Solution {

    public int[] findErrorNums(int[] nums) {

        int n = nums.length;
        int[] freq = new int[n + 1];

        // Count frequency of each number
        for (int num : nums) {
            freq[num]++;
        }

        int duplicate = 0;
        int missing = 0;

        // Find duplicate and missing number
        for (int i = 1; i <= n; i++) {

            if (freq[i] == 2) {
                duplicate = i;
            }

            if (freq[i] == 0) {
                missing = i;
            }
        }

        return new int[]{duplicate, missing};
    }
}
