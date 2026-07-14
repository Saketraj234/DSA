/**
 * Problem: 114. Flatten Binary Tree to Linked List
 *
 * Given the root of a binary tree,
 * flatten the tree into a linked list in-place.
 *
 * The linked list should follow the Preorder Traversal
 * (Root -> Left -> Right).
 *
 * Approach:
 * We use Morris Traversal.
 *
 * For every current node:
 *
 * 1. If there is no left child,
 *    simply move to the right child.
 *
 * 2. Otherwise, find the rightmost node
 *    of the left subtree.
 *
 * 3. Connect the original right subtree
 *    to the rightmost node.
 *
 *      prev.right = curr.right;
 *
 * 4. Move the entire left subtree
 *    to the right side.
 *
 *      curr.right = curr.left;
 *
 * 5. Remove the left child.
 *
 *      curr.left = null;
 *
 * 6. Move to the next node.
 *
 *      curr = curr.right;
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public void flatten(TreeNode root) {

        // Start from the root
        TreeNode curr = root;

       // Traverse the tree
        while(curr != null){

        // If left subtree exists
            if(curr.left != null){

            // Find the rightmost node of left subtree
                TreeNode prev = curr.left;

                while (prev.right != null){
                    prev = prev.right;
                }

             // Connect original right subtree
                // after the rightmost node
                prev.right = curr.right;

            // Move left subtree
                // to the right side
                curr.right = curr.left;

            // Remove left child
                curr.left = null;
            }
            curr = curr.right;
        }
    }
}