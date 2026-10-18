
/**
 * Problem: 32. Longest Valid Parentheses
 *
 * Given a string s containing '(' and ')',
 * return the length of the longest valid parentheses substring.
 *
 * Approach:
 * We use Two Pass Traversal.
 *
 * First pass: Left to Right
 * Count '(' as left and ')' as right.
 * If left == right, update max length.
 * If right > left, reset both counters.
 *
 * Second pass: Right to Left
 * Count '(' as left and ')' as right.
 * If left == right, update max length.
 * If left > right, reset both counters.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public int longestValidParentheses(String s) {

        int left = 0;
        int right = 0;
        int maxLen = 0;

        // First pass: Left to Right
        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }

            if (left == right) {
                maxLen = Math.max(maxLen, 2 * right);
            } else if (right > left) {
                left = 0;
                right = 0;
            }
        }

        left = 0;
        right = 0;

        // Second pass: Right to Left
        for (int i = s.length() - 1; i >= 0; i--) {

            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }

            if (left == right) {
                maxLen = Math.max(maxLen, 2 * left);
            } else if (left > right) {
                left = 0;
                right = 0;
            }
        }

        return maxLen;
    }
}
