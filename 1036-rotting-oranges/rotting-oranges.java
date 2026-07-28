/**
 * Problem: 994. Rotten Oranges
 *
 * Given an m x n grid where:
 * 0 = Empty Cell
 * 1 = Fresh Orange
 * 2 = Rotten Orange
 *
 * Every minute, a rotten orange infects its
 * adjacent fresh oranges (Up, Down, Left, Right).
 *
 * Return the minimum time required to rot all oranges.
 * If impossible, return -1.
 *
 * Approach:
 * We use Multi-Source BFS.
 *
 * Step 1:
 * Traverse the grid.
 * - Count fresh oranges.
 * - Push all rotten oranges into the queue.
 *
 * Step 2:
 * Perform BFS level by level.
 * Each BFS level represents 1 minute.
 *
 * Step 3:
 * For every rotten orange,
 * check its 4 neighbours.
 * If neighbour is fresh:
 * - Make it rotten.
 * - Decrease fresh count.
 * - Push it into queue.
 *
 * Step 4:
 * After BFS,
 * - If fresh == 0 → return minutes.
 * - Else → return -1.
 *
 * Why BFS?
 * Infection spreads simultaneously from
 * all rotten oranges.
 * One BFS level = One Minute.
 *
 * Time Complexity: O(m × n)
 * Space Complexity: O(m × n)
 */

class Solution {
    public int orangesRotting(int[][] grid) {
       int rows = grid.length;
       int cols = grid[0].length;

       Queue<int[]> queue = new  LinkedList<>();

       int fresh = 0;

       for(int i = 0; i < rows; i++){
        for(int j = 0; j < cols; j++){
            if(grid[i][j] == 2){
                queue.offer(new int[]{i, j});
            }

            if(grid[i] [j] == 1){
                fresh++;
            }
        }
       } 

       if(fresh == 0){
        return 0;
       }

       int minutes = 0;

       int [][] directions= {
        {-1, 0},
        {1, 0},
        {0, -1},
        {0, 1}
       };

       while(!queue.isEmpty()) {
        int size = queue.size();

        for(int i = 0; i < size; i++){
            int[] current = queue.poll();

            int row = current[0];
            int col = current[1];

            for(int[] dir : directions){

                int newRow = row + dir[0];
                    int newCol = col + dir[1];

                    if (newRow >= 0 && newRow < rows &&
                        newCol >= 0 && newCol < cols &&
                        grid[newRow][newCol] == 1) {

                        grid[newRow][newCol] = 2;
                        fresh--;

                        queue.offer(new int[]{newRow, newCol});
                    }
                }
            }
            
            if (!queue.isEmpty()) {
                minutes++;
            }
        }

        if (fresh > 0) {
            return -1;
        }

        return minutes;
    }
}