/**
 * Problem: 796. Rotate String
 *
 * Given two strings s and goal,
 * return true if s can become goal after some rotations.
 *
 * A rotation means moving the last character to the front.
 *
 * Example:
 * s = "abcde", goal = "cdeab" → true
 * s = "abcde", goal = "abced" → false
 *
 * Approach:
 * 1. If lengths are not equal → return false.
 * 2. If s equals goal → return true.
 * 3. Rotate string n times:
 *      - Move last character to front
 *      - Check after each rotation
 *
 * Time Complexity: O(N^2)
 * Space Complexity: O(N)
 */

class Solution {

    public boolean rotateString(String s, String goal) {

        if (s.length() != goal.length()) {
            return false;
        }

        if (s.equals(goal)) {
            return true;
        }

        String curr = s;
        int n = curr.length();

        for (int i = 0; i < n; i++) {

            // Rotate (last char → front)
            curr = curr.charAt(n - 1) + curr.substring(0, n - 1);

            // Check
            if (curr.equals(goal)) {
                return true;
            }
        }

        return false;
    }
}