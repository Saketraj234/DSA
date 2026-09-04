class Solution {
    public int[] fairCandySwap(int[] a, int[] b) {

        int aliceTotal = 0;
        int bobTotal = 0;

        // Total candies
        for (int x : a) {
            aliceTotal += x;
        }

        for (int x : b) {
            bobTotal += x;
        }

        // Difference that Alice needs to give extra
        int diff = (aliceTotal - bobTotal) / 2;

        // Store Bob's candies
        HashSet<Integer> set = new HashSet<>();

        for (int x : b) {
            set.add(x);
        }

        // Find x - y = diff
        for (int x : a) {

            int y = x - diff;

            if (set.contains(y)) {
                return new int[]{x, y};
            }
        }

        return new int[]{};
    }
}