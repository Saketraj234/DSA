/**
 * Problem: 130. Surrounded Regions
 *
 * Given an m x n board containing 'X' and 'O',
 * capture all regions surrounded by 'X'.
 *
 * Approach:
 * We use DFS from the BORDER.
 *
 * Observation:
 * Border connected 'O' can NEVER be surrounded.
 *
 * Steps:
 * 1. Traverse all border cells.
 * 2. If border cell contains 'O',
 *    run DFS and mark all connected 'O' as '#'.
 * 3. Traverse the entire board.
 *      'O' -> 'X'
 *      '#' -> 'O'
 *
 * Time Complexity: O(m × n)
 * Space Complexity: O(m × n)   // Recursion Stack
 */

class Solution {

    int m;
    int n;

    public void solve(char[][] board) {

        m = board.length;
        n = board[0].length;

        // ---------- First Row ----------
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') {
                dfs(board, 0, j);
            }
        }

        // ---------- Last Row ----------
        for (int j = 0; j < n; j++) {
            if (board[m - 1][j] == 'O') {
                dfs(board, m - 1, j);
            }
        }

        // ---------- First Column ----------
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                dfs(board, i, 0);
            }
        }

        // ---------- Last Column ----------
        for (int i = 0; i < m; i++) {
            if (board[i][n - 1] == 'O') {
                dfs(board, i, n - 1);
            }
        }

        // Convert Remaining O -> X
        // Convert # -> O
        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }

                else if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int row, int col) {

        // Out of Boundary
        if (row < 0 || row >= m || col < 0 || col >= n)
            return;

        // Stop if X or Already Visited
        if (board[row][col] != 'O')
            return;

        // Mark Safe Cell
        board[row][col] = '#';

        // Up
        dfs(board, row - 1, col);

        // Down
        dfs(board, row + 1, col);

        // Left
        dfs(board, row, col - 1);

        // Right
        dfs(board, row, col + 1);
    }
}