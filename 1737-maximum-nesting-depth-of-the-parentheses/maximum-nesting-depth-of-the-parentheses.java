/**
 * Problem: 1614. Maximum Nesting Depth of the Parentheses
 *
 * Given a valid parentheses string s,
 * return the maximum nesting depth of parentheses.
 *
 * ------------------------------------------------------
 * Approach:
 * We use a simple counter (no stack required).
 *
 * - When we see '(', we increase current depth.
 * - When we see ')', we decrease current depth.
 * - We keep updating the maximum depth at every step.
 *
 * ------------------------------------------------------
 * Key Idea:
 * currDepth → current level of nesting
 * maxDepth  → maximum nesting till now
 *
 * ------------------------------------------------------
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {

    public int maxDepth(String s) {

        // Tracks current depth of parentheses
        int currDepth = 0;

        // Stores maximum depth encountered
        int maxDepth = 0;

        // Traverse each character in string
        for (char c : s.toCharArray()) {

            // If opening bracket, go deeper
            if (c == '(') {
                currDepth++;

                // Update maximum depth
                maxDepth = Math.max(maxDepth, currDepth);
            }

            // If closing bracket, come out
            else if (c == ')') {
                currDepth--;
            }
        }

        // Return the maximum depth
        return maxDepth;
    }
}