/**
 * Problem: 230. Kth Smallest Element in a BST
 *
 * Given the root of a Binary Search Tree (BST),
 * return the kth smallest value (1-indexed) of all the values.
 *
 * Approach:
 * We use Inorder Traversal.
 *
 * Why Inorder?
 * In a BST,
 * Left -> Root -> Right
 * visits nodes in Sorted (Increasing) Order.
 *
 * We maintain a count variable.
 *
 * 1. Traverse Left Subtree.
 * 2. Visit Current Node.
 *    count++
 * 3. If count == k,
 *    current node is the answer.
 * 4. Traverse Right Subtree.
 *
 * Time Complexity: O(H + K) Average
 * Worst Case: O(N)
 *
 * Space Complexity: O(H)
 * (Recursion Stack)
 */

class Solution {

    int count = 0;
    int ans = -1;

    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return ans;
    }

    private void inorder(TreeNode root, int k){

        // Stop if node is null or answer is already found
        if(root == null || count >= k)
        return;

        // Left
        inorder(root.left, k);

        // Current Node
        count++;

        if(count == k){
            ans = root.val;
            return;
        }
         // Right
        inorder(root.right, k);
    }
}