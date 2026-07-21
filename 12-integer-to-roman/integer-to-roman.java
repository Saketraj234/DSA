/**
 * Problem: 12. Integer to Roman
 *
 * Given an integer num,
 * convert it to a Roman numeral.
 *
 * Roman symbols:
 * I = 1
 * V = 5
 * X = 10
 * L = 50
 * C = 100
 * D = 500
 * M = 1000
 *
 * Approach:
 * We use Greedy.
 *
 * We always pick the largest Roman value
 * that is less than or equal to the current number.
 *
 * Values:
 * 1000 -> M
 * 900  -> CM
 * 500  -> D
 * 400  -> CD
 * 100  -> C
 * 90   -> XC
 * 50   -> L
 * 40   -> XL
 * 10   -> X
 * 9    -> IX
 * 5    -> V
 * 4    -> IV
 * 1    -> I
 *
 * While num >= value:
 *      Append corresponding Roman symbol.
 *      Subtract value from num.
 *
 * Continue until num becomes 0.
 *
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 */

class Solution {

    public String intToRoman(int num) {

        int[] values = {
            1000, 900, 500, 400,
            100, 90, 50, 40,
            10, 9, 5, 4, 1
        };

        String[] symbols = {
            "M", "CM", "D", "CD",
            "C", "XC", "L", "XL",
            "X", "IX", "V", "IV", "I"
        };

        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < values.length; i++) {

            // Keep taking the current Roman value
            while (num >= values[i]) {

                ans.append(symbols[i]);
                num -= values[i];
            }
        }

        return ans.toString();
    }
}