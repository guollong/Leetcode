/**
 * Question description: You are climbing a stair case. It takes n steps to reach to the top.
 * 		Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * Note: Given n will be a positive integer.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; 
 * Company: Adobe, Apple.
 * Create Date: 03/28/2017
 * Update date: 06/02/2017
 */

// 仍然只能想到这一种方法呢。。。。
// get number of 1s and number of 2s, then use permutation get the result.
public class Solution {
    public int climbStairs(int n) {
        int sum = 0;
        // "i" is the number of 1-step, and (n - i) / 2 is the number of 2-step.
        int i = (n % 2 == 1) ? 1 : 0;
        for (; i <= n; i = i + 2) {
            int step2 = (n - i) / 2;
            sum += (int)combination(i, i + step2);
        }
        return sum;
    }
    
    // 当多次用到multiplication时，要考虑数据类型的边界问题。
    private long combination(int selection, int total) {
        int count = 0;
        long result = 1;
        selection = Math.min(selection, total - selection);
        while (count < selection) {
            result *= total;
            total--;
            count++;
            result /= count;
        }
        return result;
    }
    
}

// Solution from discussion.
// it is actually a fibonacci problem.
// Explaination: dynamic programming problem. Base case is n=0, 1, 2.
// 		For other n, if we know the number of ways to get to point(n-2) and point(n-1), the number of ways to 
//		get the point (n) is the sum of previous two values.
public class Solution {
    public int climbStairs(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }
        int previousOne = 2;
        int previousTwo = 1;
        int sum = 0;
        for (int i = 2; i < n; i++) {
            sum = previousOne + previousTwo;
            previousTwo = previousOne;
            previousOne = sum;
        }
        return sum;
    }
}





