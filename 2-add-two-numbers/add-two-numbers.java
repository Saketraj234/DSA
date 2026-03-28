/**
 * Problem: 2. Add Two Numbers
 *
 * Approach:
 * - Traverse both linked lists simultaneously.
 * - Add corresponding digits along with carry.
 * - Create a new node for (sum % 10).
 * - Update carry = sum / 10.
 * - Continue until both lists are fully traversed and carry becomes 0.
 *
 * Time Complexity: O(max(n, m))
 *   where n and m are lengths of l1 and l2.
 *
 * Space Complexity: O(max(n, m))
 *   for the output linked list.
 */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        // Dummy node to simplify result list creation
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        int carry = 0;

        // Traverse both lists until both become null
        while (l1 != null || l2 != null || carry != 0) {

            int sum = carry;  // Start with carry

            // Add l1 value if available
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            // Add l2 value if available
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            // Create new node with last digit of sum
            current.next = new ListNode(sum % 10);

            // Update carry
            carry = sum / 10;

            // Move current pointer
            current = current.next;
        }

        // Return result list (skip dummy node)
        return dummy.next;
    }
}