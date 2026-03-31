/**
 * Problem: Delete Node in a Linked List
 *
 * Given a node in a singly linked list (not the head),
 * delete that node from the list.
 *
 * Approach:
 * Since we don't have access to head or previous node,
 * we copy the next node's data into current node
 * and bypass the next node.
 *
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 */

class Solution {

    public void deleteNode(ListNode node) {

        // step 1: copy next node ka data current node me daalo
        node.val = node.next.val;

        // step 2: next node ko skip karo (delete ho jayega)
        node.next = node.next.next;
    }
}