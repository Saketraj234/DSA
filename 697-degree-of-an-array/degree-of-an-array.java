/**
 * Problem: 697. Degree of an Array
 *
 * Given an array nums,
 * return the length of the shortest subarray
 * having the same degree as the original array.
 *
 * Approach:
 * We use HashMap.
 *
 * Store:
 * count[num]      = frequency of number
 * firstIndex[num] = first occurrence index
 *
 * While traversing:
 *
 * If frequency > degree:
 *     update degree
 *     update minimum length
 *
 * If frequency == degree:
 *     calculate current subarray length
 *     update minimum length
 *
 * Length = currentIndex - firstIndex + 1
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

class Solution {

    public int findShortestSubArray(int[] nums) {

        HashMap<Integer, Integer> count = new HashMap<>();
        HashMap<Integer, Integer> firstIndex = new HashMap<>();

        int degree = 0;
        int minLength = nums.length;

        for (int i = 0; i < nums.length; i++) {

            int num = nums[i];

            // Store first occurrence
            if (!firstIndex.containsKey(num)) {
                firstIndex.put(num, i);
            }

            // Increase frequency
            count.put(num, count.getOrDefault(num, 0) + 1);

            int frequency = count.get(num);

            // New maximum frequency found
            if (frequency > degree) {

                degree = frequency;

                minLength = i - firstIndex.get(num) + 1;
            }

            // Same degree found
            else if (frequency == degree) {

                int length = i - firstIndex.get(num) + 1;

                minLength = Math.min(minLength, length);
            }
        }

        return minLength;
    }
}