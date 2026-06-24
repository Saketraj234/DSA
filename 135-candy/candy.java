/**
 * Problem: 135. Candy
 *
 * There are n children standing in a line.
 * Each child has a rating value.
 *
 * Rules:
 * 1. Every child must have at least one candy.
 * 2. Children with a higher rating than their adjacent neighbor
 *    must get more candies.
 *
 * Approach:
 * We use the Slope (Peak & Valley) Greedy Method.
 *
 * 1. If ratings are equal:
 *      Give 1 candy.
 *
 * 2. Count increasing slope:
 *      1, 2, 3, ...
 *      Store highest value in peak.
 *
 * 3. Count decreasing slope:
 *      1, 2, 3, ...
 *      Store length in down.
 *
 * 4. If decreasing slope is longer than peak,
 *      add (down - peak) to adjust the peak candy.
 *
 * Time Complexity : O(n)
 * Space Complexity: O(1)
 */
class Solution {

    public int candy(int[] ratings) {

        int n = ratings.length;

        int sum = 1;
        int i = 1;

        while (i < n) {

            // Equal ratings
            if (ratings[i] == ratings[i - 1]) {
                sum += 1;
                i++;
                continue;
            }

            // Increasing slope
            int peak = 1;

            while (i < n && ratings[i] > ratings[i - 1]) {
                peak++;
                sum += peak;
                i++;
            }

            // Decreasing slope
            int down = 1;

            while (i < n && ratings[i] < ratings[i - 1]) {
                sum += down;
                i++;
                down++;
            }

            // Peak adjustment
            if (down > peak) {
                sum += (down - peak);
            }
        }

        return sum;
    }
}