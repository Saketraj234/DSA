/**
 * Problem: 450. Delete Node in a BST
 *
 * Given the root of a Binary Search Tree (BST) and an integer key,
 * delete the node with the given key and return the updated BST.
 *
 * Approach:
 * We use Recursion.
 *
 * 1. Search the node using BST property.
 *      - key < root.val -> Go Left
 *      - key > root.val -> Go Right
 *
 * 2. After finding the node, there are 3 cases:
 *
 *      Case 1:
 *      Node has no child.
 *      Return null.
 *
 *      Case 2:
 *      Node has one child.
 *      Return the existing child.
 *
 *      Case 3:
 *      Node has two children.
 *      Find the Inorder Successor
 *      (Smallest node in Right Subtree).
 *
 *      Copy successor value into current node.
 *
 *      Delete the original successor node
 *      from the right subtree.
 *
 * Time Complexity:
 * O(H)
 * H = Height of BST
 * Worst Case = O(n)
 * Balanced BST = O(log n)
 *
 * Space Complexity:
 * O(H)
 * (Recursion Stack)
 */

class Solution {

    public TreeNode deleteNode(TreeNode root, int key) {

        // Base Case
        if (root == null) {
            return null;
        }

        // Search in Left Subtree
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        }

        // Search in Right Subtree
        else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        }

        // Node Found
        else {

            // Case 1 & Case 2

            // No Left Child
            if (root.left == null) {
                return root.right;
            }

            // No Right Child
            if (root.right == null) {
                return root.left;
            }

            // Case 3:
            // Node has two children

            TreeNode successor = findMin(root.right);

            // Replace current node value
            root.val = successor.val;

            // Delete duplicate successor node
            root.right = deleteNode(root.right, successor.val);
        }

        return root;
    }

    // Find the smallest node in Right Subtree
    private TreeNode findMin(TreeNode node) {

        while (node.left != null) {
            node = node.left;
        }

        return node;
    }
}