/**
 * Problem: 363. Max Sum of Rectangle No Larger Than K
 *
 * Given an m x n matrix and an integer k,
 * return the maximum sum of a rectangle
 * that is no larger than k.
 *
 * Approach:
 * We use Prefix Sum + TreeSet.
 *
 * Fix left and right columns.
 * Calculate row sums between these columns.
 *
 * Use prefix sum to find the maximum subarray sum <= k.
 * TreeSet helps find the required prefix efficiently.
 *
 * Time Complexity: O(min(m,n)^2 * max(m,n) * log(max(m,n)))
 * Space Complexity: O(max(m,n))
 */

import java.util.*;

class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {

        int m = matrix.length;
        int n = matrix[0].length;

        int ans = Integer.MIN_VALUE;

        // Optimize by using the smaller dimension
        if (m > n) {
            int[][] transposed = new int[n][m];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    transposed[j][i] = matrix[i][j];
                }
            }

            matrix = transposed;
            m = matrix.length;
            n = matrix[0].length;
        }

        for (int left = 0; left < n; left++) {

            int[] rowSum = new int[m];

            for (int right = left; right < n; right++) {

                for (int r = 0; r < m; r++) {
                    rowSum[r] += matrix[r][right];
                }

                TreeSet<Integer> set = new TreeSet<>();
                set.add(0);

                int prefixSum = 0;

                for (int sum : rowSum) {
                    prefixSum += sum;

                    // Find smallest prefix >= prefixSum - k
                    Integer target =
                        set.ceiling(prefixSum - k);

                    if (target != null) {
                        ans = Math.max(
                            ans, prefixSum - target
                        );
                    }

                    set.add(prefixSum);

                    if (ans == k) {
                        return k;
                    }
                }
            }
        }

        return ans;
    }
}