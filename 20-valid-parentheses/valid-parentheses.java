/**
 * Problem: 20. Valid Parentheses
 *
 * Given a string s containing only
 * '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid.
 *
 * Approach:
 * We use Stack.
 *
 * - Push opening brackets into stack.
 * - When closing bracket comes,
 *   check top of stack.
 * - If mismatch → return false.
 * - At end, stack should be empty.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

import java.util.Stack;

class Solution {

    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for(char ch : s.toCharArray()) {

            // Push opening brackets
            if(ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }
            else {

                // No opening bracket present
                if(stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();

                // Check matching brackets
                if((ch == ')' && top != '(') ||
                   (ch == '}' && top != '{') ||
                   (ch == ']' && top != '[')) {

                    return false;
                }
            }
        }

        // Stack should be empty
        return stack.isEmpty();
    }
}