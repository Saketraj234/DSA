/**
 * Problem: 373. Find K Pairs with Smallest Sums
 *
 * Given two sorted arrays nums1 and nums2,
 * return k pairs with the smallest sums.
 *
 * Approach:
 * We use Min Heap (PriorityQueue).
 *
 * Initially, add pairs:
 * nums1[i] + nums2[0]
 *
 * Heap always gives the pair with
 * the smallest sum.
 *
 * After removing a pair (i, j),
 * add the next pair (i, j + 1).
 *
 * Time Complexity: O(k log(min(n, k)))
 * Space Complexity: O(min(n, k))
 */

class Solution {

    public List<List<Integer>> kSmallestPairs(
            int[] nums1,
            int[] nums2,
            int k
    ) {

        List<List<Integer>> ans = new ArrayList<>();

        // {sum, index in nums1, index in nums2}
        PriorityQueue<int[]> pq =
                new PriorityQueue<>(
                        (a, b) -> Integer.compare(a[0], b[0])
                );

        // Add first pair of each row
        for (int i = 0;
             i < Math.min(nums1.length, k);
             i++) {

            pq.offer(new int[]{
                    nums1[i] + nums2[0],
                    i,
                    0
            });
        }

        // Get k smallest pairs
        while (k > 0 && !pq.isEmpty()) {

            int[] curr = pq.poll();

            int i = curr[1];
            int j = curr[2];

            // Add current pair
            ans.add(Arrays.asList(
                    nums1[i],
                    nums2[j]
            ));

            k--;

            // Add next pair from same row
            if (j + 1 < nums2.length) {

                pq.offer(new int[]{
                        nums1[i] + nums2[j + 1],
                        i,
                        j + 1
                });
            }
        }

        return ans;
    }
}