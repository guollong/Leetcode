/**
 * Question description: Given an unsorted array return whether an increasing subsequence of length 3 exists or not 
 *		in the array. Formally the function should return true if there exists i, j, k, such that arr[i] < arr[j] < arr[k] 
 *		given 0 ≤ i < j < k ≤ n-1 else return false.
 * 
 * Your algorithm should run in O(n) time complexity and O(1) space complexity.
 * 
 * Examples: Given [1, 2, 3, 4, 5], return true.
 *			 Given [5, 4, 3, 2, 1], return false.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: Facebook.
 */

/**
 * Progress...
 * Create Date: 08/09/2017
 */

// Idea: Start with two largest values, as soon as we find a number bigger than both, return true;
public class Solution {
    public boolean increasingTriplet(int[] nums) {
        int smaller = Integer.MAX_VALUE;
        int bigger = Integer.MAX_VALUE;
        for (int number : nums) {
            if (number <= smaller) {
                smaller = number;
            } else if (number <= bigger) {
                bigger = number;
            } else {
                return true;
            }
        }
        return false;
    }
}



