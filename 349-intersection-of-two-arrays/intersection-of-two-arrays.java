/**
 * Problem: 349. Intersection of Two Arrays
 *
 * Given two integer arrays nums1 and nums2,
 * return an array of their intersection.
 * Each element in the result must be unique.
 *
 * Approach:
 * We use HashSet.
 *
 * Step 1:
 * Store all elements of nums1 in a HashSet.
 *
 * Step 2:
 * Traverse nums2.
 * If an element exists in the first HashSet,
 * add it to another HashSet (to avoid duplicates).
 *
 * Step 3:
 * Convert the result HashSet into an int[] array.
 *
 * Time Complexity: O(n + m)
 * Space Complexity: O(n)
 */

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
       
       HashSet<Integer> set = new HashSet<>();
       HashSet<Integer> resultSet = new HashSet<>();

       for(int num : nums1){
        set.add(num);
       }

       for(int num : nums2){
        if(set.contains(num)){
            resultSet.add(num);
        }
       }

       int[] ans = new int[resultSet.size()];
       int i = 0; 

       for(int num : resultSet){
        ans[i++] = num;
       }

       return ans;
        }
    }