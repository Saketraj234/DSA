/**
 * Problem: 621. Task Scheduler
 *
 * Given an array of CPU tasks represented by characters A-Z
 * and an integer n representing the cooldown period.
 *
 * Two same tasks must be separated by at least n intervals.
 *
 * Return the minimum number of CPU intervals required
 * to complete all tasks.
 *
 * Approach:
 * Count frequency of each task.
 *
 * maxFreq = highest frequency among all tasks.
 *
 * countMax = number of tasks having frequency = maxFreq.
 *
 * We create blocks using the most frequent task.
 *
 * Formula:
 * (maxFreq - 1) * (n + 1) + countMax
 *
 * Sometimes there are enough tasks to fill all idle slots,
 * so the answer cannot be less than total tasks.
 *
 * Final Answer:
 * max(tasks.length, formula)
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public int leastInterval(char[] tasks, int n) {
        
        int[] freq = new int[26];

        //count frequency of each task
        for(char task : tasks) {
            freq[task - 'A']++;
        }

        //Find max frequency
        int maxFreq = 0;

        for(int f : freq){
            maxFreq = Math.max(maxFreq, f);
        }
        
        // Count how many tasks have max freq
        int countMax = 0;

        for(int f : freq){
            if(f == maxFreq){
                countMax++;
            }
        }

        // Apply formula 
        int intervals = (maxFreq - 1) * (n + 1) + countMax;
        return Math.max(tasks.length, intervals);
    }
}