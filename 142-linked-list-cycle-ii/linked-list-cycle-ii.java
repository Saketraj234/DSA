/**
 * Problem: 142. Linked List Cycle II
 *
 * Given the head of a linked list, return the node where the cycle begins.
 * If there is no cycle, return null.
 *
 * Approach:
 * We use Floyd’s Cycle Detection Algorithm (Tortoise & Hare).
 *
 * Step 1: Detect cycle
 * - Use two pointers:
 *   slow → moves 1 step
 *   fast → moves 2 steps
 * - If they meet → cycle exists
 *
 * Step 2: Find starting node of cycle
 * - Move slow back to head
 * - Keep fast at meeting point
 * - Move both one step at a time
 * - Where they meet → cycle start
 *
 * Why this works:
 * - Distance math ensures both pointers meet at cycle start
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {

    public ListNode detectCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        // Step 1: Detect cycle
        while (fast != null && fast.next != null) {

            slow = slow.next;          // move 1 step
            fast = fast.next.next;     // move 2 steps

            if (slow == fast) {        // cycle detected

                // Step 2: Find cycle start
                slow = head;

                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }

                return slow; // starting node of cycle
            }
        }

        return null; // no cycle
    }
}