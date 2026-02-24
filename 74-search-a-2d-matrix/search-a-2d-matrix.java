/**
 * Problem: 74. Search a 2D Matrix
 *
 * The matrix is sorted in a special way:
 * - Each row is sorted in ascending order.
 * - The first element of every row is greater than the last element of the previous row.
 *
 * Because of this property, the entire matrix behaves like a single sorted 1D array.
 *
 * Instead of searching row by row, we can apply Binary Search
 * on the virtual range from 0 to (rows * columns - 1).
 *
 * To access elements correctly, we convert the 1D index into 2D coordinates:
 *     row = index / number_of_columns
 *     col = index % number_of_columns
 *
 * Then we perform a standard binary search comparison:
 * - If value == target → return true
 * - If value < target  → search the right half
 * - If value > target  → search the left half
 *
 * Time Complexity: O(log(rows * columns))
 * Space Complexity: O(1)
 */

class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        int low = 0;
        int high = rows * cols - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            // Convert 1D index into 2D position
            int row = mid / cols;
            int col = mid % cols;

            int value = matrix[row][col];

            if (value == target) {
                return true;
            } else if (value < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return false;
    }
}
