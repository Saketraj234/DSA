/**
 * Problem: 206. Reverse Linked List
 *
 * Given the head of a singly linked list,
 * reverse the list and return the new head.
 *
 * Approach:
 * We use Iterative Pointer Reversal.
 *
 * We maintain 3 pointers:
 * temp  -> current node
 * prev  -> previous node (reversed part)
 * front -> next node (to avoid losing list)
 *
 * Steps:
 * 1. Store next node (front = temp.next)
 * 2. Reverse link (temp.next = prev)
 * 3. Move prev forward
 * 4. Move temp forward
 *
 * Repeat until temp becomes null.
 *
 * Final Answer = prev
 *
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */

class Solution {

    public ListNode reverseList(ListNode head) {

        ListNode temp = head;
        ListNode prev = null;

        while (temp != null) {

            // store next node
            ListNode front = temp.next;

            // reverse link
            temp.next = prev;

            // move prev forward
            prev = temp;

            // move temp forward
            temp = front;
        }

        return prev;
    }
}