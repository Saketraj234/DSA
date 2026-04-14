/**
 * Problem: 22. Generate Parentheses
 *
 * Given n pairs of parentheses,
 * generate all combinations of well-formed parentheses.
 *
 * Approach:
 * We use Backtracking (Recursion).
 *
 * We keep track of:
 * open  = number of '(' used
 * close = number of ')' used
 *
 * Rules:
 * 1. We can add '(' if open < n
 * 2. We can add ')' if close < open
 *
 * Base Case:
 * If current string length == 2 * n,
 * then it is a valid combination.
 *
 * Time Complexity: O(2^n) approx (Catalan number)
 * Space Complexity: O(n)
 */

 class Solution {

    public List<String> generateParenthesis(int n) {
        // result list to store all valid combinations
        List<String> result = new ArrayList<>();

        // start backtracking
        backtrack(result, "", 0, 0, n);

        return result;
    }

    private void backtrack(List<String> result, String curr, int open, int close, int n) {

        // Base case: if length becomes 2*n → valid string
        if (curr.length() == 2 * n) {
            result.add(curr);
            return;
        }

        // Add '(' if we still have remaining
        if (open < n) {
            backtrack(result, curr + "(", open + 1, close, n);
        }

        // Add ')' only if it won’t make invalid sequence
        if (close < open) {
            backtrack(result, curr + ")", open, close + 1, n);
        }
    }
}