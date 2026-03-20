/**
 * Problem: 151. Reverse Words in a String
 *
 * Given a string s, reverse the order of words.
 * A word is defined as a sequence of non-space characters.
 *
 * Example:
 * Input:  "the sky is blue"
 * Output: "blue is sky the"
 *
 * Approach:
 * We use Two Pointer + Backward Traversal.
 *
 * 1. Start from the end of the string.
 * 2. Skip all trailing spaces.
 * 3. Mark the end of the word using pointer j.
 * 4. Move pointer i backward to find the start of the word.
 * 5. Extract substring(i+1, j+1) → this gives one word.
 * 6. Append it to the result.
 * 7. Repeat until entire string is traversed.
 *
 * Final step:
 * Remove extra space using trim().
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

class Solution {

    public String reverseWords(String s) {

        StringBuilder ans = new StringBuilder();
        int i = s.length() - 1;

        while (i >= 0) {

            while (i >= 0 && s.charAt(i) == ' ') i--;

            int j = i;

            while (i >= 0 && s.charAt(i) != ' ') i--;

            if (j >= 0) {
                ans.append(s.substring(i + 1, j + 1)).append(" ");
            }
        }

        return ans.toString().trim();
    }
}
