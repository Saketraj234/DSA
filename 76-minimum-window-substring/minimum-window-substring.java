/**
 * Problem: 76. Minimum Window Substring
 *
 * Given two strings s and t,
 * return the minimum window substring of s
 * such that every character in t (including duplicates)
 * is included in the window.
 *
 * If there is no such substring, return "".
 *
 * Approach:
 * We use Sliding Window + Hash Array.
 *
 * 1. Store frequencies of all characters of t.
 * 2. Expand the window using right pointer.
 * 3. Whenever a required character is found,
 *    increase the count.
 * 4. When all characters of t are present in the window,
 *    start shrinking from the left.
 * 5. Keep updating the minimum length window.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(256) ≈ O(1)
 */

class Solution {

    public String minWindow(String s, String t) {

        int n = s.length();
        int m = t.length();

        int[] hash = new int[256];

        // Store frequency of characters in t
        for (int i = 0; i < m; i++) {
            hash[t.charAt(i)]++;
        }

        int left = 0;
        int right = 0;

        int count = 0;
        int minLen = Integer.MAX_VALUE;
        int startIndex = -1;

        while (right < n) {

            // Required character found
            if (hash[s.charAt(right)] > 0) {
                count++;
            }

            hash[s.charAt(right)]--;

            // All characters of t are present
            while (count == m) {

                // Update minimum window
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    startIndex = left;
                }

                // Remove left character
                hash[s.charAt(left)]++;

                // Window becomes invalid
                if (hash[s.charAt(left)] > 0) {
                    count--;
                }

                left++;
            }

            right++;
        }

        return startIndex == -1
                ? ""
                : s.substring(startIndex, startIndex + minLen);
    }
}