/**
 * Problem: 37. Sudoku Solver
 *
 * Write a program to solve a Sudoku puzzle by filling empty cells.
 *
 * Rules:
 * 1. Each row must contain digits 1-9 without repetition.
 * 2. Each column must contain digits 1-9 without repetition.
 * 3. Each 3x3 sub-box must contain digits 1-9 without repetition.
 *
 * Empty cells are represented by '.'.
 *
 * --------------------------------------------------
 * Example:
 *
 * Input:
 * [
 * ["5","3",".",".","7",".",".",".","."],
 * ["6",".",".","1","9","5",".",".","."],
 * [".","9","8",".",".",".",".","6","."],
 * ["8",".",".",".","6",".",".",".","3"],
 * ["4",".",".","8",".","3",".",".","1"],
 * ["7",".",".",".","2",".",".",".","6"],
 * [".","6",".",".",".",".","2","8","."],
 * [".",".",".","4","1","9",".",".","5"],
 * [".",".",".",".","8",".",".","7","9"]
 * ]
 *
 * Output (After solving, board gets modified in-place):
 * [
 * ["5","3","4","6","7","8","9","1","2"],
 * ["6","7","2","1","9","5","3","4","8"],
 * ["1","9","8","3","4","2","5","6","7"],
 * ["8","5","9","7","6","1","4","2","3"],
 * ["4","2","6","8","5","3","7","9","1"],
 * ["7","1","3","9","2","4","8","5","6"],
 * ["9","6","1","5","3","7","2","8","4"],
 * ["2","8","7","4","1","9","6","3","5"],
 * ["3","4","5","2","8","6","1","7","9"]
 * ]
 *
 * --------------------------------------------------
 *
 * Approach: Backtracking
 *
 * Steps:
 * 1. Traverse each cell.
 * 2. If cell is '.', try digits '1' to '9'.
 * 3. Check validity (row, column, 3x3 box).
 * 4. If valid, place number and recurse.
 * 5. If recursion fails → backtrack.
 *
 * Time Complexity: O(9^(81))
 * Space Complexity: O(1) + recursion stack O(81)
 */

class Solution {

    public void solveSudoku(char[][] board) {
        solve(board);
    }

    public boolean solve(char[][] board) {

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                // If empty cell found
                if (board[i][j] == '.') {

                    // Try numbers 1 to 9
                    for (char c = '1'; c <= '9'; c++) {

                        // Check if valid
                        if (isValid(board, i, j, c)) {

                            // Place number
                            board[i][j] = c;

                            // Recurse
                            if (solve(board)) {
                                return true;
                            }

                            // Backtrack
                            board[i][j] = '.';
                        }
                    }

                    // If no number fits
                    return false;
                }
            }
        }

        // Board solved
        return true;
    }

    public boolean isValid(char[][] board, int row, int col, char c) {

        for (int i = 0; i < 9; i++) {

            // Check column
            if (board[i][col] == c) return false;

            // Check row
            if (board[row][i] == c) return false;

            // Check 3x3 box
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c)
                return false;
        }

        return true;
    }
}