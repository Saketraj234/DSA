/**
 * Problem: 8. String to Integer (atoi)
 *
 * Given a string s, convert it to a 32-bit signed integer.
 *
 * Rules:
 * 1. Ignore leading whitespaces.
 * 2. Check for optional '+' or '-' sign.
 * 3. Read digits until non-digit appears.
 * 4. Handle overflow:
 *    > Integer.MAX_VALUE → return MAX
 *    < Integer.MIN_VALUE → return MIN
 * 5. If no digits found → return 0
 *
 * Approach:
 * We simulate the process step-by-step.
 *
 * 1. Skip spaces
 * 2. Detect sign
 * 3. Read digits
 * 4. Check overflow before adding digit
 *
 * Overflow Condition:
 * If result > (MAX - digit) / 10 → overflow
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {

    public int myAtoi(String s) {

        int i = 0;
        int n = s.length();

        // 1. Skip leading spaces
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        // 2. Handle sign
        int sign = 1;
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            if (s.charAt(i) == '-') {
                sign = -1;
            }
            i++;
        }

        // 3. Convert digits to number
        int result = 0;

        while (i < n && Character.isDigit(s.charAt(i))) {

            int digit = s.charAt(i) - '0';

            // 4. Check overflow before updating result
            if (result > (Integer.MAX_VALUE - digit) / 10) {
                if (sign == 1) return Integer.MAX_VALUE;
                else return Integer.MIN_VALUE;
            }

            result = result * 10 + digit;
            i++;
        }

        return result * sign;
    }
}