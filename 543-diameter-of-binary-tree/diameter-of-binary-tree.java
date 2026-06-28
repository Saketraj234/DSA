class Solution {

    int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {

        height(root);

        return diameter;
    }

    public int height(TreeNode root) {

        // Base Case
        if (root == null)
            return 0;

        // Find Left Height
        int leftHeight = height(root.left);

        // Find Right Height
        int rightHeight = height(root.right);

        // Update Maximum Diameter
        diameter = Math.max(diameter, leftHeight + rightHeight);

        // Return Height
        return 1 + Math.max(leftHeight, rightHeight);
    }
}