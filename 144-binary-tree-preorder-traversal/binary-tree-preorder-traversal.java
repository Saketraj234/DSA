/**
 * Problem: 144. Binary Tree Preorder Traversal
 *
 * Given the root of a binary tree,
 * return the preorder traversal of its nodes' values.
 *
 * Approach:
 * We use Recursion.
 *
 * Preorder Order:
 * Root -> Left -> Right
 *
 * Explanation:
 * We create an empty list 'ans' to store the traversal.
 *
 * The function preorderTraversal(root) is called by LeetCode.
 * It calls the recursive helper function preorder(root).
 *
 * In preorder(root):
 *
 * 1. If the current node is null, return.
 *    (Base Case)
 *
 * 2. Add the current node's value to the answer list.
 *    (Visit the Root)
 *
 * 3. Recursively traverse the left subtree.
 *
 * 4. Recursively traverse the right subtree.
 *
 * Since every node is visited exactly once,
 * the traversal order becomes:
 *
 * Root -> Left -> Right
 *
 * Example:
 *
 *         1
 *        / \
 *       2   3
 *      / \
 *     4   5
 *
 * Recursive Calls:
 *
 * preorder(1)
 * ├── add(1)
 * ├── preorder(2)
 * │      ├── add(2)
 * │      ├── preorder(4)
 * │      │      └── add(4)
 * │      └── preorder(5)
 * │             └── add(5)
 * └── preorder(3)
 *        └── add(3)
 *
 * Output:
 * [1, 2, 4, 5, 3]
 *
 * Time Complexity: O(n)
 * Space Complexity: O(h)
 * where h is the height of the tree.
 * Worst Case: O(n)  (Skewed Tree)
 * Best Case: O(log n) (Balanced Tree)
 */

class Solution {

    List<Integer> ans = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {

        preorder(root);

        return ans;
    }

    public void preorder(TreeNode root) {

        // Base Case
        if (root == null) {
            return;
        }

        // Visit Root
        ans.add(root.val);

        // Traverse Left Subtree
        preorder(root.left);

        // Traverse Right Subtree
        preorder(root.right);
    }
}