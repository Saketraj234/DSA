/**
 * Problem: 1922. Count Good Numbers
 *
 * A digit string is good if:
 * - Even indices (0-based) → even digits (0,2,4,6,8)
 * - Odd indices → prime digits (2,3,5,7)
 *
 * Given n, return total number of good digit strings of length n.
 * Answer should be modulo (10^9 + 7).
 *
 * Approach:
 * - Even index count = (n + 1) / 2
 * - Odd index count = n / 2
 *
 * - Even positions → 5 choices
 * - Odd positions → 4 choices
 *
 * Total = (5 ^ even) * (4 ^ odd)
 *
 * Use Binary Exponentiation for fast power.
 *
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */

class Solution {

    // Mod value given in problem
    long MOD = 1000000007;

    public int countGoodNumbers(long n) {

        // Even index positions count
        // Example: n=3 → indices 0,2 → total 2
        long even = (n + 1) / 2;

        // Odd index positions count
        // Example: n=3 → index 1 → total 1
        long odd = n / 2;

        // For even positions → 5 choices (0,2,4,6,8)
        long evenPart = power(5, even);

        // For odd positions → 4 choices (2,3,5,7)
        long oddPart = power(4, odd);

        // Final answer = multiply both parts and take modulo
        return (int)((evenPart * oddPart) % MOD);
    }

    // Binary Exponentiation function to calculate (base^exp) % MOD
    private long power(long base, long exp) {

        long result = 1;

        // Take modulo of base initially
        base = base % MOD;

        while (exp > 0) {

            // If exponent is odd → multiply result with base
            if ((exp & 1) == 1) {
                result = (result * base) % MOD;
            }

            // Square the base
            base = (base * base) % MOD;

            // Divide exponent by 2
            exp = exp >> 1;
        }

        return result;
    }
}