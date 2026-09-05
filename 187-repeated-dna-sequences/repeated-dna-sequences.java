/**
 * Problem: 187. Repeated DNA Sequences
 *
 * Given a string s, return all the 10-letter-long sequences
 * that occur more than once in s.
 *
 * Approach:
 * We use HashMap.
 *
 * We create every substring of length 10.
 *
 * map.get(str) tells how many times the sequence
 * has appeared so far.
 *
 * If a sequence appears for the second time,
 * we add it to the answer.
 *
 * We check == 2 so that the same sequence
 * is not added multiple times.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

class Solution {

    public List<String> findRepeatedDnaSequences(String s) {

        HashMap<String, Integer> map = new HashMap<>();
        List<String> ans = new ArrayList<>();

        // Create every 10-letter substring
        for(int i = 0; i <= s.length() - 10; i++){

            String str = s.substring(i, i + 10);

            // Count the frequency of current sequence
            map.put(str, map.getOrDefault(str, 0) + 1);

            // Add only when it appears for the second time
            if(map.get(str) == 2){
                ans.add(str);
            }
        }

        return ans;
    }
}