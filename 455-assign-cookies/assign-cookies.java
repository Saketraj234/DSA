/**
 * Problem: 455. Assign Cookies
 *
 * Given two arrays:
 * g[i] = greed factor of ith child
 * s[j] = size of jth cookie
 *
 * One child can get at most one cookie.
 * A child is satisfied if cookie size >= greed factor.
 *
 * Return the maximum number of satisfied children.
 *
 * Approach:
 * We use Greedy + Sorting.
 *
 * Sort both arrays.
 *
 * child pointer -> current child
 * cookie pointer -> current cookie
 *
 * If current cookie can satisfy current child,
 * then child++ (child is satisfied).
 *
 * In every iteration, cookie++ because one cookie
 * can be used only once.
 *
 * Final Answer = child
 *
 * Example:
 * g = [1,2,3]
 * s = [1,1]
 *
 * Sorted:
 * g = [1,2,3]
 * s = [1,1]
 *
 * cookie 1 satisfies child 1
 * cookie 1 cannot satisfy child 2
 *
 * Answer = 1
 *
 * Time Complexity: O(n log n + m log m)
 * Space Complexity: O(1)
 */

class Solution {

    public int findContentChildren(int[] g, int[] s) {

        int n = g.length;
        int m = s.length;

        // Sort both arrays
        Arrays.sort(g);
        Arrays.sort(s);

        int child = 0;
        int cookie = 0;

        while (child < n && cookie < m) {

            // If current cookie can satisfy current child
            if (g[child] <= s[cookie]) {
                child++;
            }

            // Move to next cookie
            cookie++;
        }

        // child represents total satisfied children
        return child;
    }
}