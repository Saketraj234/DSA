/**
 * Problem: 104. Maximum Depth of Binary Tree
 *
 * Given the root of a binary tree,
 * return its maximum depth.
 *
 * Maximum Depth:
 * The number of nodes along the longest path
 * from the root node down to the farthest leaf node.
 *
 * Approach:
 * We use Recursion (DFS).
 *
 * Base Case:
 * If the current node is NULL,
 * return 0.
 *
 * Recursive Steps:
 * Find the maximum depth of the left subtree.
 * Find the maximum depth of the right subtree.
 *
 * Current Depth =
 * 1 + max(leftDepth, rightDepth)
 *
 * The +1 represents the current node.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(h)
 * h = Height of the tree
 * (Worst Case: O(n), Balanced Tree: O(log n))
 */

class Solution {

    public int maxDepth(TreeNode root) {

        // Base Case
        if (root == null)
            return 0;

        // Find depth of left subtree
        int leftDepth = maxDepth(root.left);

        // Find depth of right subtree
        int rightDepth = maxDepth(root.right);

        // Return current depth
        return 1 + Math.max(leftDepth, rightDepth);
    }
}