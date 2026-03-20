/**
 * Problem: 1903. Largest Odd Number in a String
 *
 * Given a numeric string num,
 * return the largest-valued odd substring.
 *
 * Approach:
 * We traverse the string from right to left.
 *
 * Since an odd number must end with (1,3,5,7,9),
 * we find the first odd digit from the end.
 *
 * Once found, we return substring from index 0 to that position.
 *
 * If no odd digit exists, return empty string.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {

    public String largestOddNumber(String num) {

        // Start from the last index
        int n = num.length();

        for (int i = n - 1; i >= 0; i--) {

            // Convert char to digit
            int digit = num.charAt(i) - '0';

            // Check if digit is odd
            if (digit % 2 != 0) {

                // Return substring from start to i
                return num.substring(0, i + 1);
            }
        }

        // No odd digit found
        return "";
    }
}