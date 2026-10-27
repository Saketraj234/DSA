/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

/**
 * Problem: 654. Maximum Binary Tree
 *
 * Given an integer array nums with distinct values,
 * construct a maximum binary tree.
 *
 * Approach:
 * We use Recursion + Divide and Conquer.
 *
 * 1. Find the maximum element in the current range.
 * 2. Create a TreeNode using the maximum element.
 * 3. Elements on the left form the left subtree.
 * 4. Elements on the right form the right subtree.
 * 5. Repeat the same process recursively.
 *
 * Base Case:
 * If left > right, return null.
 *
 * Time Complexity: O(n^2) worst case
 * Space Complexity: O(n) for recursion and tree
 */

class Solution {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return buildTree(nums, 0, nums.length - 1);
    }

    private TreeNode buildTree(int[] nums, int left, int right) {

        if (left > right) {
            return null;
        }

        int maxIndex = left;

        for (int i = left + 1; i <= right; i++) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }

        TreeNode root = new TreeNode(nums[maxIndex]);

        root.left = buildTree(nums, left, maxIndex - 1);
        root.right = buildTree(nums, maxIndex + 1, right);

        return root;
    }
}
