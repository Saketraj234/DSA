/**
 * Problem: 27. Remove Element
 *
 * Given an integer array nums and an integer val,
 * remove all occurrences of val in-place.
 *
 * Return the number of elements not equal to val (k).
 *
 * The first k elements of nums should contain
 * the final result.
 *
 * ----------------------------------------------------
 * Approach:
 * Two Pointer Technique
 *
 * Idea:
 * - Use index pointer to place valid elements
 * - Traverse array using i
 * - If nums[i] != val → keep it
 * - Else skip it
 *
 * ----------------------------------------------------
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {

    public int removeElement(int[] nums, int val) {

        int index = 0;  // position to place next valid element

        for (int i = 0; i < nums.length; i++) {

            // keep only elements not equal to val
            if (nums[i] != val) {
                nums[index] = nums[i];
                index++;
            }
        }

        // index = count of valid elements
        return index;
    }
}