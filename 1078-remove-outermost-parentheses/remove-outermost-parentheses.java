/**
 * Problem: 1021. Remove Outermost Parentheses
 *
 * Given a valid parentheses string s,
 * remove the outermost parentheses of every primitive substring.
 *
 * A primitive is a non-empty valid parentheses string
 * that cannot be split into smaller valid parts.
 *
 * Approach:
 * We use a depth counter.
 *
 * - '(' increases depth
 * - ')' decreases depth
 *
 * Key Idea:
 * We only add brackets when depth > 0
 * (i.e., we are inside the primitive, not at outermost level)
 *
 * Trick:
 * For '(' → check before increasing depth
 * For ')' → check after decreasing depth
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

class Solution {

    public String removeOuterParentheses(String s) {

        StringBuilder res = new StringBuilder();
        int depth = 0;

        for (char c : s.toCharArray()) {

            // If opening bracket
            // Add only if already inside (depth > 0)
            if (c == '(' && depth++ > 0) {
                res.append(c);
            }

            // If closing bracket
            // Reduce depth first, then check
            if (c == ')' && --depth > 0) {
                res.append(c);
            }
        }

        return res.toString();
    }
}