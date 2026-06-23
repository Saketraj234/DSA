/**
 * Problem: 57. Insert Interval
 *
 * Given an array of non-overlapping intervals sorted by start time
 * and a newInterval, insert newInterval into intervals such that
 * the resulting intervals remain sorted and non-overlapping.
 *
 * Approach:
 * We divide the problem into 3 parts.
 *
 * 1. Add all intervals completely on the left.
 *    interval.end < newInterval.start
 *
 * 2. Merge all overlapping intervals.
 *    interval.start <= newInterval.end
 *
 *    merged.start = min(merged.start, interval.start)
 *    merged.end   = max(merged.end, interval.end)
 *
 * 3. Add all remaining intervals on the right.
 *
 *  **Rule yaad rakho:- **

 *  Current END < New START     → Left side intervals
 *  Current START <= New END    → Overlapping intervals
 *  Remaining intervals         → Right side intervals
 *  Left → Merge → Right
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

         List<int[]> res = new ArrayList<>();
         int i = 0;
         int n = intervals.length;

         // Step 1: Add intervals completely on the left
          while(i < n && intervals[i][1] < newInterval[0]){
            res.add(intervals[i]);
            i++;
          }
          
          // Step 2: Merge overlapping intervals
          while(i < n && intervals[i][0] <= newInterval[1]){

            // Update start of merged interval
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);

            // Update end of merged interval
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
          }

          // Add the merged interval
          res.add(newInterval);

          // Step 3: Add remaining intervals on the right
          while (i < n){
            res.add(intervals[i]);
            i++;
          }

          return res.toArray(new int[res.size()][]);
    }
}