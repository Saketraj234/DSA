/*
    Problem: Minimum Number of Days to Make m Bouquets

    Approach:
    - We use Binary Search on days.
    - Why? Because if it is possible to make m bouquets on day X,
      then it will also be possible on any day > X.
      (Monotonic property)

    - So we search for the minimum day for which possible() returns true.

    Time Complexity: O(n * log(maxDay))
    Space Complexity: O(1)
*/

class Solution {

    public int minDays(int[] bloomDay, int m, int k) {

        int n = bloomDay.length;

        // If total flowers required > available flowers → impossible
        if ((long)m * k > n) return -1;

        // Find minimum and maximum bloom day
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        for (int day : bloomDay) {
            low = Math.min(low, day);
            high = Math.max(high, day);
        }

        int ans = high; // store minimum valid day

        // Binary Search on days
        while (low <= high) {

            int mid = low + (high - low) / 2;

            // Check if we can make m bouquets on day = mid
            if (possible(bloomDay, mid, m, k)) {

                ans = mid;      // possible → store answer
                high = mid - 1; // try smaller day (left side)

            } else {

                low = mid + 1;  // not possible → need bigger day
            }
        }

        return ans;
    }


    /*
        This function checks:
        Can we make at least m bouquets
        if current day is 'day'?
    */
    private boolean possible(int[] arr, int day, int m, int k) {

        int count = 0;      // count of consecutive bloomed flowers
        int bouquets = 0;   // total bouquets formed

        for (int i = 0; i < arr.length; i++) {

            // If flower has bloomed by 'day'
            if (arr[i] <= day) {
                count++;
            } else {
                // Break in adjacency → form bouquets from previous segment
                bouquets += count / k;
                count = 0;  // reset count
            }
        }

        // Handle last segment
        bouquets += count / k;

        return bouquets >= m;
    }
}
