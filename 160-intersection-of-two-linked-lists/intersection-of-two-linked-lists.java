/**
 * Problem: 160. Intersection of Two Linked Lists
 *
 * Given the heads of two singly linked lists headA and headB,
 * return the node at which the two lists intersect.
 * If the two linked lists have no intersection, return null.
 *
 * Approach:
 * We use Two Pointer Technique.
 *
 * Take two pointers p1 and p2.
 * p1 starts from headA and p2 starts from headB.
 *
 * When p1 reaches end, move it to headB.
 * When p2 reaches end, move it to headA.
 *
 * This way both pointers travel equal distance.
 * If intersection exists → they meet at intersection node.
 * If not → both become null.
 *
 * Time Complexity: O(n + m)
 * Space Complexity: O(1)
 */

class Solution {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) return null;

        ListNode p1 = headA;
        ListNode p2 = headB;

        while (p1 != p2) {

            // Move to next or switch list
            p1 = (p1 == null) ? headB : p1.next;
            p2 = (p2 == null) ? headA : p2.next;
        }

        // Either intersection node or null
        return p1;
    }
}