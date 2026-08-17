/**
 * Problem: 414. Third Maximum Number
 *
 * Given an integer array nums,
 * return the third distinct maximum number.
 * If the third maximum does not exist, return the maximum number.
 *
 * Approach:
 * We keep track of 3 largest distinct numbers.
 *
 * first  = largest number
 * second = second largest number
 * third  = third largest number
 *
 * If a new number is greater than first:
 * third = second
 * second = first
 * first = num
 *
 * If a new number is greater than second:
 * third = second
 * second = num
 *
 * If a new number is greater than third:
 * third = num
 *
 * Duplicate numbers are ignored.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {

    public int thirdMax(int[] nums) {

        Long first = null;
        Long second = null;
        Long third = null;

        for (int num : nums) {

            // Ignore duplicate numbers
            if ((first != null && num == first) ||
                (second != null && num == second) ||
                (third != null && num == third)) {
                continue;
            }

            // New largest number
            if (first == null || num > first) {
                third = second;
                second = first;
                first = (long) num;
            }

            // New second largest
            else if (second == null || num > second) {
                third = second;
                second = (long) num;
            }

            // New third largest
            else if (third == null || num > third) {
                third = (long) num;
            }
        }

        // If third maximum doesn't exist,
        // return the maximum number
        return third == null
                ? first.intValue()
                : third.intValue();
    }
}