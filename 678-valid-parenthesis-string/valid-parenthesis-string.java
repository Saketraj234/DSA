/**
 * Problem: 678. Valid Parenthesis String
 *
 * Given a string s containing only '(', ')' and '*',
 * return true if s can be a valid parenthesis string.
 *
 * Approach:
 * We use Greedy.
 *
 * minOpen = minimum number of open brackets possible.
 * maxOpen = maximum number of open brackets possible.
 *
 * For '(':
 * minOpen++, maxOpen++
 *
 * For ')':
 * minOpen--, maxOpen--
 *
 * For '*':
 * minOpen-- (treat '*' as ')')
 * maxOpen++ (treat '*' as '(')
 *
 * If maxOpen becomes negative, there are too many ')',
 * so return false.
 *
 * minOpen cannot be negative, so:
 * minOpen = max(0, minOpen)
 *
 * At the end, if minOpen == 0,
 * then a valid arrangement exists.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {

    public boolean checkValidString(String s) {

        int minOpen = 0;
        int maxOpen = 0;

        for (char ch : s.toCharArray()) {

            // Opening bracket
            if (ch == '(') {

                minOpen++;
                maxOpen++;
            }

            // Closing bracket
            else if (ch == ')') {

                minOpen--;
                maxOpen--;
            }

            // '*' can act as '(' or ')' or empty
            else {

                minOpen--;
                maxOpen++;
            }

            // Too many closing brackets
            if (maxOpen < 0) {
                return false;
            }

            // Minimum open brackets cannot be negative
            minOpen = Math.max(0, minOpen);
        }

        // All brackets can be balanced
        return minOpen == 0;
    }
}