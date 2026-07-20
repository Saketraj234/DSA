/**
 * Problem: 98. Validate Binary Search Tree
 *
 * Given the root of a binary tree,
 * determine if it is a valid Binary Search Tree (BST).
 *
 * Approach:
 * We use Recursion + Range (Min, Max).
 *
 * Rule:
 * Every node must satisfy:
 *
 *      min < node.val < max
 *
 * Initially:
 *
 *      Range = (-∞, +∞)
 *
 * When moving LEFT:
 *
 *      Max becomes current node value.
 *
 *      check(left, min, node.val)
 *
 * When moving RIGHT:
 *
 *      Min becomes current node value.
 *
 *      check(right, node.val, max)
 *
 * If any node goes outside its allowed range,
 * the tree is NOT a BST.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(h)
 * where h = height of tree.
 */
 
class Solution {
    public boolean isValidBST(TreeNode root) {
        return check(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean check(TreeNode node, long min, long max){
        if(node == null){
            return true;
        }

        if(node.val <= min || node.val >= max){
            return false;
        }

        boolean left = check(node.left, min, node.val);

        boolean right = check(node.right, node.val, max);

        return left && right;
    }
}