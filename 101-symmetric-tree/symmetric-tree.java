/**
 * Problem: 101. Symmetric Tree
 *
 * Given the root of a binary tree,
 * check whether it is symmetric around its center.
 *
 * Approach:
 * We use Recursion.
 *
 * Compare the left and right subtrees as mirror images.
 *
 * Conditions:
 * 1. If both nodes are NULL → return true.
 * 2. If one node is NULL → return false.
 * 3. If values are different → return false.
 * 4. Recursively compare:
 *    - left.left  with right.right
 *    - left.right with right.left
 *
 * Time Complexity: O(n)
 * Space Complexity: O(h)
 * h = Height of the Tree
 */

class Solution {

    public boolean isSymmetric(TreeNode root) {

        if (root == null)
            return true;

        return isMirror(root.left, root.right);
    }

    public boolean isMirror(TreeNode left, TreeNode right) {

        if (left == null && right == null)
            return true;

        if (left == null || right == null)
            return false;

        if (left.val != right.val)
            return false;

        return isMirror(left.left, right.right)
                && isMirror(left.right, right.left);
    }
}