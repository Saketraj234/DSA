/**
 * Problem: 205. Isomorphic Strings
 *
 * Given two strings s and t,
 * check whether they are isomorphic.
 *
 * Two strings are isomorphic if characters in s
 * can be replaced to get t.
 *
 * Conditions:
 * - Each character must map to exactly one character
 * - No two characters can map to the same character
 * - Mapping must be consistent
 *
 * Approach:
 * We use last seen index technique.
 *
 * We maintain two arrays:
 * mapS → stores last seen index of characters in s
 * mapT → stores last seen index of characters in t
 *
 * If at any point:
 * mapS[c1] != mapT[c2] → return false
 *
 * Else update:
 * mapS[c1] = i + 1
 * mapT[c2] = i + 1
 *
 * This ensures same pattern mapping.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {

    public boolean isIsomorphic(String s, String t) {

        // Step 1: Length check
        if (s.length() != t.length()) return false;

        // Step 2: Create mapping arrays
        int[] mapS = new int[256];
        int[] mapT = new int[256];

        // Step 3: Traverse both strings
        for (int i = 0; i < s.length(); i++) {

            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            // Step 4: Check pattern mismatch
            if (mapS[c1] != mapT[c2]) {
                return false;
            }

            // Step 5: Store last seen index
            mapS[c1] = i + 1;
            mapT[c2] = i + 1;
        }

        // Step 6: Valid mapping
        return true;
    }
}