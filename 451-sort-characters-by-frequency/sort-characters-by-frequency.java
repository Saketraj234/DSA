class Solution {
    public String frequencySort(String s) {

        // Step 1: count frequency
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // Step 2: bucket (index = frequency)
        List<Character>[] bucket = new List[s.length() + 1];

        // Step 3: fill bucket
        for (char ch : map.keySet()) {
            int freq = map.get(ch);

            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }

            bucket[freq].add(ch);
        }

        // Step 4: build result (high → low freq)
        StringBuilder result = new StringBuilder();

        for (int i = bucket.length - 1; i >= 0; i--) {
            if (bucket[i] != null) {
                for (char ch : bucket[i]) {

                    // add char i times (i = freq)
                    for (int j = 0; j < i; j++) {
                        result.append(ch);
                    }
                }
            }
        }

        return result.toString();
    }
}