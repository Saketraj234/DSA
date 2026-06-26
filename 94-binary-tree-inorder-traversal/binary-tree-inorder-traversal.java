/**
 * Problem: 94. Binary Tree Inorder Traversal
 *
 * Given the root of a binary tree,
 * return the inorder traversal of its nodes' values.
 *
 * Approach:
 * We use Recursion.
 *
 * Inorder Traversal Order Rule:
 * Left -> Root -> Right
 *
 * Algorithm:
 * 1. If the current node is null, return.
 * 2. Recursively traverse the left subtree.
 * 3. Visit the current node and add its value to the answer list.
 * 4. Recursively traverse the right subtree.
 *
 * Example:
 *
 *         1
 *        / \
 *       2   3
 *      / \
 *     4   5
 *
 * Inorder Traversal:
 * 4 -> 2 -> 5 -> 1 -> 3
 *
 * Output:
 * [4, 2, 5, 1, 3]
 *
 * Time Complexity: O(n)
 * Space Complexity: O(h)
 * where h is the height of the tree.
 * Worst Case: O(n) (Skewed Tree)
 * Best Case: O(log n) (Balanced Tree)
 */

class Solution {

    List<Integer> ans = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {

        inorder(root);

        return ans;
    }

    public void inorder(TreeNode root) {

        // Base Case
        if (root == null) {
            return;
        }

        // Traverse Left Subtree
        inorder(root.left);

        // Visit Root
        ans.add(root.val);

        // Traverse Right Subtree
        inorder(root.right);
    }
}