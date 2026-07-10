/**
 * Problem: 222. Count Complete Tree Nodes
 *
 * Given the root of a complete binary tree,
 * return the number of the nodes in the tree.
 *
 * Approach:
 * We compare the leftmost height and rightmost height.
 *
 * If both heights are equal:
 * -> The tree is a Perfect Binary Tree.
 * -> Number of Nodes = 2^(height + 1) - 1
 *
 * Otherwise:
 * -> Recursively count nodes in left subtree,
 *    right subtree and add the current root.
 *
 * Time Complexity: O((log n)^2)
 * Space Complexity: O(log n)
 */

class Solution {

    public int countNodes(TreeNode root) {

        // Base Case
        if (root == null)
            return 0;

        // Find leftmost height
        int left = getLeftHeight(root);

        // Find rightmost height
        int right = getRightHeight(root);

        // Perfect Binary Tree
        if (left == right)
            return (2 << left) - 1;

        // Otherwise recursively count nodes
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    // Returns leftmost height
    private int getLeftHeight(TreeNode root) {

        int height = 0;

        while (root.left != null) {
            height++;
            root = root.left;
        }

        return height;
    }

    // Returns rightmost height
    private int getRightHeight(TreeNode root) {

        int height = 0;

        while (root.right != null) {
            height++;
            root = root.right;
        }

        return height;
    }
}