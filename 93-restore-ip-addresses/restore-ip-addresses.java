/**
 * Problem: 93. Restore IP Addresses
 *
 * Given a string s containing only digits,
 * return all possible valid IP addresses that can be formed
 * by inserting exactly three dots.
 *
 * Approach:
 * We use Backtracking.
 *
 * An IP address has exactly 4 parts.
 * Each part can contain 1 to 3 digits.
 *
 * A part is valid if:
 * - Its value is between 0 and 255.
 * - It does not contain a leading zero.
 *
 * We try 1, 2 and 3 digits for every part.
 * If the part is valid, we recursively build the next part.
 *
 * When 4 parts are created:
 * - If the whole string is used, add the IP to answer.
 * - Otherwise, return.
 *
 * Time Complexity: O(3^4) = O(81)
 * Space Complexity: O(4) recursion stack
 */

class Solution {

    public List<String> restoreIpAddresses(String s) {

        List<String> ans = new ArrayList<>();

        backtrack(s, 0, 0, "", ans);

        return ans;
    }

    public void backtrack(String s, int index, int parts,
                           String currentIP, List<String> ans) {

        // 4 parts complete
        if (parts == 4) {

            // Whole string must be used
            if (index == s.length()) {
                ans.add(currentIP);
            }

            return;
        }

        // Try 1, 2 and 3 digits
        for (int length = 1; length <= 3; length++) {

            // Index string ke bahar na chala jaye
            if (index + length > s.length()) {
                break;
            }

            String part = s.substring(index, index + length);

            // Leading zero check
            if (part.length() > 1 && part.charAt(0) == '0') {
                break;
            }

            // Part must be <= 255
            if (Integer.parseInt(part) > 255) {
                break;
            }

            // Current IP mein part add karo
            String newIP;

            if (currentIP.length() == 0) {
                newIP = part;
            } else {
                newIP = currentIP + "." + part;
            }

            // Next part ke liye recursion
            backtrack(
                s,
                index + length,
                parts + 1,
                newIP,
                ans
            );
        }
    }
}