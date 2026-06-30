/**
 * Problem: 124. Binary Tree Maximum Path Sum
 *
 * Given the root of a binary tree,
 * return the maximum path sum.
 *
 * A path can start and end at any node,
 * but each node can appear only once.
 *
 * Approach:
 * We use Postorder Traversal (Left → Right → Root).
 *
 * For every node:
 * 1. Find the maximum contribution from left subtree.
 * 2. Find the maximum contribution from right subtree.
 * 3. Ignore negative paths using Math.max(0, ...).
 * 4. Calculate the path passing through the current node.
 * 5. Update the global maximum answer.
 * 6. Return only one side (left or right) to the parent,
 *    because a path cannot split into two directions.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(h)
 */

class Solution {

    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {

        maxPath(root);

        return maxSum;
    }

    public int maxPath(TreeNode root) {

        // Base Case
        if (root == null)
            return 0;

        // Maximum contribution from left subtree
        int left = Math.max(0, maxPath(root.left));

        // Maximum contribution from right subtree
        int right = Math.max(0, maxPath(root.right));

        // Path passing through current node
        int currentPath = left + right + root.val;

        // Update global maximum path sum
        maxSum = Math.max(maxSum, currentPath);

        // Return only one side to the parent
        return Math.max(left, right) + root.val;
    }
}