/**
 * Problem: 1373. Maximum Sum BST in Binary Tree
 *
 * Given the root of a Binary Tree,
 * return the maximum sum of all keys of any subtree
 * which is also a Binary Search Tree (BST).
 *
 * -------------------------------------------------------
 * Approach:
 *
 * We use Postorder Traversal (Left -> Right -> Root).
 *
 * Every subtree returns four pieces of information:
 *
 * 1. isBST  -> Whether the subtree is a valid BST.
 * 2. min    -> Minimum value in the subtree.
 * 3. max    -> Maximum value in the subtree.
 * 4. sum    -> Sum of all nodes in the subtree.
 *
 * -------------------------------------------------------
 * BST Condition:
 *
 * left.isBST
 * &&
 * right.isBST
 * &&
 * left.max < root.val
 * &&
 * root.val < right.min
 *
 * If this condition is true:
 *
 * currentSum = left.sum + right.sum + root.val
 *
 * Update:
 *
 * answer = max(answer, currentSum)
 *
 * Return:
 *
 * isBST = true
 * min = min(left.min, root.val)
 * max = max(right.max, root.val)
 * sum = currentSum
 *
 * -------------------------------------------------------
 * If NOT BST:
 *
 * return isBST = false
 *
 * Parent will automatically ignore this subtree.
 *
 * -------------------------------------------------------
 * Base Case:
 *
 * NULL node returns
 *
 * isBST = true
 * min = +∞
 * max = -∞
 * sum = 0
 *
 * This helps leaf nodes satisfy the BST condition naturally.
 *
 * -------------------------------------------------------
 * Time Complexity:
 * O(N)
 *
 * Space Complexity:
 * O(H)
 * (H = Height of Tree)
 */
 
class Solution {

    int ans = 0;

    class NodeInfo {
        boolean isBST;
        int min, max, sum;

        NodeInfo(boolean isBST, int min, int max, int sum){
            this.isBST = isBST;
            this.min = min;
            this.max = max;
            this.sum = sum;
        }
    }
    public int maxSumBST(TreeNode root) {
        dfs(root);
        return ans;

    }
    private NodeInfo dfs(TreeNode root){

        if(root == null){
            return new NodeInfo(true, Integer.MAX_VALUE, 
            Integer.MIN_VALUE, 0);
        }

        NodeInfo left = dfs(root.left);
        NodeInfo right = dfs(root.right);

        if(left.isBST && right.isBST && left.max < root.val && root.val < right.min){
            int sum = left.sum + right.sum + root.val;

            ans = Math.max(ans, sum);

            int mn = Math.min(left.min, root.val);
            int mx = Math.max(right.max, root.val);

            return new NodeInfo(true, mn, mx, sum);
        }

        return new NodeInfo(false, 0, 0, 0);
    }
}