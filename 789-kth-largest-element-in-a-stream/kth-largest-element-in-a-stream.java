/**
 * Problem: 703. Kth Largest Element in a Stream
 *
 * Design a class that maintains the k-th largest element
 * in a stream of numbers.
 *
 * Approach:
 * We use a Min Heap (PriorityQueue).
 *
 * Idea:
 * - Keep only the largest k elements in the heap.
 * - If heap size becomes greater than k,
 *   remove the smallest element.
 * - The top of the Min Heap is always the k-th largest element.
 *
 * Constructor:
 * - Add all numbers into heap.
 * - If size > k, remove the smallest.
 *
 * add(val):
 * - Insert val into heap.
 * - If size > k, remove the smallest.
 * - Return heap.peek().
 *
 * Example:
 * k = 3
 * nums = [4,5,8,2]
 *
 * Heap after constructor = [4,5,8]
 *
 * add(3)
 * Heap = [3,4,5,8]
 * Remove 3
 * Heap = [4,5,8]
 * Return 4
 *
 * Time Complexity:
 * Constructor : O(n log k)
 * add()        : O(log k)
 *
 * Space Complexity:
 * O(k)
 */

class KthLargest {

  int k;
  PriorityQueue<Integer> pq;

  public KthLargest(int k, int[] nums){

    this.k = k;
    pq = new PriorityQueue<>();

    // Add all elems into Min Heap
    for(int num : nums){

        pq.offer(num);

        // Keep only k largest elems
        if(pq.size() > k) {
            pq.poll();
        }
    }
  }

  public int add(int val) {

    //Insert new value
    pq.offer(val);

    //remove smallest if size exceeds k
    if(pq.size() > k){
        pq.poll();
    }
    
    // top elem is the k-th largest
    return pq.peek();
    }
}


/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */