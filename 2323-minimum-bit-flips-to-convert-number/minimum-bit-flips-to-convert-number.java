/**
 * Problem: 2220. Minimum Bit Flips to Convert Number
 *
 * Given two integers start and goal,
 * return the minimum number of bit flips
 * required to convert start into goal.
 *
 * Approach:
 * We use XOR Operation.
 *
 * xor = start ^ goal
 *
 * XOR gives 1 where bits are different.
 * So, number of set bits in xor
 * = minimum bit flips required.
 *
 * We use Brian Kernighan Algorithm:
 * xor = xor & (xor - 1)
 *
 * This removes the rightmost set bit
 * in every iteration.
 *
 * Time Complexity: O(number of set bits)
 * Space Complexity: O(1)
 */

class Solution {

    public int minBitFlips(int start, int goal) {

        int xor = start ^ goal;

        int count = 0;

        while (xor != 0) {

            // Remove rightmost set bit
            xor = xor & (xor - 1);

            count++;
        }

        return count;
    }
}