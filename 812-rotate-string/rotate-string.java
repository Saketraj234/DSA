/**
 * Problem: 796. Rotate String
 *
 * Given two strings s and goal,
 * return true if s can become goal after some rotations.
 *
 * A rotation means moving characters circularly.
 *
 * Example:
 * s = "abcde", goal = "cdeab" → true
 * s = "abcde", goal = "abced" → false
 *
 * Approach (Optimal):
 * Instead of checking all rotations,
 * we use the property:
 *
 * 👉 If goal is a rotation of s,
 * then goal must be a substring of (s + s).
 *
 * Steps:
 * 1. If lengths are not equal → return false.
 * 2. Create a new string by concatenating s with itself → s + s.
 * 3. Check if goal exists inside (s + s).
 * 4. If yes → return true, else → false.
 *
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */

class Solution {

    public boolean rotateString(String s, String goal) {

        if (s.length() != goal.length()) {
            return false;
        }

        return (s + s).contains(goal);
    }
}
