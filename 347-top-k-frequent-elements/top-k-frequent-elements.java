/**
 * Problem: 347. Top K Frequent Elements
 *
 * Given an integer array nums and an integer k,
 * return the k most frequent elements.
 *
 * Approach:
 * We use HashMap + Min Heap.
 *
 * Step 1:
 * Count frequency of each number using HashMap.
 *
 * Step 2:
 * Store (frequency, number) in Min Heap.
 *
 * Step 3:
 * If heap size becomes greater than k,
 * remove the element with minimum frequency.
 *
 * Step 4:
 * The heap now contains the k most frequent elements.
 *
 * Step 5:
 * Extract elements from heap and return answer.
 *
 * Time Complexity: O(n log k)
 * Space Complexity: O(n)
 */

class Solution {
    public int[] topKFrequent(int[] nums, int k) {

     // har number ki count kro
     Map<Integer, Integer> freq = new HashMap<>();

     for(int num : nums){
        freq.put(num, freq.getOrDefault(num, 0) + 1);
     }   

     // min heap banyi, freq ke basis pe
     PriorityQueue<int[]> minHeap = new PriorityQueue<>(
        (a, b) -> a[0] - b[0]
     );

     // heap me (freq, number) store kro
     for(Map.Entry<Integer, Integer> entry : freq.entrySet()){
        int num = entry.getKey();
        int count = entry.getValue();

        minHeap.offer(new int [] {count, num});

        // agr heap ka size k se bada ho jye
        // to min freq wale elem ko hata do

        if(minHeap.size() > k){
            minHeap.poll();
        }
     }

     // ans arr
     int[] result = new int[k];

     // heap se numbers nikal ke ans me daal do
     for(int i = k - 1; i >= 0; i--){
        result[i] = minHeap.poll()[1];
     }
     
     return result;
    }
}