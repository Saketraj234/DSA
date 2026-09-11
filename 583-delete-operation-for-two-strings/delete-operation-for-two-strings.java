/**
 * Problem: 583. Delete Operation for Two Strings
 *
 * Given two strings word1 and word2.
 * In one operation, we can delete one character
 * from either string.
 *
 * Return the minimum number of deletions required
 * to make both strings equal.
 *
 * Approach:
 * We use Dynamic Programming (LCS).
 *
 * dp[i][j] = LCS length of first i characters of word1
 *            and first j characters of word2.
 *
 * If characters are same:
 * dp[i][j] = dp[i - 1][j - 1] + 1
 *
 * If characters are different:
 * dp[i][j] = max(dp[i - 1][j], dp[i][j - 1])
 *
 * LCS tells us how many characters we can keep.
 *
 * Final Answer = word1.length() + word2.length() - 2 * LCS
 *
 * Time Complexity: O(m * n)
 * Space Complexity: O(m * n)
 */

class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m + 1][n + 1];

        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(word1.charAt(i - 1) == word2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        int lcs = dp[m][n];
        return m + n - 2 * lcs;
    }
}