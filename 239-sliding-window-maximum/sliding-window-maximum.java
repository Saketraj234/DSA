/**
 * Problem: 239. Sliding Window Maximum
 *
 * Given an array nums[] and window size k,
 * return the maximum element of every window.
 *
 * Example:
 * nums = [1,3,-1,-3,5,3,6,7]
 * k = 3
 *
 * Output:
 * [3,3,5,5,6,7]
 *
 * ------------------------------------------------
 * Approach: Deque (Monotonic Queue)
 * ------------------------------------------------
 *
 * We store indices inside deque.
 *
 * Why indices?
 * Because we need to:
 * 1. Remove out of window elements
 * 2. Access values using nums[index]
 *
 * ------------------------------------------------
 * Important Observation:
 * ------------------------------------------------
 *
 * Deque always stores elements in decreasing order.
 *
 * Front of deque =>
 * Maximum element of current window
 *
 * ------------------------------------------------
 * Steps:
 * ------------------------------------------------
 *
 * 1. Remove indices which are out of current window
 *
 * 2. Remove smaller elements from back
 *    because they can never become maximum
 *
 * 3. Add current index
 *
 * 4. Store answer when window size becomes k
 *
 * ------------------------------------------------
 * Time Complexity: O(n)
 * Space Complexity: O(k)
 */

class Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {

        // Deque stores indices
        Deque<Integer> dq = new ArrayDeque<>();

        int n = nums.length;

        // Final answer array
        int[] ans = new int[n - k + 1];

        int idx = 0;

        for (int i = 0; i < n; i++) {

            // -----------------------------------
            // Remove out of window indices
            // -----------------------------------
            //
            // Example:
            // window size = 3
            //
            // Current index = 4
            //
            // Valid window:
            // [2,3,4]
            //
            // So indices <= (4-3)=1
            // should be removed
            //
            if (!dq.isEmpty() &&
                dq.peekFirst() <= i - k) {

                dq.pollFirst();
            }

            // -----------------------------------
            // Remove smaller elements
            // -----------------------------------
            //
            // If current element is bigger,
            // smaller elements behind it
            // can never become maximum
            //
            while (!dq.isEmpty() &&
                   nums[dq.peekLast()] <= nums[i]) {

                dq.pollLast();
            }

            // -----------------------------------
            // Add current index
            // -----------------------------------
            dq.offerLast(i);

            // -----------------------------------
            // Store answer
            // -----------------------------------
            //
            // Window starts forming
            // when i >= k-1
            //
            if (i >= k - 1) {

                // Front contains maximum element
                ans[idx++] = nums[dq.peekFirst()];
            }
        }

        return ans;
    }
}