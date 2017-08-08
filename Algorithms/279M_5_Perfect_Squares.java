/**
 * Question description: Given a positive integer n, find the least number of perfect square numbers 
 *		(for example, 1, 4, 9, 16, ...) which sum to n.
 *
 * Example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: Google.
 */

/**
 * Progress...
 * Create Date: 08/01/2017
 */

// Solution 1: Dynamic programming.
public class Solution {
    public int numSquares(int n) {
        // Step1: f[i]: the least number of perfect square numbers which sums to i.
        int[] dp = new int[n + 1];
        
        // Step2: Initialization.
        dp[0] = 0;
        
        // Step3: Function: For each i, it must be the sum of some number (i - j*j) and a perfect square number (j*j).
        for (int i = 1; i <= n; i++) {
            // Create local variable to lower the times to access memory.
            int min = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                min = Math.min(min, dp[i - j * j] + 1);
            }
            dp[i] = min;
        }
        return dp[n];
    }
}


// Solution 2: BFS: 没看懂呢～ 到底需不需要掌握呢？？？？
public int numSquares(int n) {
    ArrayList<Integer> squares = new ArrayList<Integer>();
    for(int i = 1; i*i <= n; i++){
        squares.add(i*i);
    }

    HashSet<Integer> set = new HashSet<Integer>();
    Queue<Integer> queue = new LinkedList<Integer>();
    queue.offer(n);
    int levels = 0;

    while(!queue.isEmpty()){
        levels++;
        int size = queue.size();
        for(int i = 0; i < size; i++){
            int cur = queue.poll();
            for(int element : squares){
                int newValue = cur - element; 
                if(newValue < 0){
                    break;
                }
                if(newValue == 0){
                    return levels;
                }
                if(set.contains(newValue)){
                    continue;
                }

                queue.offer(newValue);
                set.add(newValue);
            }
        }
    }
    return -1;
}




