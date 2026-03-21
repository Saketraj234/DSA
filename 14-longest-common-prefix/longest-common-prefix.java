/**
 * Problem: 14. Longest Common Prefix
 *
 * Given an array of strings strs,
 * return the longest common prefix among them.
 * If there is no common prefix, return "".
 *
 * Approach: Vertical Scanning
 *
 * We take the first string as base.
 * Then we compare each character with all other strings.
 *
 * If any mismatch occurs OR any string ends,
 * we return the prefix till that point.
 *
 * Time Complexity: O(n * m)
 * n = number of strings
 * m = length of smallest string
 *
 * Space Complexity: O(1)
 */

class Solution {

    public String longestCommonPrefix(String[] strs) {

        // Edge case: empty array
        if (strs == null || strs.length == 0) {
            return "";
        }

        // Take first string as base
        String base = strs[0];

        // Traverse each character of base
        for (int i = 0; i < base.length(); i++) {

            char ch = base.charAt(i);

            // Compare with all other strings
            for (int j = 1; j < strs.length; j++) {

                // If string ends OR mismatch found
                if (i == strs[j].length() || strs[j].charAt(i) != ch) {

                    // Return prefix till previous index
                    return base.substring(0, i);
                }
            }
        }

        // If all characters matched
        return base;
    }
}