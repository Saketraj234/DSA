/**
 * Problem: 295. Find Median from Data Stream
 *
 * Design a data structure that supports:
 * 1. addNum(int num)   -> Add a number from the data stream.
 * 2. findMedian()      -> Return the median of all elements so far.
 *
 * Approach:
 * We use Two Heaps.
 *
 * small (Max Heap) -> Stores the smaller half of numbers.
 * large (Min Heap) -> Stores the larger half of numbers.
 *
 * Example 1:
 *
 * addNum(1)
 * addNum(2)
 *
 * Numbers = [1,2]
 *
 * small = [1]
 * large = [2]
 *
 * Median = (1 + 2) / 2 = 1.5
 *
 *
 * Example 2:
 *
 * addNum(1)
 * addNum(2)
 * addNum(3)
 *
 * Numbers = [1,2,3]
 *
 * small = [2,1]
 * large = [3]
 *
 * Median = 2
 *
 *
 * Steps for addNum():
 *
 * 1. Add num into small.
 * 2. Move the largest element from small to large.
 * 3. If large becomes bigger than small,
 *    move the smallest element from large back to small.
 *
 * Median:
 *
 * If total elements are odd,
 * median = small.peek()
 *
 * If total elements are even,
 * median = (small.peek() + large.peek()) / 2.0
 *
 * Time Complexity:
 * addNum()     : O(log n)
 * findMedian() : O(1)
 *
 * Space Complexity:
 * O(n)
 */

class MedianFinder {

    PriorityQueue<Integer> small;
    PriorityQueue<Integer> large;

    public MedianFinder() {

       // Max Heap for smaller half
       small = new PriorityQueue<>((a,b)->b-a); // maxHeap

       // Min Heap for larger half
       large = new PriorityQueue<>(); // minHeap    
    }
    
    public void addNum(int num) {
        
        // Step 1: Add number into max heap
        small.offer(num);

        // Step 2: Move the largest element to min heap
        large.offer(small.poll());

        // Step 3: Balance both heaps
        if(large.size() > small.size()){
            small.offer(large.poll());
        }
    }
    
    public double findMedian() {
        
        // Odd number of elements
        if(small.size() > large.size()) {
            return small.peek();
        }

        // Even number of elements
        return (small.peek() + large.peek()) / 2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */