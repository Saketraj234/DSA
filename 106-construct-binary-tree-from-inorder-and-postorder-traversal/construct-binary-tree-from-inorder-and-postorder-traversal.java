/**
 * Problem: 106. Construct Binary Tree from Inorder and Postorder Traversal
 *
 * Given two integer arrays inorder and postorder,
 * construct and return the binary tree.
 *
 * Approach:
 * We use Recursion + HashMap.
 *
 * 1. In Postorder, the last element is always the Root.
 * 2. Find the Root index in Inorder using HashMap.
 * 3. Left side of Inorder belongs to Left Subtree.
 * 4. Right side of Inorder belongs to Right Subtree.
 * 5. Recursively build Left and Right subtrees.
 *
 * leftSize = rootIndex - inStart
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

class Solution {

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        // Store value -> index of inorder
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return build(
                inorder, 0, inorder.length - 1,
                postorder, 0, postorder.length - 1,
                map
        );
    }

    private TreeNode build(int[] inorder, int inStart, int inEnd,
                           int[] postorder, int postStart, int postEnd,
                           HashMap<Integer, Integer> map) {

        // Base Case
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }

        // Last element of Postorder is the Root
        int rootValue = postorder[postEnd];
        TreeNode root = new TreeNode(rootValue);

        // Find Root index in Inorder
        int rootIndex = map.get(rootValue);

        // Number of nodes in Left Subtree
        int leftSize = rootIndex - inStart;

        // Build Left Subtree
        root.left = build(
                inorder,
                inStart,
                rootIndex - 1,
                postorder,
                postStart,
                postStart + leftSize - 1,
                map
        );

        // Build Right Subtree
        root.right = build(
                inorder,
                rootIndex + 1,
                inEnd,
                postorder,
                postStart + leftSize,
                postEnd - 1,
                map
        );

        return root;
    }
}