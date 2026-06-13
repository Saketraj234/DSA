/**
 * Problem: 23. Merge k Sorted Lists
 *
 * Given an array of k linked-lists lists,
 * each linked-list is sorted in ascending order.
 *
 * Merge all the linked-lists into one sorted linked-list
 * and return it.
 *
 * Approach:
 * We use a Min Heap (Priority Queue).
 *
 * 1. Insert the first node of every linked list into the heap.
 * 2. Extract the smallest node from the heap.
 * 3. Add it to the answer list.
 * 4. If the extracted node has a next node,
 *    insert that next node into the heap.
 * 5. Repeat until the heap becomes empty.
 *
 * This ensures that at every step we pick
 * the smallest available node among all lists.
 *
 * Time Complexity: O(N log K)
 * N = Total number of nodes
 * K = Number of linked lists
 *
 * Space Complexity: O(K)
 * Heap stores at most K nodes.
 */

class Solution {

    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> pq =
                new PriorityQueue<>((a, b) -> a.val - b.val);

        // Add first node of each list
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                pq.offer(lists[i]);
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        while (!pq.isEmpty()) {

            // Smallest node
            ListNode node = pq.poll();

            temp.next = node;
            temp = temp.next;

            // Push next node of same list
            if (node.next != null) {
                pq.offer(node.next);
            }
        }

        return dummy.next;
    }
}