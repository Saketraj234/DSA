/**
 * Problem: 3. Longest Substring Without Repeating Characters
 *
 * Given a string s,
 * find the length of the longest substring
 * without repeating characters.
 *
 * Approach:
 * We use Sliding Window + Hash Array.
 *
 * hash[ch] stores the latest index
 * where character ch appeared.
 *
 * If character already exists inside window,
 * move left pointer:
 *
 * l = hash[ch] + 1
 *
 * Current Length:
 * len = r - l + 1
 *
 * Update maximum length each time.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {

    public int lengthOfLongestSubstring(String s) {

        int[] hash = new int[256];

        // initialize all with -1
        for (int i = 0; i < 256; i++) {
            hash[i] = -1;
        }

        int l = 0;
        int r = 0;
        int maxLen = 0;

        int n = s.length();

        while (r < n) {

            char ch = s.charAt(r);

            // character already exists in current window
            if (hash[ch] >= l) {

                l = hash[ch] + 1;
            }

            // current window length
            int len = r - l + 1;

            maxLen = Math.max(maxLen, len);

            // store latest index
            hash[ch] = r;

            r++;
        }

        return maxLen;
    }
}