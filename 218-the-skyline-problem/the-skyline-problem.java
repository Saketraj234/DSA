/**
 * Problem: 218. The Skyline Problem
 *
 * Given buildings represented as [left, right, height],
 * return the skyline formed by these buildings.
 *
 * Approach:
 * We use Sweep Line Algorithm + TreeMap.
 *
 * Each building creates two events:
 * Start: (left, -height)
 * End:   (right, height)
 *
 * Negative height represents building start.
 * Positive height represents building end.
 *
 * TreeMap maintains heights and their frequencies.
 *
 * At each x-coordinate, process all events.
 * Current maximum height = lastKey().
 *
 * If maximum height changes, add a key point.
 *
 * Time Complexity: O(n log n)
 * Space Complexity: O(n)
 */

class Solution {

    public List<List<Integer>> getSkyline(int[][] buildings) {

        List<int[]> events = new ArrayList<>();

        for (int[] b : buildings) {
            events.add(new int[]{b[0], -b[2]});
            events.add(new int[]{b[1], b[2]});
        }

        events.sort((a, b) -> {
            if (a[0] != b[0])
                return Integer.compare(a[0], b[0]);

            return Integer.compare(a[1], b[1]);
        });

        TreeMap<Integer, Integer> map = new TreeMap<>();

        map.put(0, 1);

        List<List<Integer>> ans = new ArrayList<>();

        int prev = 0;
        int i = 0;

        while (i < events.size()) {

            int x = events.get(i)[0];

            while (i < events.size() && events.get(i)[0] == x) {

                int h = events.get(i)[1];

                if (h < 0) {
                    map.put(-h, map.getOrDefault(-h, 0) + 1);
                } else {
                    int count = map.get(h);

                    if (count == 1)
                        map.remove(h);
                    else
                        map.put(h, count - 1);
                }

                i++;
            }

            int curr = map.lastKey();

            if (curr != prev) {
                ans.add(Arrays.asList(x, curr));
                prev = curr;
            }
        }

        return ans;
    }
}