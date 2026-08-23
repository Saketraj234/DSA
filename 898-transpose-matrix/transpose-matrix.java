/**
 * Problem: 867. Transpose Matrix
 *
 * Given a 2D integer matrix matrix,
 * return the transpose of matrix.
 *
 * Approach:
 * We use a new matrix for the transpose.
 *
 * In Transpose:
 *
 * matrix[i][j] -> ans[j][i]
 *
 * We swap the row and column indexes.
 *
 * Example:
 *
 * matrix[0][1] = 2
 * ans[1][0] = 2
 *
 * Time Complexity: O(n * m)
 * Space Complexity: O(n * m)
 */

class Solution {
    public int[][] transpose(int[][] matrix) {

        int n = matrix.length;
        int m = matrix[0].length;

        int[][] ans = new int[m][n];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                ans[j][i] = matrix[i][j];
            }
        }
        return ans;
    }
}