/**
 * Problem: 164. Maximum Gap
 *
 * Given an integer array nums,
 * return the maximum difference between two successive
 * elements in its sorted form.
 *
 * Approach:
 * We use Bucket Sort (Pigeonhole Principle).
 *
 * 1. Find the minimum and maximum element.
 * 2. Calculate bucket size and bucket count.
 * 3. Store only the minimum and maximum value of each bucket.
 * 4. Maximum gap will always be between two non-empty buckets,
 *    not inside the same bucket.
 * 5. Traverse all buckets and compute:
 *
 *      gap = currentBucketMin - previousBucketMax
 *
 * 6. Return the maximum gap.
 *
 * Why Bucket Sort?
 * Sorting takes O(n log n).
 * Bucket Sort solves it in linear time by avoiding complete sorting.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

class Solution {
    public int maximumGap(int[] nums) {

        if(nums == null || nums.length < 2){
            return 0;
        }

        int n = nums.length;

        int min = nums[0];
        int max = nums[0];

        for(int i = 1; i < nums.length; i++){
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }

        if(min == max){
            return 0;
        }
        int bucketSize = Math.max(1, (max - min) / (n - 1));

        int bucketCount = (max - min) / bucketSize + 1;

        int[] bucketMin = new int[bucketCount];
        int[] bucketMax = new int[bucketCount];

        boolean[] used = new boolean[bucketCount];

        Arrays.fill(bucketMin, Integer.MAX_VALUE);
        Arrays.fill(bucketMax, Integer.MIN_VALUE);
        for(int num : nums){
            int index = (num - min) /bucketSize;

            bucketMin[index] = Math.min(bucketMin[index], num);
            bucketMax[index] = Math.max(bucketMax[index], num);

            used[index] = true;
        }

        int maxGap = 0;
        int prevMax = bucketMax[0];

        for(int i = 1; i < bucketCount; i++){
            if(!used[i]){
                continue;
            }

            maxGap = Math.max(maxGap, bucketMin[i] - prevMax);
            prevMax = bucketMax[i];
        }
     return maxGap;
    }
}