/**
 * Problem: 367. Valid Perfect Square
 *
 * Given a positive integer num,
 * return true if num is a perfect square,
 * otherwise return false.
 *
 *
 * Approach:
 *
 * We use Binary Search.
 *
 * We search from 1 to num.
 *
 * mid = left + (right - left) / 2
 *
 * square = mid * mid
 *
 * If square == num, return true.
 *
 * If square < num, search right side.
 *
 * If square > num, search left side.
 *
 * If no perfect square is found,
 * return false.
 *
 *
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 *
 */

class Solution {
    public boolean isPerfectSquare(int num) {
        int left = 1;
        int right = num;

        while(left <= right){
            int mid = left + (right - left) / 2;

            if((long)mid * mid == num){
                return true;
            } else if((long)mid * mid < num){
                left = mid + 1;
            } else{
                right = mid - 1;
            }
        }
        return false;
    }
}