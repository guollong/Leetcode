// 待解决：np问题

/** 
 * Question description: Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 * For example, given the array [-2,1,-3,4,-1,2,1,-5,4], the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; Company: Linkedin.
 * Date: 02/04/2017
 */

// My own solution. Time Limit Exceeded(记得是有问题的哦)
// Running time complexity: O(n^2)
public class Solution {
    public int maxSubArray(int[] nums) {
        int length = nums.length;
        int sum;
        int max = Integer.MIN_VALUE;;
        for (int i = 0; i < length; i++) {
            sum = 0;
            for (int j = i; j < length; j++) {
                sum = sum + nums[j];
                if (sum > max) {
                    max = sum;
                }
            }
        }
        return max;
    }
}

// Improved solution one.
// Running time complexity: O(n)
// Notes: This solution is a little bit tricky. When the sum of the previous elements is negative, we
// 		  simply discard that sum and start with the current element.
public class Solution {
    public int maxSubArray(int[] A) {
        int max = Integer.MIN_VALUE, sum = 0;
        for (int i = 0; i < A.length; i++) {
            if (sum < 0) {
                sum = A[i];
            }
            else {
                sum += A[i];
            }
            if (sum > max) {
                max = sum;
            }
        }
        return max;
    }
}

// Improved solution two.
// Running time complexity: O(n)
/** 
 * Analysis of this problem: 
 * Apparently, this is a optimization problem, which can be usually solved by DP. So when it comes to DP, the 
 * first thing for us to figure out is the format of the sub problem(or the state of each sub problem). 
 * The format of the sub problem can be helpful when we are trying to come up with the recursive relation.
 * At first, I think the sub problem should look like: maxSubArray(int A[], int i, int j), which means the 
 * maxSubArray for A[i: j]. In this way, our goal is to figure out what maxSubArray(A, 0, A.length - 1) is. 
 * However, if we define the format of the sub problem in this way, it's hard to find the connection from 
 * the sub problem to the original problem(at least for me). In other words, I can't find a way to divided 
 * the original problem into the sub problems and use the solutions of the sub problems to somehow create 
 * the solution of the original one.
 * So I change the format of the sub problem into something like: maxSubArray(int A[], int i), which means 
 * the maxSubArray for A[0:i ] which must has A[i] as the end element. Note that now the sub problem's format 
 * is less flexible and less powerful than the previous one because there's a limitation that A[i] should be 
 * contained in that sequence and we have to keep track of each solution of the sub problem to update the global 
 * optimal value. However, now the connect between the sub problem and the original one becomes clearer:
 * maxSubArray(A, i) = maxSubArray(A, i - 1) > 0 ? maxSubArray(A, i - 1) : 0 + A[i]; 
 */

public class Solution {
	public int maxSubArray(int[] A) {
        int n = A.length;
        int[] dp = new int[n];		//dp[i] means the maximum subarray ending with A[i];
        dp[0] = A[0];
        int max = dp[0];
        
        for(int i = 1; i < n; i++){
            dp[i] = A[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
            max = Math.max(max, dp[i]);
        }
        
        return max;
	}
}












