/**
 * Problem: 1539. Kth Missing Positive Number
 *
 * Given a sorted array of positive integers arr,
 * return the kth positive integer that is missing from this array.
 *
 * Approach:
 * We use Binary Search.
 * 
 * missing(i) = arr[i] - (i + 1)
 * This tells how many numbers are missing till index i.
 *
 * We find the first index where missing >= k.
 * Final Answer = low + k
 *
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */

class Solution {

    public int findKthPositive(int[] arr, int k) {

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            // Count how many numbers are missing till mid
            int missing = arr[mid] - (mid + 1);

            if (missing < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        // low is the first index where missing >= k
        return low + k;
    }
}