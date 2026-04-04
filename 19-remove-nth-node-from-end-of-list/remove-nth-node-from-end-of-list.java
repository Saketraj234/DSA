/**
 * Problem: 19. Remove Nth Node From End of List
 *
 * Given the head of a linked list, remove the nth node from the end
 * of the list and return its head.
 *
 * Approach:
 * We use Two Pointer (Fast & Slow) approach.
 *
 * Step 1:
 * Move fast pointer n steps ahead.
 *
 * Step 2:
 * If fast becomes null → delete head node.
 *
 * Step 3:
 * Move both fast & slow together until fast reaches last node.
 *
 * Step 4:
 * Slow will be at (previous node of target),
 * so delete slow.next.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode fast = head;
        ListNode slow = head;

        // Move fast n steps ahead
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        // If we need to delete head
        if (fast == null) {
            return head.next;
        }

        // Move both pointers
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // Delete the node
        slow.next = slow.next.next;

        return head;
    }
}