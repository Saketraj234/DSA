/**
 * Problem: 435. Non-overlapping Intervals
 *
 * Given an array of intervals where intervals[i] = [starti, endi],
 * return the minimum number of intervals you need to remove
 * to make the rest of the intervals non-overlapping.
 *
 * Approach:
 * We use Greedy + Sorting.
 *
 * Sort intervals according to their ending time.
 *
 * We try to keep the maximum number of non-overlapping intervals.
 *
 * lastEndTime stores the end time of the last selected interval.
 *
 * If currentStart >= lastEndTime,
 * then there is no overlap, so we keep the interval.
 *
 * Answer = Total Intervals - Number of Intervals Kept
 *
 * Time Complexity: O(n log n)
 * Space Complexity: O(1)
 */

class Solution {

    public int eraseOverlapIntervals(int[][] intervals) {

        int n = intervals.length;

        // Sort intervals by end time
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        // First interval is selected
        int count = 1;
        int lastEndTime = intervals[0][1];

        // Traverse remaining intervals
        for (int i = 1; i < n; i++) {

            int currentStart = intervals[i][0];
            int currentEnd = intervals[i][1];

            // No overlap
            if (currentStart >= lastEndTime) {

                count++;
                lastEndTime = currentEnd;
            }
        }

        // Minimum intervals to remove
        return n - count;
    }
}