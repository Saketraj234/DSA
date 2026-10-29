
/**
 * Problem: 52. N-Queens II
 *
 * Given an integer n, return the number of distinct
 * solutions to the n-queens puzzle.
 *
 * Approach:
 * We use Backtracking with Bitmasking.
 *
 * cols = columns already occupied.
 * diag1 = left diagonal occupied.
 * diag2 = right diagonal occupied.
 *
 * available = positions where queen can be placed.
 *
 * We select one available position at a time
 * and recursively move to the next row.
 *
 * If row == n, we found one valid solution.
 *
 * Time Complexity: O(N!)
 * Space Complexity: O(N)
 */

class Solution {

    int count = 0;

    public int totalNQueens(int n) {

        solve(0, n, 0, 0, 0);

        return count;
    }

    void solve(int row, int n,
               int cols, int diag1, int diag2) {

        if (row == n) {
            count++;
            return;
        }

        int mask = (1 << n) - 1;

        int available = mask & ~(cols | diag1 | diag2);

        while (available != 0) {

            int bit = available & -available;

            available -= bit;

            solve(row + 1, n,
                  cols | bit,
                  ((diag1 | bit) << 1) & mask,
                  (diag2 | bit) >> 1);
        }
    }
}
