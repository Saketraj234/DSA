/**
 * Problem: 402. Remove K Digits
 *
 * Given a string num representing a non-negative integer,
 * remove k digits from the number so that
 * the new number becomes the smallest possible.
 *
 * Approach:
 * We use Stack.
 *
 * If current digit < stack top,
 * remove bigger digit from stack.
 *
 * This helps in making smallest number.
 *
 * After traversal:
 * - If k still remains, remove from end.
 * - Remove leading zeros.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

class Solution {

    public String removeKdigits(String num, int k) {

        Stack<Character> st = new Stack<>();

        // Traverse all digits
        for (int i = 0; i < num.length(); i++) {

            // Remove bigger previous digits
            while (!st.isEmpty()
                    && k > 0
                    && st.peek() > num.charAt(i)) {

                st.pop();
                k--;
            }

            st.push(num.charAt(i));
        }

        // Remove remaining digits from end
        while (k > 0) {
            st.pop();
            k--;
        }

        // If stack empty
        if (st.isEmpty())
            return "0";

        StringBuilder res = new StringBuilder();

        // Stack -> String
        while (!st.isEmpty()) {
            res.append(st.pop());
        }

        // Reverse string
        res.reverse();

        // Remove leading zeros
        while (res.length() > 0
                && res.charAt(0) == '0') {

            res.deleteCharAt(0);
        }

        // If empty after removing zeros
        if (res.length() == 0)
            return "0";

        return res.toString();
    }
}