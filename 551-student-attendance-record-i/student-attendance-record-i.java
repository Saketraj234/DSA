/**
 * Problem: 551. Student Attendance Record I
 *
 * Given a string s containing:
 * 'A' = Absent
 * 'L' = Late
 * 'P' = Present
 *
 * Return true if the student is eligible.
 *
 * Approach:
 * We use a single traversal.
 *
 * countA = total number of absent days.
 * consecutiveL = number of consecutive late days.
 *
 * If countA > 1 → false
 * If consecutiveL >= 3 → false
 *
 * Otherwise → true
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public boolean checkRecord(String s) {
        int countA = 0;
        int consecutiveL = 0;

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) =='A'){
                countA++;
            }

            if(countA > 1) return false;

            if (s.charAt(i) == 'L'){
               consecutiveL++;
            } else{
                consecutiveL = 0;
            }
            if(consecutiveL >= 3) return false;
        }
        return true;
    }
}