class Solution {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();

        // If tree is empty
        if (root == null)
            return ans;

        // Queue for BFS
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        // Initial direction: Left -> Right
        boolean leftToRight = true;

        while (!q.isEmpty()) {

            // Number of nodes in current level
            int size = q.size();

            // Store current level
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {

                TreeNode node = q.poll();

                // Left -> Right
                if (leftToRight)
                    level.add(node.val);

                // Right -> Left
                else
                    level.add(0, node.val);

                // Add left child
                if (node.left != null)
                    q.offer(node.left);

                // Add right child
                if (node.right != null)
                    q.offer(node.right);
            }

            // Store current level
            ans.add(level);

            // Change direction
            leftToRight = !leftToRight;
        }

        return ans;
    }
}
