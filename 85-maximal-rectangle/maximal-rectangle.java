/**
 * Problem: 85. Maximal Rectangle
 *
 * Given a rows x cols binary matrix filled with 0's and 1's,
 * find the largest rectangle containing only 1's
 * and return its area.
 *
 * Approach:
 * We convert each row into a Histogram.
 *
 * For every row:
 * - If matrix[i][j] == '1'
 *      height[j] += 1
 * - Else
 *      height[j] = 0
 *
 * Then for each histogram,
 * we find Largest Rectangle in Histogram using Stack.
 *
 * We maintain increasing heights in stack.
 *
 * If current height is smaller,
 * we calculate area:
 *
 * width =
 *    if stack empty -> i
 *    else -> i - st.peek() - 1
 *
 * area = height * width
 *
 * Time Complexity: O(n * m)
 * Space Complexity: O(m)
 */
 
class Solution {

    public int maximalRectangle(char[][] matrix) {

        // Number of rows
        int n = matrix.length;

        // Number of columns
        int m = matrix[0].length;

        // Histogram array
        int[] height = new int[m];

        // Store maximum rectangle area
        int maxArea = 0;

        // Traverse every row
        for (int i = 0; i < n; i++) {

            // Build histogram for current row
            for (int j = 0; j < m; j++) {

                // Increase height if value is 1
                if (matrix[i][j] == '1')
                    height[j]++;

                // Reset height if value is 0
                else
                    height[j] = 0;
            }

            // Find largest rectangle in current histogram
            int area = largestRectangleArea(height);

            // Update maximum area
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

    public int largestRectangleArea(int[] heights) {

        // Stack stores indices
        Stack<Integer> st = new Stack<>();

        int maxArea = 0;

        int n = heights.length;

        // Traverse all bars
        for (int i = 0; i <= n; i++) {

            // Process while current bar is smaller
            while (!st.isEmpty() &&
                  (i == n || heights[st.peek()] >= heights[i])) {

                // Height of current rectangle
                int height = heights[st.peek()];

                // Remove top element
                st.pop();

                int width;

                // If stack becomes empty
                // width = current index
                if (st.isEmpty())
                    width = i;

                // Else calculate width
                else
                    width = i - st.peek() - 1;

                // Calculate area
                int area = height * width;

                // Update maximum area
                maxArea = Math.max(maxArea, area);
            }

            // Push current index
            st.push(i);
        }

        return maxArea;
    }
}