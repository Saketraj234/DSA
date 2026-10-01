/**
 * Problem: 434. Number of Segments in a String
 *
 * Given a string s, return the number of segments in the string.
 *
 * A segment is defined as a contiguous sequence of non-space characters.
 *
 * Approach:
 * We traverse the string once.
 *
 * A new segment starts when:
 * current character != ' '
 * AND
 * (i == 0 OR previous character == ' ')
 *
 * Whenever a new segment starts, we increment count.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public int countSegments(String s) {
        int count = 0;

        for(int i = 0; i < s.length(); i++){
            if (s.charAt(i) != ' ' && (i == 0 || s.charAt(i - 1) == ' ')){
                count++;
            }
        }
        return count;
    }
}