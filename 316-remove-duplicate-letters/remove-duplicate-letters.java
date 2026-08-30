/**
 * Problem: 316. Remove Duplicate Letters
 *
 * Given a string s, remove duplicate letters so that
 * every letter appears once and only once.
 *
 * Return the smallest lexicographical order possible.
 *
 * Approach:
 *
 * We use Stack + Greedy.
 *
 * First count the frequency of every character.
 *
 * For every character:
 *
 * 1. Decrease its frequency because we are processing it.
 *
 * 2. If character is already present in stack,
 *    skip it.
 *
 * 3. Otherwise, while:
 *
 *    - Stack is not empty
 *    - Stack top is greater than current character
 *    - Stack top character appears again later
 *
 *    Remove the stack top.
 *
 *    This helps us create the smallest
 *    lexicographical order.
 *
 * 4. Push current character into stack.
 *
 * Final Answer:
 *
 * Convert stack into String.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
 
class Solution {
    public String removeDuplicateLetters(String s) {
        int[] freq = new int[26];
        boolean[] visited = new boolean[26];

        for(int i = 0; i < s.length(); i++){
            freq[s.charAt(i) - 'a']++;
        }

        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);

            freq[ch - 'a']--;

            if(visited[ch - 'a']) {
                continue;
            }

            while(!stack.isEmpty()
             && stack.peek() > ch
             && freq[stack.peek() - 'a'] > 0){
                char removed = stack.pop();
                visited[removed - 'a'] = false;
             }

             stack.push(ch);
             visited[ch - 'a']= true;
        }

        StringBuilder result = new StringBuilder();

        for (char ch : stack) {
            result.append(ch);
        }
        return result.toString();
    }
}