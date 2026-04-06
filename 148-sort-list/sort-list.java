/**
 * Problem: 148. Sort List
 *
 * Given the head of a linked list,
 * return the list after sorting it in ascending order.
 *
 * Approach:
 * We use Merge Sort (best for Linked List).
 *
 * Step 1: Find middle using slow & fast pointer
 * Step 2: Split list into two halves
 * Step 3: Recursively sort both halves
 * Step 4: Merge two sorted lists
 *
 * Time Complexity: O(n log n)
 * Space Complexity: O(1)  (ignoring recursion stack)
 */

class Solution {

    public ListNode sortList(ListNode head) {

        // Base case: 0 or 1 node
        if (head == null || head.next == null) return head;

        // Step 1: Find middle
        ListNode slow = head, fast = head, prev = null;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Break into 2 halves
        prev.next = null;

        // Step 3: Sort both halves
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);

        // Step 4: Merge sorted lists
        return merge(l1, l2);
    }

    private ListNode merge(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (l1 != null && l2 != null) {

            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }

            curr = curr.next;
        }

        // Attach remaining nodes
        if (l1 != null) curr.next = l1;
        else curr.next = l2;

        return dummy.next;
    }
}