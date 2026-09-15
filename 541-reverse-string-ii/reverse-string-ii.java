/**
 * Problem: 541. Reverse String II
 *
 * Given a string s and an integer k.
 * Reverse the first k characters for every 2k characters.
 *
 * Approach:
 * We process the string in blocks of 2k.
 *
 * For every block:
 * - First k characters -> Reverse
 * - Next k characters -> Keep same
 *
 * We use Two Pointer to reverse the first k characters.
 *
 * right = Math.min(i + k - 1, n - 1)
 * This handles the case when fewer than k characters are left.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

class Solution {
    public String reverseStr(String s, int k) {

        char[] arr = s.toCharArray();
        int n = arr.length;

        for(int i = 0; i < n ; i+= 2 * k){
            int left = i;
            int right = Math.min(i + k - 1, n - 1);

            while(left < right){
                char temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;

                left++;
                right--;
            }
        }
        return new String(arr);
    }
}