
/**
 * Problem: 30. Substring with Concatenation of All Words
 *
 * Given a string s and an array of strings words,
 * find all starting indices of substrings that contain
 * every word exactly once, without any gaps.
 *
 * Approach:
 * We use Sliding Window + HashMap.
 *
 * All words have the same length.
 * We check each possible starting offset and maintain
 * the frequency of words inside the window.
 *
 * If a word is invalid, reset the window.
 * If a word occurs too many times, shrink the window.
 * When all words match, store the starting index.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(m)
 */

import java.util.*;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {

        List<Integer> result = new ArrayList<>();

        if (s == null || words == null ||
            words.length == 0 || s.isEmpty()) {
            return result;
        }

        int wordLen = words[0].length();
        int wordCount = words.length;
        int totalLen = wordLen * wordCount;
        int n = s.length();

        if (n < totalLen) return result;

        Map<String, Integer> wordFreq = new HashMap<>();

        for (String word : words) {
            wordFreq.put(word,
                wordFreq.getOrDefault(word, 0) + 1);
        }

        for (int offset = 0; offset < wordLen; offset++) {

            int left = offset;
            int count = 0;

            Map<String, Integer> window = new HashMap<>();

            for (int right = offset;
                 right + wordLen <= n;
                 right += wordLen) {

                String word = s.substring(right, right + wordLen);

                if (!wordFreq.containsKey(word)) {
                    window.clear();
                    count = 0;
                    left = right + wordLen;
                    continue;
                }

                window.put(word,
                    window.getOrDefault(word, 0) + 1);
                count++;

                while (window.get(word) > wordFreq.get(word)) {

                    String leftWord = s.substring(left, left + wordLen);

                    window.put(leftWord, window.get(leftWord) - 1);
                    left += wordLen;
                    count--;
                }

                if (count == wordCount) {
                    result.add(left);

                    String leftWord = s.substring(left, left + wordLen);

                    window.put(leftWord, window.get(leftWord) - 1);
                    left += wordLen;
                    count--;
                }
            }
        }

        Collections.sort(result);
        return result;
    }
}
