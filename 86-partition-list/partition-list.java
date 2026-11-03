/**
 * Problem: 86. Partition List
 *
 * Given the head of a linked list and a value x,
 * partition it so that all nodes less than x come
 * before nodes greater than or equal to x.
 *
 * The relative order of nodes in each partition
 * should be preserved.
 *
 * Approach:
 * We use Two Dummy Nodes.
 *
 * smallDummy stores nodes having value < x.
 * largeDummy stores nodes having value >= x.
 *
 * Traverse the linked list:
 * If current node < x, add it to small list.
 * Otherwise, add it to large list.
 *
 * Finally, connect both lists.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {

    public ListNode partition(ListNode head, int x) {

        ListNode smallDummy = new ListNode(0);
        ListNode largeDummy = new ListNode(0);

        ListNode small = smallDummy;
        ListNode large = largeDummy;

        while (head != null) {

            if (head.val < x) {
                small.next = head;
                small = small.next;
            } 
            else {
                large.next = head;
                large = large.next;
            }

            head = head.next;
        }

        large.next = null;
        small.next = largeDummy.next;

        return smallDummy.next;
    }
}