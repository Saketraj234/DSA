/**
 * Problem: 917. Reverse Only Letters
 *
 * Given a string s, reverse only the letters
 * while keeping all non-letter characters
 * at their original positions.
 *
 * Approach:
 * We use Two Pointer.
 *
 * left = 0
 * right = n - 1
 *
 * If left character is not a letter,
 * move left forward.
 *
 * If right character is not a letter,
 * move right backward.
 *
 * If both are letters, swap them.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

class Solution {
    public String reverseOnlyLetters(String s) {
        int n = s.length();

        StringBuilder sb = new StringBuilder(s);

        int left = 0;
        int right = n - 1;

        while(left < right){
            if(!Character.isLetter(sb.charAt(left))){
                left++;
            } else if(!Character.isLetter(sb.charAt(right))){
                right--;
            } else{
                char temp = sb.charAt(left);
                sb.setCharAt(left, sb.charAt(right));
                sb.setCharAt(right, temp);


                left++;
                right--;
            }
        }
        return sb.toString();
    }
}