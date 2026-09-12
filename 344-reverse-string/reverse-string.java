/**
 * Problem: 344. Reverse String
 *
 * Given a character array s.
 * Reverse the array in-place.
 *
 * Approach:
 * We use Two Pointers.
 *
 * left = 0
 * right = s.length - 1
 *
 * We swap s[left] and s[right].
 * Then move left forward and right backward.
 *
 * We continue until left < right.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
 
class Solution {
    public void reverseString(char[] s) {

      int left = 0;
      int right = s.length - 1;

      while(left < right){

        char temp = s[left];
        s[left] = s[right];
        s[right] = temp;

        left++;
        right--;

      }
    }
}