/**
 * Problem: 598. Range Addition II
 *
 * Given an m x n matrix initialized with 0.
 * For each operation [a, b], increment all cells
 * in the first a rows and first b columns by 1.
 *
 * Return the number of cells containing the maximum value.
 *
 * Approach:
 * We find the common area affected by all operations.
 *
 * For every operation [a, b]:
 * minRow = minimum of all a values
 * minCol = minimum of all b values
 *
 * The cells in this common area receive +1
 * from every operation, so they have the maximum value.
 *
 * Final Answer = minRow * minCol
 *
 * Time Complexity: O(k)
 * Space Complexity: O(1)
 */
 
class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        int minRow = m;
        int minCol = n;

        for(int[] op : ops){
           minRow = Math.min(minRow, op[0]);
           minCol = Math.min(minCol, op[1]);
        }
        return minRow * minCol;
    }
}