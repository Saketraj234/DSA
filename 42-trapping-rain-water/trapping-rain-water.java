/**
 * Problem: 42. Trapping Rain Water
 *
 * Given n non-negative integers representing
 * an elevation map where the width of each bar is 1,
 * compute how much water it can trap after raining.
 *
 * Approach:
 * We use Two Pointers.
 *
 * lMax = maximum height from left side
 * rMax = maximum height from right side
 *
 * If height[l] <= height[r],
 * then left side is safe to process.
 *
 * If current height is smaller than lMax,
 * water can be trapped.
 *
 * Otherwise update lMax.
 *
 * Same logic applies for right side.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {

    public int trap(int[] height) {

        int lMax = 0;
        int rMax = 0;

        int total = 0;

        int l = 0;
        int r = height.length - 1;

        while (l < r) {

            if (height[l] <= height[r]) {

                // Water trapped on left side
                if (lMax > height[l]) {

                    total += lMax - height[l];

                } else {

                    lMax = height[l];
                }

                l++;

            } else {

                // Water trapped on right side
                if (rMax > height[r]) {

                    total += rMax - height[r];

                } else {

                    rMax = height[r];
                }

                r--;
            }
        }

        return total;
    }
}