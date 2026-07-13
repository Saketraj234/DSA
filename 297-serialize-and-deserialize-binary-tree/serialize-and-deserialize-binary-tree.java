/**
 * Problem: 297. Serialize and Deserialize Binary Tree
 *
 * Given the root of a binary tree,
 * Design an algorithm to serialize and deserialize a binary tree.
 *
 * Approach:
 * We use Level Order Traversal (BFS).
 *
 * Serialization:
 * - Traverse the tree level by level using a Queue.
 * - Store each node value.
 * - Store "n" for every null node.
 *
 * Example:
 *
 *         1
 *       /   \
 *      2     3
 *           / \
 *          4   5
 *
 * Serialized String:
 * 1 2 3 n n 4 5 n n n n
 *
 * Deserialization:
 * - Split the serialized string.
 * - First value becomes the root.
 * - Use a Queue to assign left and right children.
 * - Skip "n" because it represents a null node.
 *
 * Time Complexity:
 * Serialize   : O(n)
 * Deserialize : O(n)
 *
 * Space Complexity:
 * O(n)
 */

class Codec {

    // ---------------- Serialize ----------------

    public String serialize(TreeNode root) {

        if (root == null)
            return "";

        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder ans = new StringBuilder();

        queue.offer(root);

        while (!queue.isEmpty()) {

            TreeNode node = queue.poll();

            // Store null node
            if (node == null) {
                ans.append("n ");
                continue;
            }

            // Store current node value
            ans.append(node.val).append(" ");

            // Add left and right child
            queue.offer(node.left);
            queue.offer(node.right);
        }

        return ans.toString();
    }

    // ---------------- Deserialize ----------------

    public TreeNode deserialize(String data) {

        if (data.equals(""))
            return null;

        String[] values = data.split(" ");

        TreeNode root = new TreeNode(Integer.parseInt(values[0]));

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;

        while (!queue.isEmpty() && i < values.length) {

            TreeNode parent = queue.poll();

            // Create Left Child
            if (!values[i].equals("n")) {

                TreeNode left = new TreeNode(Integer.parseInt(values[i]));

                parent.left = left;

                queue.offer(left);
            }

            i++;

            // Create Right Child
            if (i < values.length && !values[i].equals("n")) {

                TreeNode right = new TreeNode(Integer.parseInt(values[i]));

                parent.right = right;

                queue.offer(right);
            }

            i++;
        }

        return root;
    }
}

/**
 * Dry Run:
 *
 * Tree:
 *
 *         1
 *       /   \
 *      2     3
 *           / \
 *          4   5
 *
 * Serialize Output:
 *
 * 1 2 3 n n 4 5 n n n n
 *
 * Deserialize:
 *
 * Queue:
 * [1]
 *
 * Parent = 1
 * Left  = 2
 * Right = 3
 *
 * Queue:
 * [2,3]
 *
 * Parent = 2
 * Left  = n
 * Right = n
 *
 * Queue:
 * [3]
 *
 * Parent = 3
 * Left  = 4
 * Right = 5
 *
 * Tree Reconstructed Successfully.
 */