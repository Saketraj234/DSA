/**
 * Problem: 137. Single Number II
 *
 * Given an integer array nums where:
 * - Every element appears exactly three times,
 * - Except for one element which appears only once.
 *
 * Return the single element.
 *
 * Approach:
 * We use Bit Manipulation.
 *
 * For every bit position (0 to 31):
 * - Count how many numbers have that bit set.
 * - If count % 3 != 0, then that bit belongs to the single number.
 *
 * Build the answer by setting those bits.
 *
 * Time Complexity: O(32 × n) ≈ O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;

        for(int bit = 0; bit < 32; bit++){
            int count = 0;

            for(int num : nums){
                if(((num >> bit) & 1) == 1) {
                    count++;
                }
            }

            if(count % 3 != 0){
                ans |= (1 << bit);
            }
        }
        return ans;
    }
}