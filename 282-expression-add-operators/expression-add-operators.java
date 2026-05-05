/**
 * Problem: 282. Expression Add Operators
 *
 * Given a string num that contains only digits and an integer target,
 * return all possibilities to insert the binary operators '+', '-', or '*'
 * between the digits so that the resultant expression evaluates to target.
 *
 * Important:
 * - Digits must remain in the same order.
 * - No leading zeros allowed (e.g., "05" is invalid).
 *
 * Example:
 * Input: num = "123", target = 6
 * Output: ["1+2+3", "1*2*3"]
 *
 * Approach:
 * We use Backtracking (Recursion).
 *
 * At each step:
 * - Choose a substring as current number.
 * - Try all 3 operators: +, -, *
 *
 * Key Trick:
 * For multiplication, we handle precedence using:
 * value = value - last + (last * curr)
 *
 * Time Complexity: O(4^n)
 * Space Complexity: O(n)
 */

class Solution {

    List<String> result = new ArrayList<>();

    public void solve(String num, int target, int index, long value, long last, String path) {

        // Base case: if all digits are used
        if (index == num.length()) {
            if (value == target) {
                result.add(path);
            }
            return;
        }

        for (int i = index; i < num.length(); i++) {

            // Avoid leading zero
            if (i != index && num.charAt(index) == '0') break;

            // Get current number
            String currStr = num.substring(index, i + 1);
            long curr = Long.parseLong(currStr);

            // First number (no operator)
            if (index == 0) {
                solve(num, target, i + 1, curr, curr, currStr);
            } 
            else {
                // Addition
                solve(num, target, i + 1,
                      value + curr,
                      curr,
                      path + "+" + currStr);

                // Subtraction
                solve(num, target, i + 1,
                      value - curr,
                      -curr,
                      path + "-" + currStr);

                // Multiplication (handle precedence)
                solve(num, target, i + 1,
                      value - last + (last * curr),
                      last * curr,
                      path + "*" + currStr);
            }
        }
    }

    public List<String> addOperators(String num, int target) {
        solve(num, target, 0, 0, 0, "");
        return result;
    }
}