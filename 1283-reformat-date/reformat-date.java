/**
 * Problem: 1507. Reformat Date
 *
 * Given a date in the format:
 *
 * Day Month Year
 *
 * Example:
 *
 * "20th Oct 2052"
 *
 * Convert it into:
 *
 * "2052-10-20"
 *
 * Approach:
 *
 * 1. Split the date using spaces.
 *
 * 2. Extract:
 *    - Day
 *    - Month
 *    - Year
 *
 * 3. Remove the suffix from day
 *    such as st, nd, rd, th.
 *
 * 4. Convert month into its
 *    corresponding number.
 *
 * 5. Return the date in format:
 *
 *    YYYY-MM-DD
 *
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 */

class Solution {

    public String reformatDate(String date) {

        // Split date into day, month and year
        String[] parts = date.split(" ");

        String day = parts[0];
        String month = parts[1];
        String year = parts[2];

        // Remove suffix from day
        day = day.replaceAll("[a-z]", "");

        // Add leading zero if needed
        if (day.length() == 1) {
            day = "0" + day;
        }

        String[] months = {
            "Jan", "Feb", "Mar", "Apr",
            "May", "Jun", "Jul", "Aug",
            "Sep", "Oct", "Nov", "Dec"
        };

        String monthNumber = "";

        // Find month number
        for (int i = 0; i < 12; i++) {

            if (months[i].equals(month)) {

                monthNumber = String.format("%02d", i + 1);
                break;
            }
        }

        return year + "-" + monthNumber + "-" + day;
    }
}