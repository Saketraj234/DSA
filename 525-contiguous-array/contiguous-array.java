/**
 * Problem: 525. Contiguous Array
 *
 * Given a binary array nums,
 * return the maximum length of a contiguous subarray
 * with equal number of 0 and 1.
 *
 * Approach:
 *
 * We use Prefix Sum + HashMap.
 *
 * Treat:
 * 0 as -1
 * 1 as +1
 *
 * If the same count appears again,
 * the subarray between those two indices has
 * equal number of 0 and 1.
 *
 * We store the first index of every count
 * to get the maximum length.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

import java.util.*;

class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        int maxLen = 0;
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, -1);

        for(int i = 0; i < n; i++){

            if(nums[i] == 0){
                count--;
            } else {
                count++;
            }

            if(map.containsKey(count)){
                int previousIndex = map.get(count);
                int length = i - previousIndex;

                maxLen = Math.max(maxLen, length);
            } else{
                map.put(count, i);
            }
        }
        return maxLen;
    }
}