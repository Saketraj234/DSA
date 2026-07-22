/**
 * Problem: 1008. Construct Binary Search Tree from Preorder Traversal
 *
 * Given an integer array preorder representing the preorder traversal
 * of a Binary Search Tree (BST), construct and return the BST.
 *
 * Approach:
 * We use Recursion + BST Range.
 *
 * 1. In Preorder, the first element is always the Root.
 * 2. Keep a global index to track the current node.
 * 3. Every recursive call has a valid range (min, max).
 * 4. If the current value is outside the range,
 *    it does not belong to this subtree, so return null.
 * 5. Otherwise, create the node, move index forward,
 *    build the Left Subtree first, then the Right Subtree.
 *
 * Time Complexity: O(n)
 * Each element is processed exactly once.
 *
 * Space Complexity: O(H)
 * H = Height of the BST (Recursion Stack)
 */

class Solution {

    int index = 0;

    public TreeNode bstFromPreorder(int[] preorder) {
        return build(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode build(int[] preorder, int min, int max) {

        // Base Case: All elements are processed
        if (index == preorder.length) {
            return null;
        }

        int value = preorder[index];

        // Current value does not belong to this subtree
        if (value < min || value > max) {
            return null;
        }

        // Create Root Node
        TreeNode root = new TreeNode(value);
        index++;

        // Build Left Subtree
        root.left = build(preorder, min, value);

        // Build Right Subtree
        root.right = build(preorder, value, max);

        return root;
    }
}