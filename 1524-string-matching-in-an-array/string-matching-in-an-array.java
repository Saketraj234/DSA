/**
 * Problem: 1408. String Matching in an Array
 *
 * Given an array of strings words,
 * return all strings that are present
 * as a substring of another word.
 *
 * Approach:
 * We use Brute Force.
 *
 * Check each word with every other word.
 *
 * If words[i] is present inside words[j],
 * add words[i] to the answer.
 *
 * We skip comparing a word with itself.
 *
 * Time Complexity: O(n² * L)
 * Space Complexity: O(1) extra space
 * (excluding the answer list)
 */

class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> ans = new ArrayList<>();
        int n = words.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (i != j && words[j].contains(words[i])) {
                    ans.add(words[i]);
                    break;
                }
            }
        }

        return ans;
    }
}