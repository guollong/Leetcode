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
 * Company: Microsoft, Twitter.
 */

/**
 * Progress...
 * Create Date: 07/05/2017
 * Update Date: 09/12/2017
 */

// Dynamic programming: Sequence DP: Running time complexity: O(n^2)
class Solution {
    public int lengthOfLIS(int[] nums) {
        // Corner case.
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        // State: dp[i]: The longest increasing subsequence up to index i and contains nums[i].
        //      前i个数字中以第i个结尾的LIS的长度
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int result = 1;
        
        // Function: dp[i] = MAX{dp[j]+1}, (j < i && nums[j] < nums[i])
        for (int i = 1; i < nums.length; i++) {
            int max = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    max = Math.max(max, dp[j] + 1);
                }
            }
            dp[i] = max;
            result = Math.max(result, max);
        }
        
        return result;
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
            // Find the insertion index of a new coming element, if the element is greater than 
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




