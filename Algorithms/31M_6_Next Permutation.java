/**
 * Question description: Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 *		If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 * 
 * Note: The replacement must be in-place, do not allocate extra memory.
 * 
 * Examples: 
 *	1,2,3 → 1,3,2
 *	3,2,1 → 1,2,3
 *	1,1,5 → 1,5,1
 *
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: Google.
 */

/**
 * Progress...
 * Create Date: 08/22/2017
 */

class Solution {
    // Steps: 
    //  1. Finding the rightmost element that is smaller than its next element, let's say the index found is (i - 1).
    //  2. Finding an element that is next greater than nums[i] from the right of the index (i - 1) in nums array, 
    //  3. Assume the index we found in step2 is j, swap element nums[i - 1] and nums[j].
    //  3. Sort the elements in the array since index i.
    public void nextPermutation(int[] nums) {
        // Step1.
        int start = nums.length - 2;
        for (; start >= 0; start--) {
            if (nums[start] < nums[start + 1]) {
                break;
            }
        }
        
        // nums is the last permutation (decending), return the first permutation which is the ascending order of the array.
        if (start == -1) {
            reverse(nums, 0);
            return;
        }
        
        // Step2.
        int index2 = nums.length - 1;
        while (index2 >= 0 && nums[index2] <= nums[start]) {
            index2--;
        }
        
        // Step3.
        swap(nums, start, index2);
        
        // Step4.
        reverse(nums, start + 1);
    }
    
    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
    
    private void reverse(int[] nums, int index1) {
        int front = index1;
        int end = nums.length - 1;
        while (front < end) {
            swap(nums, front, end);
            front++;
            end--;
        }
    }  
}





