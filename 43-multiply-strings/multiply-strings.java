/**
 * Problem: 43. Multiply Strings
 *
 * Given two non-negative integers num1 and num2 represented as strings,
 * return the product of num1 and num2 as a string.
 *
 * Approach:
 * We use an integer array to store the multiplication result.
 *
 * Each digit of nums1 is multiplied with each digit of nums2.
 *
 * product = digit1 * digit2
 *
 * pos1 = i + j
 * pos2 = i + j + 1
 *
 * We add the product to the correct position and handle carry.
 *
 * result[pos2] = sum % 10;
 * result[pos1] += sum / 10;
 *
 * Finally, we convert the result array into a String.
 *
 * Time Complexity: O(n * m)
 * Space Complexity: O(n + m)
 */
 
class Solution {
    public String multiply(String nums1, String nums2) {

        if(nums1.equals("0") || nums2.equals("0")) {
            return "0";
        }
         
        int[] result = new int[nums1.length() + nums2.length()];


        for (int i = nums1.length() - 1; i >= 0; i--) {
            for (int j = nums2.length() - 1; j >= 0; j--) {

                int digit1 = nums1.charAt(i) - '0';
                int digit2 = nums2.charAt(j) - '0';

                int product = digit1 * digit2;

                int pos1 = i + j;
                int pos2 = i + j + 1;

                int sum = product + result[pos2];

                result[pos2] = sum % 10;
                result[pos1] += sum / 10;
            }
        }

        StringBuilder ans = new StringBuilder();

        for (int num : result) {
            if (ans.length() == 0 && num == 0) {
                continue;
            }

            ans.append(num);
        }

        return ans.toString();
    }
}


