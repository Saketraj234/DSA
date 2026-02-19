/**
 * 83. Remove Duplicates from Sorted List
 * Approach: Since the list is sorted, duplicates are adjacent.
 * We traverse once and skip nodes having the same value.
 * Time: O(n) | Space: O(1)
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // If list is empty or has one node, return as it is
        if (head == null || head.next == null) return head;

        ListNode curr = head; // pointer to traverse the list

        // Traverse the linked list
        while (curr != null && curr.next != null) {
            if (curr.val == curr.next.val) {
                // Duplicate found -> skip next node
                curr.next = curr.next.next;
            } else {
                // No duplicate -> move forward
                curr = curr.next;
            }
        }

        // Return updated list without duplicates
        return head;
    }
}
