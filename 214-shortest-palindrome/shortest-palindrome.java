/**
 * Problem: 214. Shortest Palindrome
 *
 * Approach:
 * We use KMP (Knuth-Morris-Pratt) algorithm.
 *
 * Reverse the string and combine:
 * s + "#" + reverse(s)
 *
 * The LPS array gives the longest palindromic
 * prefix of the original string.
 *
 * Add the remaining characters in reverse order
 * to the beginning of the string.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

class Solution {
    public String shortestPalindrome(String s) {

        String rev = new StringBuilder(s).reverse().toString();

        String combined = s + "#" + rev;

        int n = combined.length();
        int[] lps = new int[n];

        // Build LPS array
        for (int i = 1; i < n; i++) {

            int j = lps[i - 1];

            while (j > 0 && combined.charAt(i) != combined.charAt(j)) {
                j = lps[j - 1];
            }

            if (combined.charAt(i) == combined.charAt(j)) {
                j++;
            }

            lps[i] = j;
        }

        int longestPalPrefix = lps[n - 1];

        String remaining = s.substring(longestPalPrefix);

        return new StringBuilder(remaining)
                .reverse()
                .append(s)
                .toString();
    }
}