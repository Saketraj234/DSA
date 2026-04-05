/**
 * Problem: 2095. Delete the Middle Node of a Linked List
 *
 * Given the head of a singly linked list,
 * delete the middle node and return the head.
 *
 * Approach:
 * We use the Tortoise & Hare (Slow & Fast Pointer) method.
 *
 * - slow moves 1 step
 * - fast moves 2 steps
 * - When fast reaches end → slow is at middle
 *
 * We also keep a prev pointer to remove the middle node.
 *
 * Edge Case:
 * - If only one node → return null
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {

    public ListNode deleteMiddle(ListNode head) {

        // Edge case: only one node
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        // Find middle node
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // Delete middle node
        prev.next = slow.next;

        return head;
    }
}