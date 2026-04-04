/**
 * Problem: 234. Palindrome Linked List
 *
 * Given the head of a singly linked list,
 * return true if it is a palindrome, otherwise false.
 *
 * Example:
 * Input: 1 -> 2 -> 2 -> 1
 * Output: true
 *
 * Input: 1 -> 2 -> 3
 * Output: false
 *
 * Approach:
 * 1. Use slow and fast pointers to find middle of list.
 * 2. Reverse the second half of the list.
 * 3. Compare first half and reversed second half.
 * 4. (Optional) Restore the list.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {

    public boolean isPalindrome(ListNode head) {

        // Step 0: Base case
        if (head == null || head.next == null) {
            return true;
        }

        // Step 1: Find middle using slow & fast
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;          // 1 step
            fast = fast.next.next;     // 2 steps
        }

        // Step 2: Reverse second half
        ListNode newHead = reverse(slow);

        // Step 3: Compare both halves
        ListNode first = head;
        ListNode second = newHead;

        while (second != null) {
            if (first.val != second.val) {
                reverse(newHead); // restore list
                return false;
            }
            first = first.next;
            second = second.next;
        }

        // Step 4: Restore (optional)
        reverse(newHead);

        return true;
    }

    // Function to reverse linked list
    public ListNode reverse(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {

            ListNode next = curr.next; // store next

            curr.next = prev;          // reverse link

            prev = curr;               // move prev
            curr = next;               // move curr
        }

        return prev; // new head
    }
}