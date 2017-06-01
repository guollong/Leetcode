/**
 * Question description: Given n points in the plane that are all pairwise distinct, a "boomerang" is a tuple of 
 *	points (i, j, k) such that the distance between i and j equals the distance between i and k (the order of the tuple matters).
 *	Find the number of boomerangs. You may assume that n will be at most 500 and coordinates of points are all in the range [-10000, 10000] (inclusive).
 *
 * Example: Input: [[0,0],[1,0],[2,0]]; Output: 2
 * Explanation: The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]]
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; 
 * Company: Google.
 * Date: 03/27/2017
 */

// Running time complexity: O(n^2)
// Idea: For every starting points, put all distances into map. if the frequency(n) of distance is greater than 1,
// 	 	 choose 2 out of n(order matters). Then clear the map, and compute the next starting points.
public class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                if (i != j) {
                    int d = distance(points[i], points[j]);
                    if (map.containsKey(d)) {
                        map.put(d, map.get(d) + 1);
                    } else {
                        map.put(d, 1);
                    }
                }
            }
            for (int d : map.values()) {
                if (d >= 2) {
                    sum += d * (d - 1);
                }
            }
            map.clear();
        }
        return sum;
    }
    
    private int distance(int[] point1, int[] point2) {
        int sub1 = point1[0] - point2[0];
        int sub2 = point1[1] - point2[1];
        return sub1 * sub1 + sub2 * sub2;
    }
}

