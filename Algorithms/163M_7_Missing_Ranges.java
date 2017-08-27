/**
 * Question description: Given a sorted integer array where the range of elements are in the inclusive range 
 *		[lower, upper], return its missing ranges.
 * 
 * Example, given [0, 1, 3, 50, 75], lower = 0 and upper = 99, return ["2", "4->49", "51->74", "76->99"].
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: Google. 
 */

/**
 * Progress...
 * Create Date: 08/26/2017
 */

class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();
        
        // The next number we need to find.
        int next = lower;
        
        for (int i = 0; i < nums.length; i++) {
            // Duplicates.
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] < next) {
                continue;
            }
            if (nums[i] == next) {
                next++;
                continue;
            }
            
            result.add(formRange(next, nums[i] - 1));
            next = nums[i] + 1;
        }
        
        // Attention the overflow of integer.
        if ((next != Integer.MIN_VALUE || nums.length == 0) && next <= upper) {
            result.add(formRange(next, upper));
        }
        
        return result;
    }
    
    private String formRange(int number1, int number2) {
        if (number1 == number2) {
            return "" + number1;
        }
        return number1 + "->" + number2;
    }
}



