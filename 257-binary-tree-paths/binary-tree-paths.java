/**
 * Problem: 257. Binary Tree Paths
 *
 * Given the root of a binary tree,
 * return all root-to-leaf paths in any order.
 *
 * Approach:
 * We use Recursion (DFS).
 *
 * At each node:
 * 1. Add current node value to path.
 * 2. If current node is a leaf, add path to answer.
 * 3. Otherwise, go to left and right subtree.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(h)
 */
 
class Solution {

    public void solve(TreeNode root, String path, List<String> ans){

         if(root == null){
            return;
        }
        path = path + root.val;

        if(root.left == null && root.right == null){
            ans.add(path);
            return;
        }

        path = path + "->";

        solve(root.left, path, ans);
        solve(root.right, path, ans);
    }
    public List<String> binaryTreePaths(TreeNode root) {
        
       List<String> ans = new ArrayList<>();

       solve(root, "", ans);

       return ans;

    }
}