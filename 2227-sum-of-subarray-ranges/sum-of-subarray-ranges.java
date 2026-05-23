/**
 * Problem: 2104. Sum of Subarray Ranges
 *
 * Given an integer array nums,
 * return the sum of all subarray ranges.
 *
 * Range of subarray =
 * maximum element - minimum element
 *
 * Approach:
 *
 * Total Answer =
 * Sum of all subarray maximums
 * -
 * Sum of all subarray minimums
 *
 * For every element:
 *
 * Contribution =
 * left × right × arr[i]
 *
 * We use monotonic stack to find:
 *
 * PSE -> Previous Smaller Element
 * NSE -> Next Smaller Element
 *
 * PGE -> Previous Greater Element
 * NGE -> Next Greater Element
 *
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */

class Solution {

    public long subArrayRanges(int[] nums) {

        // Sum of maximums - Sum of minimums
        return sumMax(nums) - sumMin(nums);
    }

    // ---------------------------------------------------
    // SUM OF SUBARRAY MINIMUMS
    // ---------------------------------------------------

    public long sumMin(int[] arr) {

        int n = arr.length;

        // Find Next Smaller Element indexes
        int[] nse = findNSE(arr);

        // Find Previous Smaller Element indexes
        int[] pse = findPSE(arr);

        long total = 0;

        for (int i = 0; i < n; i++) {

            // Elements possible on left side
            long left = i - pse[i];

            // Elements possible on right side
            long right = nse[i] - i;

            // Contribution of current element
            total += (left * right * (long) arr[i]);
        }

        return total;
    }

    // Next Smaller Element
    public int[] findNSE(int[] arr) {

        int n = arr.length;

        int[] nse = new int[n];

        Stack<Integer> st = new Stack<>();

        // Traverse from right to left
        for (int i = n - 1; i >= 0; i--) {

            // Remove greater or equal elements
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            // If stack empty, no smaller element exists
            if (st.isEmpty()) {
                nse[i] = n;
            } else {
                nse[i] = st.peek();
            }

            st.push(i);
        }

        return nse;
    }

    // Previous Smaller Element
    public int[] findPSE(int[] arr) {

        int n = arr.length;

        int[] pse = new int[n];

        Stack<Integer> st = new Stack<>();

        // Traverse from left to right
        for (int i = 0; i < n; i++) {

            // Remove greater elements
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }

            // If stack empty, no previous smaller exists
            if (st.isEmpty()) {
                pse[i] = -1;
            } else {
                pse[i] = st.peek();
            }

            st.push(i);
        }

        return pse;
    }

    // ---------------------------------------------------
    // SUM OF SUBARRAY MAXIMUMS
    // ---------------------------------------------------

    public long sumMax(int[] arr) {

        int n = arr.length;

        // Find Next Greater Element indexes
        int[] nge = findNGE(arr);

        // Find Previous Greater Element indexes
        int[] pge = findPGE(arr);

        long total = 0;

        for (int i = 0; i < n; i++) {

            // Elements possible on left side
            long left = i - pge[i];

            // Elements possible on right side
            long right = nge[i] - i;

            // Contribution of current element
            total += (left * right * (long) arr[i]);
        }

        return total;
    }

    // Next Greater Element
    public int[] findNGE(int[] arr) {

        int n = arr.length;

        int[] nge = new int[n];

        Stack<Integer> st = new Stack<>();

        // Traverse from right to left
        for (int i = n - 1; i >= 0; i--) {

            // Remove smaller or equal elements
            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                st.pop();
            }

            // If stack empty, no greater exists
            if (st.isEmpty()) {
                nge[i] = n;
            } else {
                nge[i] = st.peek();
            }

            st.push(i);
        }

        return nge;
    }

    // Previous Greater Element
    public int[] findPGE(int[] arr) {

        int n = arr.length;

        int[] pge = new int[n];

        Stack<Integer> st = new Stack<>();

        // Traverse from left to right
        for (int i = 0; i < n; i++) {

            // Remove smaller elements
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                st.pop();
            }

            // If stack empty, no previous greater exists
            if (st.isEmpty()) {
                pge[i] = -1;
            } else {
                pge[i] = st.peek();
            }

            st.push(i);
        }

        return pge;
    }
}