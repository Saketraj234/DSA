/**
 * Problem: 100. Same Tree
 *
 * Given the roots of two binary trees p and q,
 * return true if they are the same,
 * otherwise return false.
 *
 * Two binary trees are considered the same if:
 * 1. They have the same structure.
 * 2. Corresponding nodes have the same value.
 *
 * Approach:
 * We use Recursion (DFS).
 *
 * Base Cases:
 * 1. If both nodes are NULL -> return true.
 * 2. If one node is NULL -> return false.
 * 3. If values are different -> return false.
 *
 * Otherwise:
 * - Compare left subtree.
 * - Compare right subtree.
 * - Return true only if both are same.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(h)
 * where h = height of the tree.
 */

class Solution {

    public boolean isSameTree(TreeNode p, TreeNode q) {

        // Both nodes are NULL
        if (p == null && q == null) {
            return true;
        }

        // One node is NULL
        if (p == null || q == null) {
            return false;
        }

        // Values are different
        if (p.val != q.val) {
            return false;
        }

        // Compare left subtree
        boolean leftSame = isSameTree(p.left, q.left);

        // Compare right subtree
        boolean rightSame = isSameTree(p.right, q.right);

        // Return true only if both subtrees are same
        return leftSame && rightSame;
    }
}