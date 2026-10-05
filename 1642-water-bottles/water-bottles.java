class Solution {
    public int numWaterBottles(int numB, int numE) {

      int ans = numB;
        while(numB >= numE){
            int n = numB / numE;
            int rem = numB % numE;
            ans += n;
            numB = rem + n;
        }
        return ans;
    }
}