/**
 * Problem: 51. N-Queens
 *
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 *
 * Each solution contains a distinct board configuration where:
 * 'Q' indicates a queen and '.' indicates an empty space.
 *
 * A queen can attack horizontally, vertically, and diagonally.
 * So no two queens should attack each other.
 *
 * Example:
 * Input: n = 4
 * Output:
 * [
 *  [".Q..","...Q","Q...","..Q."],
 *  ["..Q.","Q...","...Q",".Q.."]
 * ]
 *
 * Approach:
 * We use Backtracking + Hashing (Optimization).
 *
 * Instead of checking whole board every time,
 * we maintain 3 arrays:
 *
 * leftRow[n] -> row occupied or not
 * lowerDiagonal[2*n-1] -> row + col
 * upperDiagonal[2*n-1] -> n-1 + col - row
 *
 * This allows O(1) checking.
 *
 * We place queen column by column.
 * If safe → place → recurse → backtrack.
 *
 * Time Complexity: O(N!)
 * Space Complexity: O(N^2) + O(N)
 */
class Solution {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();

        char[][] board = new char[n][n];
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }

        int[] leftRow = new int[n];
        int[] lowerDiagonal = new int[2 * n - 1];
        int[] upperDiagonal = new int[2 * n - 1];

        solve(0, board, ans, leftRow, lowerDiagonal, upperDiagonal, n);
        return ans;
    }

    private void solve(int col, char[][] board, List<List<String>> ans,
                       int[] leftRow, int[] lowerDiagonal, int[] upperDiagonal, int n) {

        // Base Case: all queens placed
        if (col == n) {
            ans.add(construct(board));
            return;
        }

        for (int row = 0; row < n; row++) {

            // Check if safe
            if (leftRow[row] == 0 &&
                lowerDiagonal[row + col] == 0 &&
                upperDiagonal[n - 1 + col - row] == 0) {

                // Place Queen
                board[row][col] = 'Q';
                leftRow[row] = 1;
                lowerDiagonal[row + col] = 1;
                upperDiagonal[n - 1 + col - row] = 1;

                // Recurse
                solve(col + 1, board, ans, leftRow, lowerDiagonal, upperDiagonal, n);

                // Backtrack
                board[row][col] = '.';
                leftRow[row] = 0;
                lowerDiagonal[row + col] = 0;
                upperDiagonal[n - 1 + col - row] = 0;
            }
        }
    }

    // Convert board to list
    private List<String> construct(char[][] board) {
        List<String> res = new ArrayList<>();
        for (char[] row : board) {
            res.add(new String(row));
        }
        return res;
    }
}