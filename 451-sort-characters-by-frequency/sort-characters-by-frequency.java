/**
 * Problem: 451. Sort Characters By Frequency
 *
 * Given a string s,
 * return the string sorted in decreasing order based on frequency.
 *
 * Approach:
 * We use Bucket Sort.
 *
 * 1. Count frequency using HashMap.
 * 2. Create bucket where index = frequency.
 * 3. Store characters in their respective frequency bucket.
 * 4. Traverse bucket from high to low and build result.
 *
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */

class Solution {

    public String frequencySort(String s) {

        // Step 1: Frequency map
        HashMap<Character, Integer> map = new HashMap<>();

        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // Step 2: Bucket array (index = frequency)
        List<Character>[] bucket = new List[s.length() + 1];

        // Step 3: Fill bucket
        for (char ch : map.keySet()) {
            int freq = map.get(ch);

            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }

            bucket[freq].add(ch);
        }

        // Step 4: Build result from high frequency to low
        StringBuilder result = new StringBuilder();

        for (int i = bucket.length - 1; i >= 0; i--) {
            if (bucket[i] != null) {

                for (char ch : bucket[i]) {

                    // add character 'i' times (i = frequency)
                    for (int j = 0; j < i; j++) {
                        result.append(ch);
                    }
                }
            }
        }

        return result.toString();
    }
}
