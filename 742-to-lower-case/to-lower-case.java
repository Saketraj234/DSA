/**
 * Problem: 709. To Lower Case
 *
 * Given a string s, return the string after converting
 * all uppercase letters into lowercase letters.
 *
 * Approach:
 * We traverse the string character by character.
 *
 * If the character is between 'A' and 'Z',
 * convert it into lowercase by adding 32.
 *
 * Otherwise, keep the character unchanged.
 *
 * We use StringBuilder to build the answer.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

class Solution {
    public String toLowerCase(String s) {
        
        StringBuilder result = new StringBuilder();

        for(char ch : s.toCharArray()){

            if(ch >= 'A' && ch <= 'Z'){
                ch = (char)(ch + 32);
            }
            result.append(ch);
        }
        return result.toString();
    }
}