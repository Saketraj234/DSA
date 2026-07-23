/**
 * Problem: 173. Binary Search Tree Iterator
 *
 * Implement the BSTIterator class that represents an iterator
 * over the inorder traversal of a Binary Search Tree (BST).
 *
 * Functions:
 * 1. BSTIterator(TreeNode root)
 *    - Initializes the iterator.
 *
 * 2. next()
 *    - Returns the next smallest number.
 *
 * 3. hasNext()
 *    - Returns true if there is a next smallest number.
 *
 * Approach:
 * We use a Stack to simulate Inorder Traversal.
 *
 * 1. In the constructor, push all the left nodes
 *    from the root into the stack.
 *
 * 2. next():
 *    - Pop the top node.
 *    - If the popped node has a right child,
 *      push all the left nodes of that right subtree.
 *    - Return the popped node's value.
 *
 * 3. hasNext():
 *    - If the stack is not empty,
 *      there is still a next node.
 *
 * Time Complexity:
 * Constructor : O(H)
 * next()      : Average O(1)
 * hasNext()   : O(1)
 *
 * Space Complexity:
 * O(H)
 * H = Height of the BST
 */

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

class BSTIterator {

    private Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        pushLeft(root);
    }

    public int next() {

        TreeNode node = stack.pop();

        if (node.right != null) {
            pushLeft(node.right);
        }

        return node.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    private void pushLeft(TreeNode node) {

        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }
}