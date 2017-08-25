/**
 * Question description: There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
 *		You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). 
 *		You begin the journey with an empty tank at one of the gas stations. Return the starting gas station's index if you can 
 *		travel around the circuit once, otherwise return -1.
 * 
 * Note: The solution is guaranteed to be unique.
 *
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: 暂时无.
 */

/**
 * Progress...
 * Create Date: 08/24/2017
 */

// Greedy algorithm.
// Is it a greedy solution??? 

// Idea: If car starts at A and can not reach B. Any station between A and B cannot reach B.
//      If the total number of gas is smaller than the total number of cost. There is no solution.
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0;
        int total = 0;
        int tank = 0;
        
        for (int i = 0; i < gas.length; i++) {
            total += gas[i] - cost[i];
            tank += gas[i] - cost[i];
            if (tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }
        return total < 0 ? -1 : start;
    }
}



