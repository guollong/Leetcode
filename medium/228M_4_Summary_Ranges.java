/**
 * Question description: Given a sorted integer array without duplicates, return the summary of its ranges.
 * 
 * Example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
 *
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: Google.
 */

/**
 * Progress...
 * Create Date: 06/27/2017
 */

public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }
        
        int start = nums[0];
        int end = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == 1) {
                end++;
            } else {
                if (start == end) {
                    result.add(start + "");
                } else {
                    result.add(start + "->" + end);
                }
                start = nums[i];
                end = start;
            }
        }
        if (start == end) {
            result.add(start + "");
        } else {
            result.add(start + "->" + end);
        }
        return result;
    }
}

