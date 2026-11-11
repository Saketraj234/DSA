
class Solution {

    List<Integer> ans = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
      preorder(root);
      return ans;
    }

    public void preorder (TreeNode root){
        if(root == null){
            return;
        }
// root value
        ans.add(root.val);
// left subtree
        preorder(root.left);
//right subtree
        preorder(root.right);
    }
}