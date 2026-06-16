/**
 * Problem: 846. Hand of Straights
 *
 * Tumhe cards ka ek array hand diya gaya hai aur ek groupSize.
 *
 * Check karna hai ki kya saare cards ko aise groups me divide
 * kiya ja sakta hai:
 *
 * 1. Har group ka size = groupSize ho.
 * 2. Har group ke cards consecutive ho.
 *
 * Approach:
 * Hum TreeMap + Greedy use karte hain.
 *
 * TreeMap frequencies ko sorted order me store karta hai.
 *
 * Greedy Idea:
 * Hamesha smallest available card se group banana start karo.
 *
 * Agar start card x hai to hume:
 *
 * x, x+1, x+2, .... x+groupSize-1
 *
 * sab milne chahiye.
 *
 * Agar koi card missing hua to answer false.
 *
 * Group banne ke baad frequencies reduce kar do.
 *
 * Jab tak map empty nahi hota,
 * groups banate raho.
 *
 * Time Complexity: O(n log n)
 * Space Complexity: O(n)
 */

class Solution {

    public boolean isNStraightHand(int[] hand, int groupSize) {

        // Agar total cards groupSize se divide hi nahi hote
        // to valid groups banana impossible hai
        if (hand.length % groupSize != 0) {
            return false;
        }

        // Frequency store karne ke liye TreeMap
        TreeMap<Integer, Integer> map = new TreeMap<>();

        // Har card ki frequency count karo
        for (int card : hand) {
            map.put(card, map.getOrDefault(card, 0) + 1);
        }

        // Jab tak cards bache hue hain
        while (!map.isEmpty()) {

            // Sabse chhota available card
            int start = map.firstKey();

            // Ek complete group banane ki koshish karo
            for (int i = 0; i < groupSize; i++) {

                int curr = start + i;

                // Consecutive card nahi mila
                if (!map.containsKey(curr)) {
                    return false;
                }

                // Card use kar liya
                map.put(curr, map.get(curr) - 1);

                // Frequency 0 ho gayi to remove kar do
                if (map.get(curr) == 0) {
                    map.remove(curr);
                }
            }
        }

        // Saare groups successfully ban gaye
        return true;
    }
}