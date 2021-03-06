/**
 * Question description: Given an array with n objects colored red, white or blue, sort them so that 
 *		objects of the same color are adjacent, with the colors in the order red, white and blue.
 * 
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 * 
 * Note: You are not suppose to use the library's sort function for this problem.
 * 
 * Follow up: 
 *  A rather straight forward solution is a two-pass algorithm using counting sort.
 *		Could you come up with an one-pass algorithm using only constant space?
 *  Sort more colors ??
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: Pocket Gems, Microsoft, Facebook.
 */

/**
 * Progress...
 * Create Date: 07/12/2017
 * Update Date: 08/03/2017
 */

// Two pass: Get the number of 0s, 1s and 2s in the first pass and update the array in the second pass.
public class Solution {
    public void sortColors(int[] nums) {
        int num1 = 0;
        int num2 = 0;
        int num3 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                num1++;
            } else if (nums[i] == 1) {
                num2++;
            } else {
                num3++;
            }
        }
        int start = 0;
        for (int i = 0; i < num1; i++) {
            nums[start++] = 0;
        }
        for (int i = 0; i < num2; i++) {
            nums[start++] = 1;
        }
        for (int i = 0; i < num3; i++) {
            nums[start++] = 2;
        }
    }
}

// One pass: sort the array in place.
public class Solution {
    public void sortColors(int[] nums) {
        int length = nums.length;
        int front = 0;
        int end = length - 1;
        // Please attention the end condition.
        for (int i = 0; i <= end; i++) {
            if (nums[i] == 0) {
                swap(nums, i, front);
                front++;
            } else if (nums[i] == 2) {
                swap(nums, i, end);
                end--;
                // It is possible to change another 2 to the position i, so we need to substract i by 1
                // to check this position again.
                i--;
            }
        }
    }

    private void swap(int[] nums, int index1, int index2) {
    	int temp = nums[index1];
    	nums[index1] = nums[index2];
    	nums[index2] = temp;
    }
}

// Follow up: Sort four colors.
public class Solution {
    
    private int indexFront;
    private int indexRear;
    
    public void sortColors(int[] nums) {
        indexFront = 0;
        indexRear = nums.length - 1;
        int n = 4;
        for (int i = 0; i < n / 2; i++) {
            sortColorsHelper(nums, i, n - i - 1);
            indexFront++;
            indexRear--;
        }
    }
    
    private void sortColorsHelper(int[] nums, int value1, int value2) {
        // Move all value1's to the front of the array and move all value2's to the end of the array.
        for (int i = indexFront; i <= indexRear; i++) {
            if (nums[i] == value1) {
                swap(nums, i, indexFront);
                indexFront++;
            } else if (nums[i] == value2) {
                swap(nums, i, indexRear);
                indexRear--;
                i--;
            }
        }
    }
    
    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}




