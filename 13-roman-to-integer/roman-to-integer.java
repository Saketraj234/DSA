/**
 * Problem: 13. Roman to Integer
 *
 * Given a roman numeral string s,
 * return its integer value.
 *
 * Roman Symbols:
 * I = 1, V = 5, X = 10, L = 50,
 * C = 100, D = 500, M = 1000
 *
 * Approach:
 * We traverse the string from left to right.
 *
 * If current value < next value → subtract
 * else → add
 *
 * Example:
 * IV → 1 < 5 → subtract → 4
 * VI → 5 > 1 → add → 6
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {

    public int romanToInt(String s) {

        int n = s.length();
        int result = 0;

        for (int i = 0; i < n; i++) {

            int curr = getValue(s.charAt(i));

            // Check if next element exists and is greater
            if (i < n - 1 && curr < getValue(s.charAt(i + 1))) {
                result -= curr;
            } else {
                result += curr;
            }
        }

        return result;
    }

    // Function to map Roman character to integer
    public int getValue(char ch) {

        if (ch == 'I') return 1;
        if (ch == 'V') return 5;
        if (ch == 'X') return 10;
        if (ch == 'L') return 50;
        if (ch == 'C') return 100;
        if (ch == 'D') return 500;

        return 1000; // M
    }
}