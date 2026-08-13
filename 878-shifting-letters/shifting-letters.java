/**
 * Problem: 848. Shifting Letters
 *
 * Given a string s and an array shifts.
 * For each shifts[i], shift the first i + 1 characters
 * of the string by shifts[i] positions.
 *
 * Approach:
 * We process the shifts from right to left.
 *
 * totalShift = totalShift + shifts[i]
 *
 * This tells how many total shifts are applied
 * to the character at index i.
 *
 * We use % 26 because there are only 26 letters.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

class Solution {

    public String shiftingLetters(String s, int[] shifts) {

        char[] arr = s.toCharArray();

        int totalShift = 0;

        for (int i = shifts.length - 1; i >= 0; i--) {

            // Count total shifts for index i
            totalShift = (totalShift + shifts[i]) % 26;

            // Shift the current character
            arr[i] = (char) ('a' + (arr[i] - 'a' + totalShift) % 26);
        }

        return new String(arr);
    }
}