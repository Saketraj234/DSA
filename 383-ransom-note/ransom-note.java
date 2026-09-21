/**
 * Problem: 383. Ransom Note
 *
 * Given two strings ransomNote and magazine,
 * return true if ransomNote can be constructed
 * using the letters from magazine.
 *
 * Approach:
 * We use Frequency Counting.
 *
 * First, count how many times each character
 * appears in magazine.
 *
 * Then, check each character of ransomNote.
 * If the character is available, use it.
 * If its count becomes 0, return false.
 *
 * Time Complexity: O(n + m)
 * Space Complexity: O(1)
 */

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        
        int[] freq = new int[26];

        for(char c : magazine.toCharArray()){
            freq[c - 'a']++;
        }

        for(char c : ransomNote.toCharArray()){

            if(freq[c - 'a'] == 0){
                return false;
            }
            freq[c - 'a']--;
        }

        return true;
    }
}