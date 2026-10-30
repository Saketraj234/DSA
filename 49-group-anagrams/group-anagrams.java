/*
 * Problem: 49. Group Anagrams
 *
 * Given an array of strings strs,
 * group the anagrams together.
 *
 * Approach:
 * We use HashMap + Character Frequency.
 *
 * Two strings are anagrams if they contain
 * the same characters with the same frequency.
 *
 * We create a frequency array of size 26.
 *
 * Example:
 * "eat" -> [1,0,0,0,1,...,1]
 * "tea" -> [1,0,0,0,1,...,1]
 *
 * Both have the same frequency pattern,
 * so they belong to the same group.
 *
 * We use this frequency pattern as the HashMap key.
 *
 * Final Answer: Return all grouped anagrams.
 *
 * Time Complexity: O(n * k)
 * Space Complexity: O(n * k)
 */

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {

            int[] count = new int[26];

            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }

            StringBuilder key = new StringBuilder();

            for (int num : count) {
                key.append(num).append("#");
            }

            map.putIfAbsent(key.toString(), new ArrayList<>());

            map.get(key.toString()).add(s);
        }

        return new ArrayList<>(map.values());
    }
}