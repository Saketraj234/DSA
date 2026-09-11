/**
 * Problem: 415. Add Strings
 *
 * Given two non-negative integers num1 and num2 represented
 * as strings, return their sum also as a string.
 *
 * Approach:
 * We add digits from right to left.
 *
 * digit1 = num1.charAt(i) - '0'
 * digit2 = num2.charAt(j) - '0'
 *
 * sum = digit1 + digit2 + carry
 *
 * We store sum % 10 in answer
 * and carry = sum / 10.
 *
 * Finally, reverse the answer because we added
 * digits from right to left.
 *
 * Time Complexity: O(max(n, m))
 * Space Complexity: O(max(n, m))
 */

class Solution {
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;

        int carry = 0;

        StringBuilder ans = new StringBuilder();

        while(i >= 0 || j >= 0 || carry > 0){
            int digit1 = 0;
            int digit2 = 0;

            if(i >= 0){
                digit1 = num1.charAt(i) - '0';
                i--;
            }
            if(j >= 0){
                digit2 = num2.charAt(j) - '0';
                j--;
            }

            int sum = digit1 + digit2 + carry;

            ans.append(sum % 10);

            carry = sum / 10;
        }
        return ans.reverse().toString();
    }
}