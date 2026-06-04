/**
 * Problem: 1358. Number of Substrings Containing All Three Characters
 *
 * Given a string s consisting only of characters 'a', 'b', and 'c'.
 *
 * Return the number of substrings containing at least one occurrence
 * of all these three characters.
 *
 * Approach:
 * We store the last seen index of 'a', 'b', and 'c'.
 *
 * lastSeen[0] -> last index of 'a'
 * lastSeen[1] -> last index of 'b'
 * lastSeen[2] -> last index of 'c'
 *
 * At every index i:
 * Update the last occurrence of current character.
 *
 * If all three characters have been seen,
 * then:
 *
 * count += 1 + min(lastSeen[a], lastSeen[b], lastSeen[c])
 *
 * Why?
 * Any starting index from 0 to minIndex will form
 * a valid substring ending at i.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {

    public int numberOfSubstrings(String s) {

        int[] lastSeen = {-1, -1, -1};

        int count = 0;

        for (int i = 0; i < s.length(); i++) {

            // Update last occurrence of current character
            lastSeen[s.charAt(i) - 'a'] = i;

            // Check if a, b and c are all present
            if (lastSeen[0] != -1 &&
                lastSeen[1] != -1 &&
                lastSeen[2] != -1) {

                int minIndex = Math.min(
                        lastSeen[0],
                        Math.min(lastSeen[1], lastSeen[2])
                );

                count += (minIndex + 1);
            }
        }

        return count;
    }
}