/**
 * Problem: 888. Fair Candy Swap
 *
 * Given two arrays A and B representing candies of Alice and Bob.
 * Alice and Bob exchange exactly one box each.
 * After the swap, both should have the same total candies.
 *
 * Approach:
 * We use HashSet.
 *
 * Let:
 * Alice total = sumA
 * Bob total   = sumB
 *
 * Suppose Alice gives x and Bob gives y.
 *
 * After swap:
 * Alice = sumA - x + y
 * Bob   = sumB - y + x
 *
 * For equal candies:
 *
 * sumA - x + y = sumB - y + x
 *
 * Therefore:
 *
 * x - y = (sumA - sumB) / 2
 *
 * We store all Bob's candy values in a HashSet.
 *
 * For every x in Alice:
 * y = x - difference
 *
 * If y exists in Bob's HashSet,
 * then [x, y] is our answer.
 *
 * Time Complexity: O(n + m)
 * Space Complexity: O(m)
 */

class Solution {
    public int[] fairCandySwap(int[] a, int[] b) {

        int aliceTotal = 0;
        int bobTotal = 0;

        // Total candies
        for (int x : a) {
            aliceTotal += x;
        }

        for (int x : b) {
            bobTotal += x;
        }

        // Difference that Alice needs to give extra
        int diff = (aliceTotal - bobTotal) / 2;

        // Store Bob's candies
        HashSet<Integer> set = new HashSet<>();

        for (int x : b) {
            set.add(x);
        }

        // Find x - y = diff
        for (int x : a) {

            int y = x - diff;

            if (set.contains(y)) {
                return new int[]{x, y};
            }
        }

        return new int[]{};
    }
}