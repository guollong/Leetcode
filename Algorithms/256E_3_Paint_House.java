/**
 * Question: There are a row of n houses, each house can be painted with one of the three colors: red, blue or green. The cost of painting 
 * each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same 
 * color. The cost of painting each house with a certain color is represented by a n x 3 cost matrix. For example, costs[0][0] is
 * the cost of painting house 0 with color red; costs[1][2] is the cost of painting house 1 with color green, and so on... Find 
 * the minimum cost to paint all houses.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; 
 * Company: Linkedin.
 * Create Date: 02/03/2017
 * Update date: 06/13/2017
 */

// This is a dynamic programming problem. Get the min from the result of last time.
// DP ???
public class Solution {
    public int minCost(int[][] costs) {
        if (costs.length == 0) {
            return 0;
        }
        for (int i = 1; i < costs.length; i++) {
            costs[i][0] += Math.min(costs[i - 1][1], costs[i - 1][2]);
            costs[i][1] += Math.min(costs[i - 1][0], costs[i - 1][2]);
            costs[i][2] += Math.min(costs[i - 1][0], costs[i - 1][1]);
        }
        int index = costs.length - 1;
        return Math.min(Math.min(costs[index][0], costs[index][1]), costs[index][2]);
    }
}
