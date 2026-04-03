/**
 * Problem: 141. Linked List Cycle
 *
 * Given the head of a linked list,
 * determine if the linked list has a cycle in it.
 *
 * A cycle exists if some node in the list
 * points back to a previous node.
 *
 * Example 1:
 * Input: 1 → 2 → 3 → 4 → 5
 *                ↑     ↓
 *                ← ← ← ←
 * Output: true
 *
 * Example 2:
 * Input: 1 → 2 → 3 → 4 → 5 → null
 * Output: false
 *
 * Approach:
 * We use Floyd’s Cycle Detection Algorithm (Tortoise & Hare).
 *
 * - slow pointer moves 1 step
 * - fast pointer moves 2 steps
 *
 * If there is a cycle:
 * → slow and fast will meet
 *
 * If no cycle:
 * → fast will reach null
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
 
 class Solution {

    public boolean hasCycle(ListNode head) {

        // Step 1: Initialize two pointers
        // slow → moves 1 step
        // fast → moves 2 steps
        ListNode low = head;
        ListNode high = head;

        // Step 2: Traverse the list
        // fast and fast.next null nahi hone chahiye
        while (high != null && high.next != null) {

            // slow moves 1 step
            low = low.next;

            // fast moves 2 steps
            high = high.next.next;

            // Step 3: If both meet → cycle exists
            if (low == high) {
                return true;
            }
        }

        // Step 4: If fast reaches null → no cycle
        return false;
    }
}