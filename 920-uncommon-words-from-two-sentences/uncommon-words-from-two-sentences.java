/**
 * Problem: 884. Uncommon Words from Two Sentences
 *
 * Given two sentences s1 and s2,
 * return all the words that appear exactly once
 * in total across both sentences.
 *
 * Approach:
 * We use HashMap.
 *
 * Count the frequency of every word from both sentences.
 *
 * If frequency of a word is 1,
 * then that word is uncommon.
 *
 * We store all such words in the result.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

class Solution {

    public String[] uncommonFromSentences(String s1, String s2) {

        HashMap<String, Integer> map = new HashMap<>();

        String[] words1 = s1.split(" ");
        String[] words2 = s2.split(" ");

        for (String word : words1) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        for (String word : words2) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        ArrayList<String> result = new ArrayList<>();

        for (String word : map.keySet()) {
            if (map.get(word) == 1) {
                result.add(word);
            }
        }

        return result.toArray(new String[0]);
    }
}