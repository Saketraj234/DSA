/**
 * Problem: 653. Two Sum IV - Input is a BST
 *
 * Given the root of a Binary Search Tree (BST) and an integer k,
 * return true if there exist two elements in the BST such that
 * their sum is equal to k, otherwise return false.
 *
 * Approach:
 * We use DFS + HashSet.
 *
 * 1. Traverse every node of the BST.
 * 2. For each node, calculate:
 *        complement = k - node.val
 * 3. If complement already exists in the HashSet,
 *    then we have found two nodes whose sum is k.
 * 4. Otherwise, store the current node value in the HashSet.
 * 5. Continue searching in the left and right subtree.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
 
class Solution {

    HashSet<Integer> set = new HashSet<>();

    public boolean findTarget(TreeNode root, int k) {
            return dfs(root, k);
        }

        private boolean dfs(TreeNode node, int k) {
            if(node == null) {
                return false;
            }

            int complement = k - node.val;

            if (set.contains(complement)) {
                return true;
            }
            set.add(node.val);
        return dfs(node.left, k) || dfs(node.right, k);
        
    }
}