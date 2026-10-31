/**
 * Problem: 44. Wildcard Matching
 *
 * Given strings s and p, determine if they match.
 *
 * '?' matches any single character.
 * '*' matches any sequence of characters (including empty).
 *
 * Approach:
 * We use Greedy Algorithm.
 *
 * i = pointer for string s.
 * j = pointer for pattern p.
 * star = stores the last position of '*'.
 * match = stores the position in s matched by '*'.
 *
 * If characters match or pattern has '?':
 * Move both pointers.
 *
 * If pattern has '*':
 * Store its position and move j.
 *
 * If mismatch occurs:
 * Go back to the last '*'
 * and let '*' match one more character.
 *
 * Time Complexity: O(m * n) worst case for some greedy analyses;
 * practically, the standard greedy approach is commonly used.
 * Space Complexity: O(1)
 */

class Solution {

    public boolean isMatch(String s, String p) {

        int i = 0, j = 0;

        int star = -1;
        int match = 0;

        while (i < s.length()) {

            // Characters match or '?' found
            if (j < p.length() &&
                (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')) {

                i++;
                j++;
            }

            // '*' found
            else if (j < p.length() && p.charAt(j) == '*') {

                star = j;
                match = i;
                j++;
            }

            // Previous '*' exists
            else if (star != -1) {

                j = star + 1;
                match++;
                i = match;
            }

            // No match possible
            else {
                return false;
            }
        }

        // Ignore remaining '*' characters
        while (j < p.length() && p.charAt(j) == '*') {
            j++;
        }

        return j == p.length();
    }
}