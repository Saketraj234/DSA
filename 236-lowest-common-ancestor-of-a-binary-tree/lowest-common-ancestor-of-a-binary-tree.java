/**
 * Problem: 236. Lowest Common Ancestor of a Binary Tree
 *
 * Given the root of a binary tree and two nodes p and q,
 * return their Lowest Common Ancestor (LCA).
 *
 * Approach:
 * We use Recursion.
 *
 * Base Case:
 * If root is null, p, or q, return root.
 *
 * Recursively search in left and right subtrees.
 *
 * If both left and right return non-null,
 * current node is the Lowest Common Ancestor.
 *
 * Otherwise return the non-null node.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(h)
 * h = Height of the tree
 */

class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // Base Case
        if (root == null || root == p || root == q) {
            return root;
        }

        // Search in Left Subtree
        TreeNode left = lowestCommonAncestor(root.left, p, q);

        // Search in Right Subtree
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // If both sides return a node,
        // current node is the LCA
        if (left != null && right != null) {
            return root;
        }

        // Return the non-null node
        return (left != null) ? left : right;
    }
}