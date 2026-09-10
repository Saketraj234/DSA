/**
 * Problem: 520. Detect Capital
 *
 * Given a word, return true if capital usage is correct.
 *
 * Valid cases:
 * 1. All letters are uppercase.
 * 2. All letters are lowercase.
 * 3. Only the first letter is uppercase.
 *
 * Approach:
 * We count the number of uppercase letters.
 *
 * If uppercase count == 0,
 * the whole word is lowercase.
 *
 * If uppercase count == word.length(),
 * the whole word is uppercase.
 *
 * If uppercase count == 1
 * and first letter is uppercase,
 * only the first letter is capital.
 *
 * Otherwise, return false.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public boolean detectCapitalUse(String word) {
        int count = 0;

        for(int i = 0; i < word.length(); i++){

            if(Character.isUpperCase(word.charAt(i))){
                count++;
            }
        }

        if(count == 0){
            return true;
        }

        if(count == word.length()){
            return true;
        }

        if(count == 1 && Character.isUpperCase(word.charAt(0))){
            return true;
        }
        return false;
    }
}