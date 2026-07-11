/**
 * Problem: 105. Construct Binary Tree from Preorder and Inorder Traversal
 *
 * Given two integer arrays preorder and inorder where:
 *
 * preorder = Root -> Left -> Right
 * inorder  = Left -> Root -> Right
 *
 * Construct and return the original binary tree.
 *
 * Approach:
 * We use Recursion + HashMap.
 *
 * 1. The first element in preorder is always the Root.
 * 2. Find the Root's index in inorder using HashMap.
 * 3. Elements on the left of Root in inorder belong to the Left Subtree.
 * 4. Elements on the right of Root in inorder belong to the Right Subtree.
 * 5. Recursively build the Left and Right subtrees.
 *
 * preorderIndex keeps track of the current root in preorder.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

class Solution {

    // Current index in preorder array
    private int preorderIndex = 0;

    // Stores inorder value -> index
    private HashMap<Integer, Integer> inorderMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        // Store inorder indices in HashMap
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        // Build the complete tree
        return build(preorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int left, int right) {

        // No nodes left in this subtree
        if (left > right) {
            return null;
        }

        // Current preorder element is the root
        int rootValue = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootValue);

        // Find root position in inorder
        int mid = inorderMap.get(rootValue);

        // Build Left Subtree
        root.left = build(preorder, left, mid - 1);

        // Build Right Subtree
        root.right = build(preorder, mid + 1, right);

        return root;
    }
}