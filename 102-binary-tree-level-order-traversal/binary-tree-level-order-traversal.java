/**
 * Problem: 102. Binary Tree Level Order Traversal
 *
 * Given the root of a binary tree,
 * return the level order traversal of its nodes' values.
 *
 * Approach:
 * We use Breadth First Search (BFS) with a Queue.
 *
 * Step 1:
 * Create an empty answer list.
 *
 * Step 2:
 * If the tree is empty (root == null),
 * return the empty answer.
 *
 * Step 3:
 * Create a Queue and insert the root node.
 *
 * Step 4:
 * Repeat until the queue becomes empty.
 *
 *   - Find the current queue size.
 *     This size represents the number of nodes
 *     present in the current level.
 *
 *   - Create a new list to store the current level.
 *
 *   - Process exactly 'size' nodes.
 *
 *       • Remove the front node from the queue.
 *       • Add its value into the current level list.
 *       • If the left child exists,
 *         insert it into the queue.
 *       • If the right child exists,
 *         insert it into the queue.
 *
 *   - After processing all nodes of the current level,
 *     add the level list into the final answer.
 *
 * Step 5:
 * Return the final answer.
 *
 * Time Complexity : O(n)
 * Space Complexity: O(n)
 */

class Solution {

    public List<List<Integer>> levelOrder(TreeNode root) {

        // Stores the final level order traversal
        List<List<Integer>> ans = new ArrayList<>();

        // If tree is empty, return empty answer
        if (root == null) {
            return ans;
        }

        // Queue is used for BFS traversal
        Queue<TreeNode> q = new LinkedList<>();

        // Insert the root node
        q.offer(root);

        // Continue until queue becomes empty
        while (!q.isEmpty()) {

            // Number of nodes in the current level
            int size = q.size();

            // Stores all node values of the current level
            List<Integer> level = new ArrayList<>();

            // Process one complete level
            for (int i = 0; i < size; i++) {

                // Remove the front node
                TreeNode curr = q.poll();

                // Store its value
                level.add(curr.val);

                // Insert left child if present
                if (curr.left != null) {
                    q.offer(curr.left);
                }

                // Insert right child if present
                if (curr.right != null) {
                    q.offer(curr.right);
                }
            }

            // Add the current level into the final answer
            ans.add(level);
        }

        // Return the level order traversal
        return ans;
    }
}