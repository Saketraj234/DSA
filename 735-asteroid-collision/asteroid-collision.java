/**
 * Problem: 735. Asteroid Collision
 *
 * We are given an array of asteroids.
 * Positive number -> moving right
 * Negative number -> moving left
 *
 * Return final state after all collisions.
 *
 * Approach:
 * We use Stack.
 *
 * - Push positive asteroids directly.
 * - Collision happens only when:
 *      stack top > 0 and current asteroid < 0
 *
 * Cases:
 * 1. |current| > top
 *      -> pop stack asteroid
 *
 * 2. |current| == top
 *      -> both destroy
 *
 * 3. |current| < top
 *      -> current destroy
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

class Solution {

    public int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> st = new Stack<>();

        for (int asteroid : asteroids) {

            while (!st.isEmpty()
                    && asteroid < 0
                    && st.peek() > 0) {

                // current asteroid bigger
                if (Math.abs(asteroid) > st.peek()) {
                    st.pop();
                    continue;
                }

                // both same size
                else if (Math.abs(asteroid) == st.peek()) {
                    st.pop();
                }

                asteroid = 0;
                break;
            }

            if (asteroid != 0) {
                st.push(asteroid);
            }
        }

        int[] ans = new int[st.size()];

        for (int i = st.size() - 1; i >= 0; i--) {
            ans[i] = st.pop();
        }

        return ans;
    }
}