/**
 * Problem: 1436. Destination City
 *
 * Given a list of paths where paths[i] = [cityA, cityB],
 * find the city that has no outgoing path.
 *
 * Approach:
 * We use HashSet.
 *
 * First, store all starting cities in the Set.
 * Then, check every destination city.
 *
 * If a destination city is NOT present in starting cities,
 * then that city is the Destination City.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */


class Solution {
    public String destCity(List<List<String>> paths) {
        Set<String> startCities = new HashSet<>();

        for(List<String> path : paths){
            startCities.add(path.get(0));
        }

        for(List<String> path : paths){
            if(!startCities.contains(path.get(1))){
                return path.get(1);
            }
        }
        return "";
    }
}