/**
 * Problem: 389. Find the Difference
 *
 * Given two strings s and t.
 * String t contains all characters of s + one extra character.
 * Return the extra character.
 *
 * Approach:
 * We use XOR.
 *
 * Same characters cancel each other:
 * a ^ a = 0
 * 0 ^ a = a
 *
 * So, after XORing all characters of both strings,
 * only the extra character remains.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public char findTheDifference(String s, String t) {
       char ans = 0;

        for(int i = 0; i < s.length(); i++){
            ans = (char)(ans ^ s.charAt(i));
        }

        for(int i = 0; i < t.length(); i++){
            ans = (char)(ans ^ t.charAt(i));
        }
        return ans;
    }
}