/**
 * Problem: 496. Next Greater Element I
 *
 * Given two arrays nums1 and nums2,
 * for each element in nums1,
 * find the next greater element in nums2.
 *
 * The next greater element of x is
 * the first greater element on the right side of x in nums2.
 *
 * Approach:
 * We use Monotonic Stack + HashMap.
 *
 * Traverse nums2 from right to left.
 *
 * Maintain a decreasing stack:
 * - Pop smaller or equal elements
 * - Top of stack becomes next greater
 *
 * Store next greater values in HashMap.
 *
 * Then build answer for nums1 using the map.
 *
 * Time Complexity: O(n + m)
 * Space Complexity: O(n)
 */

class Solution {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        Stack<Integer> st = new Stack<>();

        HashMap<Integer, Integer> map = new HashMap<>();

        // Find Next Greater Element for nums2
        for (int i = nums2.length - 1; i >= 0; i--) {

            while (!st.isEmpty() && st.peek() <= nums2[i]) {
                st.pop();
            }

            // If no greater element exists
            if (st.isEmpty()) {
                map.put(nums2[i], -1);
            } else {
                map.put(nums2[i], st.peek());
            }

            st.push(nums2[i]);
        }

        // Build Answer Array
        int[] ans = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            ans[i] = map.get(nums1[i]);
        }

        return ans;
    }
}