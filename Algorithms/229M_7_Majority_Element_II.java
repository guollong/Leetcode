/**
 * Question description: Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times. 
 *		The algorithm should run in linear time and in O(1) space.
 *
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: Zenefits.
 */

/**
 * Progress...
 * Create Date: 09/01/2017
 */

// Boyer-Moore Algorithm.
// Idea: Find the first two elements that appears most often in the array and check if their occurance are more than len / 3.
//      Since we need to find the element that appears more than [len / 3], the result will return one or two elements. 
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
    
        // Find the first two elements that appears most often in the array.
        int count1 = 0;
        int count2 = 0;
        int candidate1 = nums[0];
        int candidate2 = nums[0];
        for (int element : nums) {
            if (element == candidate1) {
                count1++;
            } else if (element == candidate2) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = element;
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = element;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }
        
        // Check if their occurance are more than len / 3.
        count1 = 0;
        count2 = 0;
        for (int element : nums) {
            if (element == candidate1) {
                count1++;
            } else if (element == candidate2) {
                count2++;
            }
        }
        if (count1 > nums.length / 3) {
            result.add(candidate1);
        }
        if (count2 > nums.length / 3) {
            result.add(candidate2);
        }
        return result;
    }
}



