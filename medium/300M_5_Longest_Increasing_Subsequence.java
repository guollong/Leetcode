/**
 * Question description: Given an unsorted array of integers, find the length of longest increasing subsequence.
 * 
 * Example: Given [10, 9, 2, 5, 3, 7, 101, 18], the longest increasing subsequence is [2, 3, 7, 101], 
 *		therefore the length is 4. Note that there may be more than one LIS combination, it is only 
 *		necessary for you to return the length.
 * 
 * Your algorithm should run in O(n^2) complexity.
 * 
 * Follow up: Could you improve it to O(n log n) time complexity?
 *
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: Microsoft.
 */

/**
 * Progress...
 * Create Date: 07/05/2017
 */

// Dynamic programming: Sequence DP: Running time complexity: O(n^2)
public class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        // State: f[i]表示前i个数字中以第i个结尾的LIS的长度 (注意是以i结尾)
        int[] dp = new int[nums.length];
        
        // Initialization.
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
        }
        
        // Function: f[i] = MAX{f[j]+1}, (j < i && a[j] <= a [i])
        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        
        // Result: Get the length of longest increasing subsequence.
        int maxLength = dp[0];
        for (int i = 1; i < nums.length; i++) {
            maxLength = Math.max(maxLength, dp[i]);
        }
        return maxLength;
    }
}

// Dynamic programming: Sequence DP: Running time complexity: O(n * logn), binary search.
public class Solution {
    public int lengthOfLIS(int[] nums) {
        // State: dp[i]: the minimum value a subsequence of length i+1 might end with.
        int[] dp = new int[nums.length];
        int len = 0;

        for (int x : nums) {
            // Arrays.binarySearch: 如果它包含在数组中，则返回搜索键的索引；否则返回 (-(插入点) - 1) 
            int i = Arrays.binarySearch(dp, 0, len, x);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = x;
            if (i == len) {
                len++;
            }
        }
        
        return len;
    }
}




