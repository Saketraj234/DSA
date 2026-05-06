/**
 * Problem: 231. Power of Two
 *
 * Given an integer n,
 * return true if it is a power of two.
 * Otherwise, return false.
 *
 * A number is power of 2 if:
 * 1. n > 0
 * 2. It has only one set bit.
 *
 * Bit Trick:
 * For any power of 2:
 *
 * n       = 1000
 * n - 1   = 0111
 * ----------------
 * n&(n-1) = 0000
 *
 * So if (n & (n - 1)) == 0,
 * then n is a power of two.
 *
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 */

class Solution {

    public boolean isPowerOfTwo(int n) {

        // n must be positive
        // and contain only one set bit
        return n > 0 && (n & (n - 1)) == 0;
    }
}