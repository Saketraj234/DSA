/**
 * Problem: 6. Zigzag Conversion
 *
 * Given a string s and an integer numRows,
 * write the characters of s in a zigzag pattern
 * and then read the pattern row by row.
 *
 * Example:
 * s = "PAYPALISHIRING", numRows = 3
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 *
 * Answer = "PAHNAPLSIIGYIR"
 *
 * Approach:
 * We use StringBuilder for each row.
 *
 * Instead of creating a 2D matrix, we directly
 * store characters in their respective rows.
 *
 * We maintain:
 * row       -> current row
 * direction -> movement direction
 *
 * direction = 1  -> move down
 * direction = -1 -> move up
 *
 * When we reach the first row, we move down.
 * When we reach the last row, we move up.
 *
 * Finally, we join all rows to get the answer.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

class Solution {

    public String convert(String s, int numRows) {

        // If there is only one row,
        // zigzag is not possible.
        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }

        // Create StringBuilder for each row
        StringBuilder[] rows = new StringBuilder[numRows];

        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        // Start from first row
        int row = 0;

        // 1 = DOWN, -1 = UP
        int direction = 1;

        // Traverse every character
        for (char ch : s.toCharArray()) {

            // Add character to current row
            rows[row].append(ch);

            // If we reach the first row,
            // start moving DOWN
            if (row == 0) {
                direction = 1;
            }

            // If we reach the last row,
            // start moving UP
            else if (row == numRows - 1) {
                direction = -1;
            }

            // Move to next row
            row += direction;
        }

        // Combine all rows
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < numRows; i++) {
            ans.append(rows[i]);
        }

        return ans.toString();
    }
}