/**
 * Problem: 61. Rotate List
 *
 * Given the head of a linked list, rotate the list to the right by k places.
 *
 * Approach:
 * 1. Find length of linked list and last node (tail).
 * 2. Optimize k using k = k % len.
 * 3. Make the list circular (tail.next = head).
 * 4. Find new last node at position (len - k).
 * 5. Set new head = newLast.next.
 * 6. Break the circle (newLast.next = null).
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {

    public ListNode rotateRight(ListNode head, int k) {

        // Edge case: empty list, single node, or no rotation
        if (head == null || head.next == null || k == 0) return head;

        // Step 1: Find length and tail
        ListNode tail = head;
        int len = 1;

        while (tail.next != null) {
            len++;
            tail = tail.next;
        }

        // Step 2: Optimize k
        k = k % len;

        // If no rotation needed
        if (k == 0) return head;

        // Step 3: Make circular linked list
        tail.next = head;

        // Step 4: Find new last node (len - k)
        int stepsToNewLast = len - k;
        ListNode newLast = head;

        for (int i = 1; i < stepsToNewLast; i++) {
            newLast = newLast.next;
        }

        // Step 5: New head
        ListNode newHead = newLast.next;

        // Step 6: Break the circle
        newLast.next = null;

        return newHead;
    }
}