class Solution {

    public ListNode sortList(ListNode head) {
        // Base case
        if (head == null || head.next == null) return head;

        // Find middle
        ListNode middle = findMiddle(head);
        ListNode right = middle.next;
        middle.next = null;
        ListNode left = head;

        // Recursively sort
        left = sortList(left);
        right = sortList(right);

        // Merge sorted lists
        return mergeTwoLists(left, right);
    }

    // Merge two sorted linked lists
    private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                temp.next = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }

        if (list1 != null) temp.next = list1;
        else temp.next = list2;

        return dummy.next;
    }

    // Find middle of linked list
    private ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next; // important for split

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}