/**
 * Problem: 103. Binary Tree Zigzag Level Order Traversal
 *
 * Given the root of a binary tree,
 * return the zigzag level order traversal of its nodes' values.
 * (Left to Right, then Right to Left, alternating for each level.)
 *
 * Approach:
 * We use Breadth First Search (BFS) with a Queue.
 *
 * 1. Insert the root into the queue.
 * 2. Process one level at a time.
 * 3. If direction is Left -> Right,
 *    add node values normally.
 * 4. If direction is Right -> Left,
 *    insert node values at index 0.
 * 5. After every level,
 *    reverse the direction using:
 *    leftToRight = !leftToRight;
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

class Solution {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();

        // If tree is empty
        if (root == null)
            return ans;

        // Queue for BFS
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        // Initial direction: Left -> Right
        boolean leftToRight = true;

        while (!q.isEmpty()) {

            // Number of nodes in current level
            int size = q.size();

            // Store current level
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {

                TreeNode node = q.poll();

                // Left -> Right
                if (leftToRight)
                    level.add(node.val);

                // Right -> Left
                else
                    level.add(0, node.val);

                // Add left child
                if (node.left != null)
                    q.offer(node.left);

                // Add right child
                if (node.right != null)
                    q.offer(node.right);
            }

            // Store current level
            ans.add(level);

            // Change direction
            leftToRight = !leftToRight;
        }

        return ans;
    }
}