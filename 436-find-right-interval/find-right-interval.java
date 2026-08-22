/**
 * Problem: 436. Find Right Interval
 *
 * Given an array of intervals,
 * return the index of the right interval for every interval.
 *
 * A right interval must have:
 *
 * start >= current interval's end
 *
 * If multiple intervals are valid,
 * choose the one with the smallest start.
 *
 * Approach:
 *
 * We use Sorting + Binary Search.
 *
 * 1. Store:
 *    [start, originalIndex]
 *
 * 2. Sort all intervals by start.
 *
 * 3. For every interval:
 *    target = current interval's end
 *
 * 4. Use Binary Search to find
 *    the first start >= target.
 *
 * 5. Return its original index.
 *
 * Time Complexity: O(n log n)
 * Space Complexity: O(n)
 */

class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int[][] arr = new int[n][2];

        for(int i = 0; i < n; i++){
            arr[i][0] = intervals[i][0];
            arr[i][1] = i;
        }

        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        int[] ans =new int[n];

        for(int i = 0; i < n; i++){

            int target = intervals[i][1];
            int left = 0;
            int right = n - 1;
            int index = -1;

            while(left <= right){

                int mid = left + (right - left) / 2;

                if(arr[mid][0] >= target){
                    index = arr[mid][1];
                    right = mid - 1;
                } else{
                    left = mid + 1;
                }
            }
            
            ans[i] = index;
        }
        return ans;
    }
}