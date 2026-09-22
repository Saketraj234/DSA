/**
 * Problem: 521. Longest Uncommon Subsequence I
 *
 * Given two strings s and t.
 * Return the length of the longest uncommon subsequence.
 *
 * Approach:
 * We compare both strings.
 *
 * If both strings are same,
 * every subsequence of s will also be a subsequence of t.
 * So answer = -1.
 *
 * If strings are different,
 * the longer string itself can be an uncommon subsequence.
 * So answer = max(length of s, length of t).
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public int findLUSlength(String a, String b) {
        if(a.equals(b)){
            return -1;
        }

        return Math.max(a.length(), b.length());
    }
}