/**
 * Problem: 700. Search in a Binary Search Tree
 *
 * Given the root of a Binary Search Tree (BST) and an integer val,
 * return the node where the node's value equals val.
 * If such a node does not exist, return null.
 *
 * Approach:
 * We use the BST property.
 *
 * BST Rule:
 * - Left subtree contains smaller values.
 * - Right subtree contains larger values.
 *
 * Steps:
 * 1. If root is null, value is not present.
 * 2. If root.val == val, return the current node.
 * 3. If val < root.val, search in the left subtree.
 * 4. Otherwise, search in the right subtree.
 *
 * Time Complexity: O(log n) Average, O(n) Worst Case
 * Space Complexity: O(log n) Average (Recursion Stack), O(n) Worst Case
 */

class Solution {

    public TreeNode searchBST(TreeNode root, int val) {

        // Base Case: Tree is empty
        if (root == null) {
            return null;
        }

        // Value found
        if (root.val == val) {
            return root;
        }

        // Search in Left Subtree
        if (val < root.val) {
            return searchBST(root.left, val);
        }

        // Search in Right Subtree
        return searchBST(root.right, val);
    }
}