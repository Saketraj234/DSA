/**
 * Problem: 4. Median of Two Sorted Arrays
 *
 * Idea:
 * - We divide both arrays into two halves.
 * - Left half should contain half of total elements.
 * - All elements in left half must be <= elements in right half.
 *
 * Partition Rule:
 *      cut1 + cut2 = (n1 + n2 + 1) / 2
 *
 * If partition is correct:
 *      left1 <= right2 && left2 <= right1
 *
 * If total elements even:
 *      median = (max(left1,left2) + min(right1,right2)) / 2
 * If odd:
 *      median = max(left1,left2)
 *
 * Time: O(log(min(n1,n2)))
 * Space: O(1)
 */

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        // Always binary search on smaller array
        if (nums1.length > nums2.length)
            return findMedianSortedArrays(nums2, nums1);

        int n1 = nums1.length, n2 = nums2.length;
        int low = 0, high = n1;

        while (low <= high) {

            int cut1 = (low + high) / 2;
            int cut2 = (n1 + n2 + 1) / 2 - cut1;

            int left1  = (cut1 == 0) ? Integer.MIN_VALUE : nums1[cut1 - 1];
            int right1 = (cut1 == n1) ? Integer.MAX_VALUE : nums1[cut1];
            int left2  = (cut2 == 0) ? Integer.MIN_VALUE : nums2[cut2 - 1];
            int right2 = (cut2 == n2) ? Integer.MAX_VALUE : nums2[cut2];

            // Correct partition
            if (left1 <= right2 && left2 <= right1) {

                if ((n1 + n2) % 2 == 0)
                    return (Math.max(left1, left2) +
                            Math.min(right1, right2)) / 2.0;

                return Math.max(left1, left2);
            }
            else if (left1 > right2) {
                high = cut1 - 1;
            }
            else {
                low = cut1 + 1;
            }
        }

        return 0.0;
    }
}