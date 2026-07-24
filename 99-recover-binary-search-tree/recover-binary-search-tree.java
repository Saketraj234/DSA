/**
 * Problem: 99. Recover Binary Search Tree
 *
 * Given the root of a Binary Search Tree (BST),
 * exactly two nodes have been swapped by mistake.
 * Recover the tree without changing its structure.
 *
 * Approach:
 * We use Inorder Traversal.
 *
 * Since inorder traversal of a BST is always sorted,
 * any violation (prev.val > current.val) indicates
 * that the swapped nodes have been found.
 *
 * Variables:
 * prev   -> Previous node in inorder traversal.
 * first  -> First incorrect node.
 * second -> Second incorrect node.
 *
 * Rules:
 * 1. If prev.val > current.val:
 *      - If first is null,
 *          first = prev
 *      - Always
 *          second = current
 *
 * 2. After traversal,
 *      swap(first.val, second.val)
 *
 * Time Complexity: O(n)
 * Space Complexity: O(h)
 * (O(1) if Morris Traversal is used)
 */

class Solution {

    TreeNode first = null;
    TreeNode second = null;
    TreeNode prev = null;

    public void recoverTree(TreeNode root) {
      inorder(root);

      int temp = first.val;
      first.val = second.val;
      second.val = temp;    
    }

    private void inorder(TreeNode root){
        if(root == null){
            return;
        }
        inorder(root.left);

        if(prev != null && prev.val > root.val){
            if(first == null){
                first = prev;
            }
            second = root;
        }

        prev = root;

        inorder(root.right);
    }
}