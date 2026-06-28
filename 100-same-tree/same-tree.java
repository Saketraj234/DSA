class Solution {

    public boolean isSameTree(TreeNode p, TreeNode q) {

        // Both nodes are NULL
        if (p == null && q == null) {
            return true;
        }

        // One node is NULL
        if (p == null || q == null) {
            return false;
        }

        // Values are different
        if (p.val != q.val) {
            return false;
        }

        // Compare left subtree
        boolean leftSame = isSameTree(p.left, q.left);

        // Compare right subtree
        boolean rightSame = isSameTree(p.right, q.right);

        // Return true only if both subtrees are same
        return leftSame && rightSame;
    }
}