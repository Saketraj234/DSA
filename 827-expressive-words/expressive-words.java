/**
 * Problem: 809. Expressive Words
 *
 * Given a string s and an array of words,
 * return the number of words that can be stretched to s.
 *
 * Approach:
 * We compare groups of same characters using two pointers.
 *
 * lenS = length of character group in s
 * lenWord = length of character group in word
 *
 * If characters differ, the word is invalid.
 * If lenS < lenWord, the word is invalid.
 * If lengths differ and lenS < 3, the word is invalid.
 *
 * If the word is valid, increase count.
 *
 * Time Complexity: O(n * m)
 * Space Complexity: O(1)
 */

class Solution {
    public int expressiveWords(String s, String[] words) {
        
        int n = words.length;
        int count = 0;

        for(int i = 0; i < n; i++){
            String word = words[i];

            int j = 0, k = 0;
            boolean valid = true;

            while(j < s.length() && k < word.length()){
                if(s.charAt(j) != word.charAt(k)){
                    valid = false;
                    break;
                }

                int startJ = j;
                int startK = k;

                while (j < s.length() && s.charAt(j) == s.charAt(startJ)) j++;

                while (k < word.length() && word.charAt(k) == word.charAt(startK)) k++;


                int lenS = j - startJ;
                int lenWord = k - startK;

                if(lenS < lenWord || (lenS != lenWord && lenS < 3)){
                    valid = false;
                    break;
                }
            }

            if(j != s.length() || k != word.length())
            valid = false;

            if(valid)
            count++;
        }
        return count;
    }
}