/**
 * Problem: 876. Middle of the Linked List
 *
 * Given the head of a singly linked list,
 * return the middle node of the linked list.
 *
 * If there are two middle nodes, return the second middle node.
 *
 * Approach:
 * We use Slow and Fast Pointer.
 *
 * slow moves 1 step at a time.
 * fast moves 2 steps at a time.
 *
 * When fast reaches the end,
 * slow will be at the middle.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {

    public ListNode middleNode(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        // Traverse the list
        while (fast != null && fast.next != null) {

            // Move slow by 1 step
            slow = slow.next;

            // Move fast by 2 steps
            fast = fast.next.next;
        }

        // slow will be at middle
        return slow;
    }
}