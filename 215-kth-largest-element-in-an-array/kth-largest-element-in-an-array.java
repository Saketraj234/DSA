/**
 * Problem: 215. Kth Largest Element in an Array
 *
 * Given an integer array nums and an integer k,
 * return the kth largest element in the array.
 *
 * Approach:
 * We use a Min Heap.
 *
 * Keep only k largest elements inside the heap.
 *
 * If heap size becomes greater than k,
 * remove the smallest element using poll().
 *
 * At the end, the top element of the Min Heap
 * will be the kth largest element.
 *
 * Time Complexity: O(n log k)
 * Space Complexity: O(k)
 */

class Solution {
    public int findKthLargest(int[] nums, int k) {
       PriorityQueue<Integer> pq = new PriorityQueue<>();

       for(int num : nums){
        pq.offer(num);

        if(pq.size() > k){
            pq.poll();
        }
       }
       return pq.peek();
    }
}