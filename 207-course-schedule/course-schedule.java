/**
 * Problem: 207. Course Schedule
 *
 * Given numCourses and prerequisites,
 * return true if you can finish all courses,
 * otherwise return false.
 *
 * Approach:
 * We model the courses as a Directed Graph.
 *
 * Edge:
 * prerequisite -> course
 *
 * We use DFS to detect a cycle.
 *
 * State Array:
 * 0 = Not Visited
 * 1 = Visiting (Current DFS Path)
 * 2 = Visited
 *
 * If during DFS we reach a node whose state is already 1,
 * then a cycle exists.
 *
 * If any cycle exists -> return false.
 * Otherwise -> return true.
 *
 * Time Complexity: O(V + E)
 * Space Complexity: O(V + E)
 */

class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        // Create Graph
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // Build Graph
        for (int[] pre : prerequisites) {
            graph.get(pre[1]).add(pre[0]);
        }

        // 0 = Not Visited
        // 1 = Visiting
        // 2 = Visited
        int[] state = new int[numCourses];

        // Run DFS from every course
        for (int i = 0; i < numCourses; i++) {

            if (state[i] == 0) {

                if (dfs(i, graph, state)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean dfs(int node, ArrayList<ArrayList<Integer>> graph, int[] state) {

        // Cycle Found
        if (state[node] == 1) {
            return true;
        }

        // Already Processed
        if (state[node] == 2) {
            return false;
        }

        // Mark as Visiting
        state[node] = 1;

        // Visit all neighbours
        for (int next : graph.get(node)) {

            if (dfs(next, graph, state)) {
                return true;
            }
        }

        // Mark as Visited
        state[node] = 2;

        return false;
    }
}