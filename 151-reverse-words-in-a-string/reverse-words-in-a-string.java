/**
 * Problem: 151. Reverse Words in a String
 *
 * Given a string s, reverse the order of words.
 *
 * Example:
 * Input:  "the sky is blue"
 * Output: "blue is sky the"
 *
 * Approach:
 * 1. Reverse the entire string.
 * 2. Traverse and pick each word.
 * 3. Reverse each word to make it correct.
 * 4. Append to result with proper spacing.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

class Solution {

    public String reverseWords(String s) {

        // Step 1: Length of string
        int n = s.length();

        // Step 2: Final answer store karne ke liye
        StringBuilder ans = new StringBuilder();

        // Step 3: String ko reverse karo
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();   // pura string ulta ho gaya

        // Step 4: Traverse reversed string
        for (int i = 0; i < n; i++) {

            // Har word ko store karne ke liye
            StringBuilder word = new StringBuilder();

            // Step 5: Jab tak space na mile, characters uthao
            while (i < n && sb.charAt(i) != ' ') {
                word.append(sb.charAt(i));  // character add
                i++;
            }

            // Step 6: Word ko reverse karo (kyunki ulta tha)
            word.reverse();

            // Step 7: Agar word empty nahi hai tab add karo
            if (word.length() > 0) {
                ans.append(" ").append(word);
            }
        }

        // Step 8: First extra space hata do
        return ans.substring(1);
    }
}