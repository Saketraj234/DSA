class Solution {
    public int maxDistance(List<List<Integer>> arrays){

        int min = arrays.get(0).get(0);
        int max = arrays.get(0).get(arrays.get(0).size() - 1);

        int ans = 0;
        for(int i = 1; i < arrays.size(); i++){

            int currentMin =  arrays.get(i).get(0);      
            int currentMax = arrays.get(i).get(arrays.get(i).size() - 1);

            int distance1 = max - currentMin;
            int distance2 = currentMax - min;

            ans = Math.max(ans, Math.max(distance1, distance2));

            min = Math.min(min, currentMin);
            max = Math.max(max, currentMax);
        }
        return ans;
    }
}