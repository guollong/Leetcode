/**
 * Question description: Find the contiguous subarray within an array (containing at least one number)
 *		which has the largest sum.
 *
 * Example: given the array [-2,1,-3,4,-1,2,1,-5,4], the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 * 
 * Follow up: Solve the problem in O(n), try coding another solution using the divide and conquer approach, which is more subtle.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; 
 * Company: LinkedIn, Bloomberg, Microsoft.
 */

/**
 * Progress...
 * Create Date: 06/03/2017
 */

/**
 * Dynamic programming method idea:
 * (The first thing to solve DP problem is figuring out the format of sub problem.)
 * 1>. From original thinking, the sub problem could be maxSubArray(int A[], int i, int j). However,
 * 	   in this way, I can't find a way to divided the original problem into the sub problems.
 * 2>. So I change the format of the sub problem into something like: maxSubArray(int A[], int i), 
 * 	   which means the maxSubArray for A[0:i ] which must has A[i] as the end element. Now the connect
 *	   between the sub problem and the original one becomes clearer.
 */
public static int maxSubArray(int[] A) {
    int maxSoFar = A[0];
    int maxEndingHere = A[0];
    for (int i = 1; i < A.length; i++){
    	maxEndingHere = Math.max(maxEndingHere + A[i], A[i]);
    	maxSoFar = Math.max(maxSoFar, maxEndingHere);	
    }
    return maxSoFar;
}


/**
 * Divide and conquer method.
 * Step1: Select the middle element of the array. So the maximum subarray may contain that middle element or not.
 * Step 2.1: If the maximum subarray does not contain the middle element, then we can apply the same algorithm to
 *			 the the subarray to the left of the middle element and the subarray to the right of the middle element.
 * Step 2.2: If the maximum subarray does contain the middle element, then the result will be simply the maximum
 *			 suffix subarray of the left subarray plus the maximum prefix subarray of the right subarray.
 * Step 3: return the maximum of those three answer.
 */
public class Solution {
    public int maxSubArray(int[] A) {
        if (A.length == 0) {
            return 0;
        }
        return maxSubArrayHelper(A, 0, A.length - 1);
    }
    
    private int maxSubArrayHelper(int[] A, int left, int right) {
        if (left == right) {
            return A[left];
        }
        int mid = left + (right - left) / 2;
        // If the maximum subarray does not contain the middle element.
        int leftAns = maxSubArrayHelper(A, left, mid);
        int rightAns = maxSubArrayHelper(A, mid + 1, right);
        
        // If the maximum subarray containS the middle element, get the maximum sum = leftMax + rightMax.
        int leftMax = A[mid];
        int rightMax = A[mid + 1];
        int temp = 0;
        for (int i = mid; i >= left; i--) {
            temp += A[i];
            if (temp > leftMax) {
                leftMax = temp;
            }
        }
        temp = 0;
        for (int i = mid + 1; i <= right; i++) {
            temp += A[i];
            if (temp > rightMax) {
                rightMax = temp;
            }
        }
        return Math.max(Math.max(leftAns, rightAns),leftMax+rightMax);
    }
}


// Time Limit Exceeded solution. O(n^2).
public class Solution {
    public int maxSubArray(int[] nums) {
        // "i" is the number of elements in a subarray.
        int start = 0;
        int end = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j < nums.length - i + 1; j++) {
                start = j;
                end = j + i;
                maxSum = Math.max(sumSubArray(nums, start, end), maxSum);
            }
        }
        return maxSum;
    }
    
    private int sumSubArray(int[] nums, int start, int end) {
        int sum = 0;
        for (int i = start; i < end; i++) {
            sum += nums[i];
        }
        return sum;
    }
}

