/**
 * Problem: 139. Word Break
 *
 * Given a string s and a dictionary of strings wordDict,
 * return true if s can be segmented into one or more
 * dictionary words.
 *
 * Approach:
 * We use Dynamic Programming.
 *
 * dp[i] = true
 * Means first i characters of the string can be segmented.
 *
 * Transition:
 * For every index i,
 * check all possible break points j.
 *
 * If:
 * dp[j] == true
 * and
 * s.substring(j, i) exists in the dictionary,
 *
 * then
 * dp[i] = true.
 *
 * Final Answer = dp[n]
 *
 * Time Complexity: O(n²)
 * Space Complexity: O(n)
 */

class Solution {

    public boolean wordBreak(String s, List<String> wordDict) {

        HashSet<String> set = new HashSet<>(wordDict);

        int n = s.length();

        boolean[] dp = new boolean[n + 1];

        // Empty string is always valid
        dp[0] = true;

        for (int i = 1; i <= n; i++) {

            for (int j = 0; j < i; j++) {

                // Previous part is valid
                // and current word exists in dictionary
                if (dp[j] && set.contains(s.substring(j, i))) {

                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }
}