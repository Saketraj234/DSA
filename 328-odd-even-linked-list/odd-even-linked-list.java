/**
 * Problem: 328. Odd Even Linked List
 *
 * Given the head of a singly linked list,
 * group all odd index nodes together followed by even index nodes.
 *
 * Note:
 * - The relative order inside odd and even groups should remain same.
 * - Indexing is 1-based (not 0-based).
 *
 * Example:
 * Input:  1 → 2 → 3 → 4 → 5
 * Output: 1 → 3 → 5 → 2 → 4
 *
 * Approach:
 * - Maintain two pointers:
 *   odd = head
 *   even = head.next
 * - Store evenHead to connect later
 *
 * - Traverse list:
 *   odd.next = odd.next.next
 *   even.next = even.next.next
 *
 * - Move both pointers forward
 *
 * - Finally connect:
 *   odd.next = evenHead
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {

    public ListNode oddEvenList(ListNode head) {

        // Edge case: empty or single node
        if (head == null || head.next == null) {
            return head;
        }

        // Initialize pointers
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = head.next;

        // Traverse and rearrange links
        while (even != null && even.next != null) {

            // Link odd nodes
            odd.next = odd.next.next;

            // Link even nodes
            even.next = even.next.next;

            // Move pointers forward
            odd = odd.next;
            even = even.next;
        }

        // Connect odd list with even list
        odd.next = evenHead;

        return head;
    }
}