/**
 * Problem: 54. Spiral Matrix
 *
 * Given an m x n matrix,
 * return all elements of the matrix in spiral order.
 *
 * Approach:
 * We maintain four boundaries:
 *
 * top    -> First row
 * bottom -> Last row
 * left   -> First column
 * right  -> Last column
 *
 * We traverse in four directions:
 *
 * 1. Left  -> Right
 * 2. Top   -> Bottom
 * 3. Right -> Left
 * 4. Bottom-> Top
 *
 * After completing each direction,
 * we move the corresponding boundary inward.
 *
 * Time Complexity: O(m * n)
 * Space Complexity: O(1)
 * (Ignoring the output list)
 */

class Solution {

    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> ans = new ArrayList<>();

        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {

            // Traverse Left -> Right
            for (int i = left; i <= right; i++) {
                ans.add(matrix[top][i]);
            }
            top++;

            // Traverse Top -> Bottom
            for (int i = top; i <= bottom; i++) {
                ans.add(matrix[i][right]);
            }
            right--;

            // Traverse Right -> Left
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    ans.add(matrix[bottom][i]);
                }
                bottom--;
            }

            // Traverse Bottom -> Top
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    ans.add(matrix[i][left]);
                }
                left++;
            }
        }

        return ans;
    }
}