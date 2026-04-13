/**
 * Problem: 50. Pow(x, n)
 *
 * Given a double x and an integer n,
 * return x raised to the power n (i.e., x^n).
 *
 * Approach:
 * We use Binary Exponentiation (Fast Power).
 *
 * Idea:
 * - If n is odd → multiply answer with x and reduce n by 1
 * - If n is even → square x and divide n by 2
 *
 * We convert n to long to handle edge case of INT_MIN.
 *
 * If n is negative:
 * - convert n to positive
 * - take reciprocal at the end (1 / ans)
 *
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */

class Solution {

    public double myPow(double x, int n) {

        double ans = 1.0;

        long nn = n;

        // handle negative exponent
        if (nn < 0) nn = -1 * nn;

        while (nn > 0) {

            // if n is odd
            if (nn % 2 == 1) {
                ans = ans * x;
                nn = nn - 1;
            }

            // if n is even
            else {
                x = x * x;
                nn = nn / 2;
            }
        }

        // if original n was negative
        if (n < 0) ans = 1.0 / ans;

        return ans;
    }
}