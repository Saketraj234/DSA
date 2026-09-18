/**
 * Problem: 830. Positions of Large Groups
 *
 * Given a string s.
 * A large group is 3 or more same characters consecutively.
 * Return the starting and ending positions of every large group.
 *
 * Approach:
 * We use Two Pointer / Group Traversal.
 *
 * start = starting index of current group.
 * i = current index.
 *
 * When a different character is found,
 * the current group ends at i - 1.
 *
 * If group length >= 3, add [start, i - 1].
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1) excluding answer.
 */

class Solution {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> ans = new ArrayList<>();

        int start = 0;

        for(int i = 1; i <= s.length(); i++){
            if(i == s.length() || s.charAt(i) != s.charAt(start)){
                int length = i - start;

                if(length >= 3){
                    ans.add(Arrays.asList(start, i - 1));
                }
                start = i;
            }
        }
        return ans;
    }
}