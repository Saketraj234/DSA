/**
 * Problem: 145. Binary Tree Postorder Traversal
 *
 * Given the root of a binary tree,
 * return the postorder traversal of its nodes' values.
 *
 * Approach:
 * We use Recursion.
 *
 * Postorder Traversal Order:
 * Left -> Right -> Root
 *
 * Algorithm:
 * 1. If the current node is null, return.
 * 2. Recursively traverse the left subtree.
 * 3. Recursively traverse the right subtree.
 * 4. Visit the current node and add its value to the answer list.
 *
 * Example:
 *
 *         1
 *        / \
 *       2   3
 *      / \
 *     4   5
 *
 * Postorder Traversal:
 * 4 -> 5 -> 2 -> 3 -> 1
 *
 * Output:
 * [4, 5, 2, 3, 1]
 *
 * Time Complexity: O(n)
 * Space Complexity: O(h)
 * where h is the height of the tree.
 * Worst Case: O(n) (Skewed Tree)
 * Best Case: O(log n) (Balanced Tree)
 */

class Solution {

    List<Integer> ans = new ArrayList<>();

    public List<Integer> postorderTraversal(TreeNode root) {

        postorder(root);

        return ans;
    }

    public void postorder(TreeNode root) {

        // Base Case
        if (root == null) {
            return;
        }

        // Traverse Left Subtree
        postorder(root.left);

        // Traverse Right Subtree
        postorder(root.right);

        // Visit Root
        ans.add(root.val);
    }
}