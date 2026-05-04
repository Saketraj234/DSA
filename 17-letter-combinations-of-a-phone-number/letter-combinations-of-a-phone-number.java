/**
 * Problem: 17. Letter Combinations of a Phone Number
 *
 * Given a string digits containing digits from 2-9,
 * return all possible letter combinations that the number could represent.
 *
 * The mapping is just like a phone keypad:
 * 2 -> abc
 * 3 -> def
 * 4 -> ghi
 * 5 -> jkl
 * 6 -> mno
 * 7 -> pqrs
 * 8 -> tuv
 * 9 -> wxyz
 *
 * Return the answer in any order.
 * If input is empty, return an empty list.
 *
 * Example 1:
 * Input: digits = "23"
 * Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 *
 * Example 2:
 * Input: digits = "7"
 * Output: ["p","q","r","s"]
 *
 * Approach:
 * We use Backtracking (Recursion).
 *
 * At each digit, we try all possible letters mapped to it.
 * We build combinations step by step.
 *
 * Base Case:
 * If index == digits.length(), add current string to result.
 *
 * Choice:
 * Loop through all letters of current digit.
 *
 * Backtrack:
 * Add character → recurse → remove character.
 *
 * Time Complexity: O(4^n)
 * Space Complexity: O(n)
 */

class Solution {

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        if (digits == null || digits.length() == 0) {
            return result;
        }

        String[] map = {
            "",     // 0
            "",     // 1
            "abc",  // 2
            "def",  // 3
            "ghi",  // 4
            "jkl",  // 5
            "mno",  // 6
            "pqrs", // 7
            "tuv",  // 8
            "wxyz"  // 9
        };

        backtrack(digits, 0, new StringBuilder(), result, map);
        return result;
    }

    private void backtrack(String digits, int index, StringBuilder current,
                           List<String> result, String[] map) {

        // Base case
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        String letters = map[digits.charAt(index) - '0'];

        for (char ch : letters.toCharArray()) {
            current.append(ch);              // choose
            backtrack(digits, index + 1, current, result, map); // explore
            current.deleteCharAt(current.length() - 1); // backtrack
        }
    }
}