class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {

        paragraph = paragraph.toLowerCase()
                .replaceAll("[^a-z ]", " ");

        String[] words = paragraph.split("\\s+");

        // Banned words ko Set me rakho
        Set<String> ban = new HashSet<>();

        for (String word : banned) {
            ban.add(word);
        }

        // Frequency count
        Map<String, Integer> map = new HashMap<>();

        String ans = "";
        int max = 0;

        for (String word : words) {

            if (ban.contains(word)) {
                continue;
            }

            int count = map.getOrDefault(word, 0) + 1;
            map.put(word, count);

            if (count > max) {
                max = count;
                ans = word;
            }
        }

        return ans;
    }
}