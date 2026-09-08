/**
 * Problem: 306. Additive Number
 *
 * Given a string num, return true if it can be split
 * into an additive sequence.
 *
 * Approach:
 * We use Brute Force + String Addition.
 *
 * first = first number
 * second = second number
 *
 * next = first + second
 *
 * We check whether next exists in the string.
 * If yes, move forward:
 * first = second
 * second = next
 *
 * We try different first and second numbers.
 *
 * Leading zero is not allowed.
 *
 * Time Complexity: O(n^3)
 * Space Complexity: O(n)
 */

class Solution {

    public boolean isAdditiveNumber(String num) {

        int n = num.length();

        for (int i = 1; i <= n / 2; i++) {

            // First number cannot have leading zero
            if (num.charAt(0) == '0' && i > 1) {
                break;
            }

            for (int j = i + 1; j < n; j++) {

                // Second number cannot have leading zero
                if (num.charAt(i) == '0' && j - i > 1) {
                    break;
                }

                String first = num.substring(0, i);
                String second = num.substring(i, j);

                int k = j;

                while (k < n) {

                    // Find next number
                    String sum = add(first, second);

                    // Check whether sum matches
                    // with the remaining string
                    if (!num.startsWith(sum, k)) {
                        break;
                    }

                    k += sum.length();

                    // Move to next pair
                    first = second;
                    second = sum;
                }

                // Entire string is used
                if (k == n) {
                    return true;
                }
            }
        }

        return false;
    }

    // Add two numbers represented as Strings
    private String add(String a, String b) {

        int i = a.length() - 1;
        int j = b.length() - 1;

        int carry = 0;

        StringBuilder ans = new StringBuilder();

        while (i >= 0 || j >= 0 || carry > 0) {

            int sum = carry;

            if (i >= 0) {
                sum += a.charAt(i) - '0';
                i--;
            }

            if (j >= 0) {
                sum += b.charAt(j) - '0';
                j--;
            }

            ans.append(sum % 10);

            carry = sum / 10;
        }

        return ans.reverse().toString();
    }
}