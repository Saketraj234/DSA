/**
 * Problem: 657. Robot Return to Origin
 *
 * Given a string moves containing U, D, L, R.
 * Return true if the robot returns to the origin (0,0).
 *
 * Approach:
 * We count opposite movements.
 *
 * U and D cancel each other.
 * L and R cancel each other.
 *
 * If up == down AND left == right,
 * then the robot returns to (0,0).
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public boolean judgeCircle(String moves) {
        int n = moves.length();

        int up = 0;
        int down = 0;
        int left = 0;
        int right = 0;

        for(int i = 0; i < n; i++){
            char move = moves.charAt(i);

            if(move == 'U'){
                up++;
            }
            else if(move == 'D'){
                down++;
            }
            else if(move == 'L'){
                left++;
            }
            else if(move == 'R'){
                right++;
            }
        }

        if(up == down && left == right){
            return true;
        } else {
            return false;
        }
    }
}