/**
 * Problem: 242. Valid Anagram
 *
 * Given two strings s and t,
 * return true if t is an anagram of s,
 * otherwise return false.
 *
 * Anagram:
 * - Same characters
 * - Same frequency
 * - Order doesn't matter
 *
 * Approach:
 * We use Frequency Array (size 26).
 *
 * Step 1: If lengths are not equal → return false
 *
 * Step 2: Count frequency of characters in s
 *
 * Step 3: Decrease frequency using t
 *         If any count becomes negative → return false
 *
 * Step 4: If all checks passed → return true
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {

    public boolean isAnagram(String s, String t) {

        // Step 1: length check
        if (s.length() != t.length()) {
            return false;
        }

        // Step 2: frequency array for a-z
        int[] freq = new int[26];

        // Step 3: increase count for s
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }

        // Step 4: decrease count for t
        for (int i = 0; i < t.length(); i++) {

            freq[t.charAt(i) - 'a']--;

            // if count becomes negative → extra char in t
            if (freq[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }

        // Step 5: valid anagram
        return true;
    }
}