
/**
 * Problem: 60. Permutation Sequence
 *
 * Given n and k, return the kth permutation sequence
 * of numbers from 1 to n.
 *
 * Approach:
 * We use Factorial + Mathematics.
 *
 * First, calculate factorial (n - 1)!.
 *
 * Store numbers from 1 to n in an ArrayList.
 *
 * k-- because indexing starts from 0.
 *
 * We find the next digit using:
 * index = k / fact
 *
 * Add that digit to the answer and remove it from the list.
 *
 * Update k = k % fact.
 *
 * Update fact = fact / remaining list size.
 *
 * Repeat until the list becomes empty.
 *
 * Final Answer = ans.toString()
 *
 * Time Complexity: O(n^2)
 * Space Complexity: O(n)
 */

class Solution {
    public String getPermutation(int n, int k) {

        List<Integer> list = new ArrayList<>();

        int fact = 1;

        for (int i = 1; i < n; i++) {
            fact *= i;
        }

        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        k--;

        StringBuilder ans = new StringBuilder();

        while (true) {

            int index = k / fact;

            ans.append(list.get(index));

            list.remove(index);

            if (list.size() == 0) {
                break;
            }

            k = k % fact;

            fact = fact / list.size();
        }

        return ans.toString();
    }
}
