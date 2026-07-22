/**
 * Problem: 235. Lowest Common Ancestor of a Binary Search Tree
 *
 * Given a Binary Search Tree (BST) and two nodes p and q,
 * return their Lowest Common Ancestor (LCA).
 *
 * Approach:
 * We use the BST property.
 *
 * BST Property:
 * Left Subtree < Root < Right Subtree
 *
 * 1. If both p and q are smaller than root,
 *    then LCA must be in the Left Subtree.
 *
 * 2. If both p and q are greater than root,
 *    then LCA must be in the Right Subtree.
 *
 * 3. Otherwise, current root is the point where
 *    the paths split (or root is p/q itself),
 *    so current root is the Lowest Common Ancestor.
 *
 * Time Complexity: O(H)
 * H = Height of BST
 *      Balanced BST -> O(log n)
 *      Skewed BST   -> O(n)
 *
 * Space Complexity: O(H)
 * (Recursive Call Stack)
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        // Base Case
        if(root == null)
        return null;

        // Both nodes are in the Left Subtree
        if(p.val < root.val && q.val < root.val){
            return lowestCommonAncestor(root.left, p, q);
        } 
        
        // Both nodes are in the Right Subtree
         else if(p.val > root.val && q.val > root.val){
            return lowestCommonAncestor(root.right, p, q);
        }

        // Split point found (or root is p/q)
        return root;
    }
}