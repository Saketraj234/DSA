/**
 * Problem: 84. Largest Rectangle in Histogram
 *
 * Given an array of integers heights representing
 * the histogram bar heights,
 * return the area of the largest rectangle.
 *
 * Approach:
 * We use Monotonic Increasing Stack.
 *
 * Stack stores indices of increasing heights.
 *
 * Whenever current height becomes smaller,
 * we calculate area for previous taller bars.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

class Solution {

    public int largestRectangleArea(int[] heights) {

        int n = heights.length;

        // Stack to store indices
        Stack<Integer> st = new Stack<>();

        int maxArea = 0;

        for (int i = 0; i <= n; i++) {

            // At end take height = 0
            int currHeight = (i == n) ? 0 : heights[i];

            // Process taller bars
            while (!st.isEmpty() && heights[st.peek()] > currHeight) {

                // Height of rectangle
                int height = heights[st.pop()];

                int width;

                // If no smaller element on left
                if (st.isEmpty()) {
                    width = i;
                }

                // Width between smaller elements
                else {
                    width = i - st.peek() - 1;
                }

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