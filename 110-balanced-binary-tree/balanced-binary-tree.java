/**
 * Problem: 110. Balanced Binary Tree
 *
 * Given the root of a binary tree,
 * return true if it is height-balanced,
 * otherwise return false.
 *
 * Approach:
 * We use DFS (Recursion).
 *
 * For every node:
 * - Find left subtree height.
 * - Find right subtree height.
 * - If their height difference is greater than 1,
 *   the tree is not balanced.
 *
 * We return:
 * - Height of the subtree if balanced.
 * - -1 if the subtree is not balanced.
 *
 * If any subtree returns -1,
 * we immediately return -1 without further calculation.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(h)
 * (h = Height of Tree)
 */

class Solution {

    public boolean isBalanced(TreeNode root) {

        // If height() returns -1,
        // tree is not balanced.
        return height(root) != -1;
    }

    // Returns height if balanced.
    // Returns -1 if not balanced.
    private int height(TreeNode root) {

        // Base Case
        if (root == null)
            return 0;

        // Height of left subtree
        int leftHeight = height(root.left);

        // Left subtree is not balanced
        if (leftHeight == -1)
            return -1;

        // Height of right subtree
        int rightHeight = height(root.right);

        // Right subtree is not balanced
        if (rightHeight == -1)
            return -1;

        // Check balance condition
        if (Math.abs(leftHeight - rightHeight) > 1)
            return -1;

        // Return current subtree height
        return 1 + Math.max(leftHeight, rightHeight);
    }
}