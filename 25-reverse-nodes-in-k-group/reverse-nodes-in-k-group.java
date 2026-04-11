/**
 * Problem: 25. Reverse Nodes in k-Group
 *
 * Given the head of a linked list, reverse the nodes of the list k at a time,
 * and return the modified list.
 *
 * k is a positive integer and <= length of list.
 * If remaining nodes < k, leave them as it is.
 *
 * You may not change values, only nodes.
 *
 * Approach:
 * We use Iterative In-Place Reversal.
 *
 * 1. Use a dummy node to handle edge cases.
 * 2. For each group:
 *    - Find kth node
 *    - Reverse k nodes
 *    - Connect with previous part
 *
 * 3. Stop when less than k nodes remain.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {

    public ListNode reverseKGroup(ListNode head, int k) {

        // Edge case
        if (head == null || k == 1) return head;

        // Dummy node
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prevGroup = dummy;

        while (true) {

            // Find kth node
            ListNode kth = getKthNode(prevGroup, k);
            if (kth == null) break;

            ListNode nextGroup = kth.next;

            // Reverse current group
            ListNode prev = nextGroup;
            ListNode curr = prevGroup.next;

            while (curr != nextGroup) {
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }

            // Connect with previous part
            ListNode temp = prevGroup.next;
            prevGroup.next = kth;
            prevGroup = temp;
        }

        return dummy.next;
    }

    // Helper function to find kth node
    private ListNode getKthNode(ListNode curr, int k) {

        while (curr != null && k > 0) {
            curr = curr.next;
            k--;
        }

        return curr;
    }
}