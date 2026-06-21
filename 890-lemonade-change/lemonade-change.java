/**
 * Problem: 860. Lemonade Change
 *
 * Given an array bills where each customer pays with
 * $5, $10, or $20 bills, return true if we can provide
 * the correct change to every customer. Otherwise, return false.
 *
 * Approach:
 * We keep track of the number of $5 and $10 bills.
 *
 * - If customer pays with $5:
 *   No change needed, just increase five count.
 *
 * - If customer pays with $10:
 *   Give one $5 as change.
 *   If no $5 bill is available, return false.
 *
 * - If customer pays with $20:
 *   Need to give $15 as change.
 *   Prefer giving one $10 and one $5 (to save $5 bills).
 *   Otherwise, give three $5 bills.
 *   If neither is possible, return false.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {

    public boolean lemonadeChange(int[] bills) {

        // Count of $5 and $10 bills available
        int five = 0;
        int ten = 0;

        // Process each customer one by one
        for (int bill : bills) {

            // Customer pays with $5
            if (bill == 5) {
                five++;
            }

            // Customer pays with $10
            else if (bill == 10) {

                // Give one $5 as change
                if (five > 0) {
                    five--;
                    ten++;
                } else {
                    return false;
                }
            }

            // Customer pays with $20
            else {

                // Prefer giving one $10 and one $5
                if (ten > 0 && five > 0) {
                    ten--;
                    five--;
                }

                // Otherwise give three $5 bills
                else if (five >= 3) {
                    five -= 3;
                }

                // Cannot provide change
                else {
                    return false;
                }
            }
        }

        // Successfully served all customers
        return true;
    }
}