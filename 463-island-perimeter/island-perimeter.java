/**
 * Problem: 463. Island Perimeter
 *
 * Given a grid where:
 * 0 = water
 * 1 = land
 *
 * return the perimeter of the island.
 *
 * Approach:
 * We use DFS.
 *
 * For every land cell:
 * - If we go outside the grid → +1 perimeter.
 * - If we reach water (0) → +1 perimeter.
 * - If the cell is already visited → +0.
 * - Otherwise, mark it visited and visit all 4 directions.
 *
 * We mark visited cells as -1 directly in the grid,
 * so we don't need an extra visited[][] array.
 *
 * Directions:
 * up    → (i - 1, j)
 * down  → (i + 1, j)
 * left  → (i, j - 1)
 * right → (i, j + 1)
 *
 * Time Complexity: O(m * n)
 * Space Complexity: O(m * n) due to recursion stack
 */

class Solution {
    public int islandPerimeter(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        for(int i = 0; i < grid.length; i++){

        for(int j = 0; j < grid[0].length; j++){

            if(grid[i][j] == 1){
               return dfs(grid, i, j);
            }
        }
    }
    return 0;
}

        public int dfs(int[][] grid, int i, int j){

            if(i < 0 || i >= grid.length ||
            j < 0 || j >= grid[0].length){
                return 1;
            }

            if(grid[i][j] == 0){
                return 1;
            }

            if(grid[i][j] == -1){
            return 0;
            }

            grid[i][j] = -1;

            return dfs(grid, i - 1, j)
            + dfs(grid, i + 1, j)
            + dfs(grid, i, j - 1)
            + dfs(grid, i, j + 1);
        }
    }
