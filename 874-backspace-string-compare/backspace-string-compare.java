/*
 * Problem: 844. Backspace String Compare
 *
 * Given two strings s and t,
 * return true if they are equal after backspaces.
 *
 * Approach:
 * We use Two Pointers.
 *
 * Start from the end of both strings.
 * Skip characters deleted by '#'.
 *
 * Compare the remaining characters.
 * If they differ, return false.
 *
 * If all characters match, return true.
 *
 * Time Complexity: O(n + m)
 * Space Complexity: O(1)
 */

class Solution {
    public boolean backspaceCompare(String s, String t) {

        int i = s.length() - 1;
        int j = t.length() - 1;

        while (i >= 0 || j >= 0) {

            int skipS = 0;
            int skipT = 0;

            while (i >= 0) {
                if (s.charAt(i) == '#') {
                    skipS++;
                    i--;
                } else if (skipS > 0) {
                    skipS--;
                    i--;
                } else {
                    break;
                }
            }

            while (j >= 0) {
                if (t.charAt(j) == '#') {
                    skipT++;
                    j--;
                } else if (skipT > 0) {
                    skipT--;
                    j--;
                } else {
                    break;
                }
            }

            if (i >= 0 && j >= 0
                    && s.charAt(i) != t.charAt(j)) {
                return false;
            }

            if ((i >= 0) != (j >= 0)) {
                return false;
            }

            i--;
            j--;
        }

        return true;
    }
}