/**
 * Problem: 944. Delete Columns to Make Sorted
 *
 * Given an array of strings strs.
 * return the number of columns that are not sorted.
 *
 * Approach:
 * We check each column from top to bottom.
 *
 * If strs[i].charAt(j) > strs[i + 1].charAt(j),
 * the column is unsorted.
 *
 * We increase count and break to check the next column.
 *
 * Time Complexity: O(n * m)
 * Space Complexity: O(1)
 */

class Solution {

    public int minDeletionSize(String[] strs) {

        int count = 0;

        for (int j = 0; j < strs[0].length(); j++) {

            for (int i = 0; i < strs.length - 1; i++) {

                // Check if the column is unsorted
                if (strs[i].charAt(j) > strs[i + 1].charAt(j)) {
                    count++;
                    break;
                }
            }
        }

        return count;
    }
}
