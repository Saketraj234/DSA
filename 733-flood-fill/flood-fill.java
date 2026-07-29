/**
 * Problem: 733. Flood Fill
 *
 * Given an m x n image represented by a 2D array image,
 * where image[i][j] is the color of the pixel.
 *
 * Starting from pixel (sr, sc),
 * replace its color and all connected pixels having the
 * same original color with newColor.
 *
 * Connected means only:
 * Up, Down, Left, Right.
 *
 * --------------------------------------------------------
 * Approach:
 * We use DFS (Depth First Search).
 *
 * Step 1:
 * Store the original color.
 *
 * oldColor = image[sr][sc]
 *
 * Step 2:
 * If oldColor == newColor,
 * return image directly.
 *
 * Step 3:
 * Perform DFS from (sr, sc).
 *
 * For every cell:
 * 1. Check boundaries.
 * 2. Check if current color == oldColor.
 * 3. Change current color to newColor.
 * 4. Visit all four neighbours.
 *
 * --------------------------------------------------------
 * DFS Traversal:
 *
 *           (r,c)
 *        /    |    |    \
 *      Up   Down Left Right
 *
 * --------------------------------------------------------
 * Time Complexity:
 * O(m × n)
 * (Each cell is visited at most once.)
 *
 * Space Complexity:
 * O(m × n)
 * (Recursion stack in worst case.)
 */
class Solution {

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int oldColor = image[sr][sc];

        // Already same color
        if (oldColor == color)
            return image;

        dfs(image, sr, sc, oldColor, color);

        return image;
    }

    private void dfs(int[][] image, int r, int c,
                     int oldColor, int newColor) {

        // Out of boundary
        if (r < 0 || c < 0 ||
            r >= image.length ||
            c >= image[0].length)
            return;

        // Different color
        if (image[r][c] != oldColor)
            return;

        // Fill current cell
        image[r][c] = newColor;

        // Visit 4 directions
        dfs(image, r - 1, c, oldColor, newColor); // Up
        dfs(image, r + 1, c, oldColor, newColor); // Down
        dfs(image, r, c - 1, oldColor, newColor); // Left
        dfs(image, r, c + 1, oldColor, newColor); // Right
    }
}