/**
 * Problem: 138. Copy List with Random Pointer
 *
 * Given a linked list where each node has two pointers:
 * 1. next pointer
 * 2. random pointer (can point to any node or null)
 *
 * Return a deep copy of the list.
 *
 * Approach (Optimized - O(1) Space):
 *
 * Step 1: Insert copy nodes in between original nodes
 * Example:
 * A -> B -> C
 * becomes:
 * A -> A' -> B -> B' -> C -> C'
 *
 * Step 2: Assign random pointers
 * copy.random = original.random.next
 *
 * Step 3: Separate original and copied list
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public Node copyRandomList(Node head) {

        if (head == null) return null;

        Node temp = head;

        // Step 1: Insert copy nodes in between
        while (temp != null) {
            Node copy = new Node(temp.val);
            copy.next = temp.next;
            temp.next = copy;
            temp = copy.next;
        }

        // Step 2: Assign random pointers
        temp = head;
        while (temp != null) {
            if (temp.random != null) {
                temp.next.random = temp.random.next;
            }
            temp = temp.next.next;
        }

        // Step 3: Separate the lists
        temp = head;
        Node dummy = new Node(-1);
        Node res = dummy;

        while (temp != null) {
            res.next = temp.next;
            res = res.next;

            temp.next = temp.next.next;
            temp = temp.next;
        }

        return dummy.next;
    }
}