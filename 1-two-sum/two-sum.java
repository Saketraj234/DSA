class Solution {
    public int[] twoSum(int[] nums, int target) {

        // Map to store:
        // key   = number
        // value = index of that number
        // Purpose: fast lookup (O(1))
        HashMap<Integer, Integer> map = new HashMap<>();

        // Traverse the array once
        for (int i = 0; i < nums.length; i++) {

            // Required value to reach target
            // nums[i] + need = target
            int need = target - nums[i];

            // If required value already exists in map
            // that means we found the pair
            if (map.containsKey(need)) {

                // return indices of the two numbers
                return new int[] { map.get(need), i };
            }

            // Otherwise, store current number with its index
            map.put(nums[i], i);
        }

        // As per problem, solution always exists
        // This line is just for safety
        return new int[] {};
    }
}
