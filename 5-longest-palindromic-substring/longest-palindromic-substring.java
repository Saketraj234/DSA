/**
 * Problem: 5. Longest Palindromic Substring
 *
 * Given a string s,
 * return the longest palindromic substring in s.
 *
 * Approach:
 * We use Expand Around Center technique.
 *
 * हर character ko center maan ke left-right expand karte hain.
 *
 * 2 cases hote hain:
 * 1) Odd length palindrome → (i, i)
 * 2) Even length palindrome → (i, i+1)
 *
 * expandFromCenter:
 * jab tak left aur right same hai → expand karo
 *
 * start = palindrome ka starting index
 * end   = palindrome ka ending index
 *
 * start = i - (maxLen - 1) / 2
 * end   = i + maxLen / 2
 *
 * Time Complexity: O(n^2)
 * Space Complexity: O(1)
 */

class Solution {

    public String longestPalindrome(String s) {

        int n = s.length();

        int start = 0; // final answer start index
        int end = 0;   // final answer end index

        for (int i = 0; i < n; i++) {

            // 1) Odd length palindrome (single center)
            int len1 = expandFromCenter(s, i, i);

            // 2) Even length palindrome (double center)
            int len2 = expandFromCenter(s, i, i + 1);

            // dono me se max length
            int maxLen = Math.max(len1, len2);

            // agar naya palindrome bada hai → update karo
            if (maxLen > end - start) {

                // center se left/right nikaal rahe hain
                start = i - (maxLen - 1) / 2;
                end = i + maxLen / 2;
            }
        }

        // final substring return
        return s.substring(start, end + 1);
    }

    // 🔥 core function: expand karna
    private int expandFromCenter(String s, int left, int right) {

        // jab tak match hai → expand
        while (left >= 0 && right < s.length() &&
               s.charAt(left) == s.charAt(right)) {

            left--;   // left side move
            right++;  // right side move
        }

        // 1 extra expand ho gaya hota hai → isliye -1
        return right - left - 1;
    }
}