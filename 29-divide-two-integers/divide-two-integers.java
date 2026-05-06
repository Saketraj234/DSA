/**
 * Problem: 29. Divide Two Integers
 *
 * Given two integers dividend and divisor,
 * divide two integers without using
 * multiplication (*), division (/),
 * and mod (%) operators.
 *
 * Return the quotient after dividing dividend by divisor.
 *
 * The integer division should truncate toward zero.
 *
 * If quotient exceeds 32-bit signed integer range,
 * return Integer.MAX_VALUE.
 *
 * ---------------------------------------------------
 * Approach:
 * We use Bit Manipulation + Binary Shifting.
 *
 * Instead of subtracting divisor one by one,
 * we subtract large multiples using left shift.
 *
 * Example:
 * divisor << 3 = divisor * 2^3
 *
 * We keep finding the largest shifted divisor
 * that can be subtracted from dividend.
 *
 * ---------------------------------------------------
 * Steps:
 *
 * 1. Handle overflow case:
 *    Integer.MIN_VALUE / -1
 *
 * 2. Store sign separately.
 *
 * 3. Convert numbers to positive long values
 *    to avoid overflow.
 *
 * 4. While dividend >= divisor:
 *
 *      Find maximum shift such that:
 *
 *      divisor << shift <= dividend
 *
 *      Add 2^shift to quotient.
 *
 *      Subtract shifted divisor from dividend.
 *
 * 5. Apply sign and return answer.
 *
 * ---------------------------------------------------
 * Example:
 *
 * dividend = 43
 * divisor = 3
 *
 * 3 << 3 = 24
 * quotient += 8
 * remaining = 19
 *
 * 3 << 2 = 12
 * quotient += 4
 * remaining = 7
 *
 * 3 << 1 = 6
 * quotient += 2
 * remaining = 1
 *
 * Final Answer = 14
 *
 * ---------------------------------------------------
 * Time Complexity:
 * O((log n)^2)
 *
 * Space Complexity:
 * O(1)
 */

class Solution {

    public int divide(int dividend, int divisor) {

        // Overflow case
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Check sign
        boolean positive = (dividend < 0) == (divisor < 0);

        // Convert to positive long
        long n = Math.abs((long) dividend);
        long d = Math.abs((long) divisor);

        long quotient = 0;

        while (n >= d) {

            int cnt = 0;

            // Find maximum left shift
            while (n >= (d << (cnt + 1))) {
                cnt++;
            }

            // Add power of 2 to quotient
            quotient += (1L << cnt);

            // Subtract shifted divisor
            n -= (d << cnt);
        }

        // Apply sign
        return positive ? (int) quotient : (int) -quotient;
    }
}