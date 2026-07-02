/**
 * Problem: 987. Vertical Order Traversal of a Binary Tree
 *
 * Given the root of a binary tree,
 * return its vertical order traversal.
 *
 * Approach:
 * We use BFS (Level Order Traversal).
 *
 * Store each node with:
 * - Column (x)
 * - Row (y)
 *
 * Data Structure:
 * TreeMap<Column, TreeMap<Row, PriorityQueue<NodeValue>>>
 *
 * TreeMap:
 * - Keeps columns sorted from left to right.
 * - Keeps rows sorted from top to bottom.
 *
 * PriorityQueue:
 * - If multiple nodes are at the same row and column,
 *   it stores them in ascending order.
 *
 * Steps:
 * 1. Start BFS from root at (0,0).
 * 2. Store every node in the TreeMap.
 * 3. Left Child  -> (x - 1, y + 1)
 * 4. Right Child -> (x + 1, y + 1)
 * 5. Traverse the TreeMap and add values into the answer.
 *
 * Time Complexity: O(N log N)
 * Space Complexity: O(N)
 */

class Tuple {

    TreeNode node;
    int col;
    int row;

    public Tuple(TreeNode node, int col, int row) {
        this.node = node;
        this.col = col;
        this.row = row;
    }
}

class Solution {

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        // column -> row -> min heap
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();

        // Queue for BFS
        Queue<Tuple> q = new LinkedList<>();

        // Root starts at column = 0, row = 0
        q.offer(new Tuple(root, 0, 0));

        while (!q.isEmpty()) {

            Tuple tuple = q.poll();

            TreeNode node = tuple.node;
            int x = tuple.col;
            int y = tuple.row;

            // Create new column if not present
            if (!map.containsKey(x)) {
                map.put(x, new TreeMap<>());
            }

            // Create new row if not present
            if (!map.get(x).containsKey(y)) {
                map.get(x).put(y, new PriorityQueue<>());
            }

            // Store current node value
            map.get(x).get(y).offer(node.val);

            // Move left -> column - 1, row + 1
            if (node.left != null) {
                q.offer(new Tuple(node.left, x - 1, y + 1));
            }

            // Move right -> column + 1, row + 1
            if (node.right != null) {
                q.offer(new Tuple(node.right, x + 1, y + 1));
            }
        }

        List<List<Integer>> ans = new ArrayList<>();

        // Traverse all columns
        for (TreeMap<Integer, PriorityQueue<Integer>> rows : map.values()) {

            ans.add(new ArrayList<>());

            // Traverse all rows
            for (PriorityQueue<Integer> pq : rows.values()) {

                // Add nodes in sorted order
                while (!pq.isEmpty()) {
                    ans.get(ans.size() - 1).add(pq.poll());
                }
            }
        }

        return ans;
    }
}