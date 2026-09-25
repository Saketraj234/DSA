/**
 * Problem: 1539. Kth Missing Positive Number
 *
 * Given a sorted array of positive integers arr,
 * return the kth positive integer that is missing from this array.
 *
 * Approach:
 * We use Binary Search.
 *
 * missing(i) = arr[i] - (i + 1)
 *
 * This tells how many numbers are missing till index i.
 *
 * We find the first index where missing >= k.
 *
 * Final Answer = low + k
 *
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */

class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> map = new HashMap<>();

        for(int i = 0; i < list1.length; i++){
            map.put(list1[i], i);
        }

        List<String> ans = new ArrayList<>();
        int min = Integer.MAX_VALUE;

        for(int j = 0; j < list2.length; j++){
            if(map.containsKey(list2[j])){
                int sum = map.get(list2[j]) + j;

                if(sum < min){
                    min = sum;
                    ans.clear();
                    ans.add(list2[j]);
                } else if(sum == min){
                    ans.add(list2[j]);
                }
            }
        }
        return ans.toArray(new String[0]);
    }
}