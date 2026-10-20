
/**
 * Problem: 87. Scramble String
 *
 * Given two strings s1 and s2 of the same length,
 * return true if s2 is a scrambled string of s1.
 *
 * Approach:
 * We use Dynamic Programming + Memoization.
 *
 * 1. If both substrings are equal, return true.
 * 2. If their character frequencies differ, return false.
 * 3. Try every possible split position.
 * 4. Check both cases:
 *    - Without swapping the two parts.
 *    - With swapping the two parts.
 *
 * Time Complexity: O(n^4)
 * Space Complexity: O(n^3)
 */

import java.util.Arrays;

class Solution {

    private Boolean[][][] dp;

    public boolean isScramble(String s1, String s2) {

        int n = s1.length();

        if (n != s2.length()) {
            return false;
        }

        dp = new Boolean[n][n][n + 1];

        return solve(s1, s2, 0, 0, n);
    }

    private boolean solve(String s1, String s2,
                          int i, int j, int len) {

        if (s1.substring(i, i + len)
              .equals(s2.substring(j, j + len))) {
            return true;
        }

        if (dp[i][j][len] != null) {
            return dp[i][j][len];
        }

        int[] freq = new int[26];

        for (int k = 0; k < len; k++) {
            freq[s1.charAt(i + k) - 'a']++;
            freq[s2.charAt(j + k) - 'a']--;
        }

        for (int count : freq) {
            if (count != 0) {
                return dp[i][j][len] = false;
            }
        }

        for (int k = 1; k < len; k++) {

            // Case 1: No swap
            if (solve(s1, s2, i, j, k) &&
                solve(s1, s2, i + k, j + k, len - k)) {

                return dp[i][j][len] = true;
            }

            // Case 2: Swap
            if (solve(s1, s2, i, j + len - k, k) &&
                solve(s1, s2, i + k, j, len - k)) {

                return dp[i][j][len] = true;
            }
        }

        return dp[i][j][len] = false;
    }
}
