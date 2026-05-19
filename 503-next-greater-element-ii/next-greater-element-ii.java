/**
 * Problem: 503. Next Greater Element II
 *
 * Given a circular integer array nums,
 * return the next greater number for every element.
 * If no greater element exists, return -1.
 *
 * Approach:
 * We use Monotonic Stack.
 *
 * Traverse array from (2*n - 1) to 0
 * because array is circular.
 *
 * Remove smaller/equal elements from stack.
 * Stack top becomes next greater element.
 *
 * Push current element into stack.
 *
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */

class Solution {

    public int[] nextGreaterElements(int[] nums) {

        int n = nums.length;
        int[] ans = new int[n];

        Arrays.fill(ans, -1);

        Stack<Integer> st = new Stack<>();

        for(int i = 2*n - 1; i >= 0; i--) {

            // Remove smaller elements
            while(!st.isEmpty() &&
                  st.peek() <= nums[i % n]) {
                st.pop();
            }

            // Store answer only for original array
            if(i < n) {
                if(!st.isEmpty())
                    ans[i] = st.peek();
            }

            st.push(nums[i % n]);
        }

        return ans;
    }
}