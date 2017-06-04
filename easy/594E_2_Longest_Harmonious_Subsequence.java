/**
 * Question description: We define a harmonious array is an array where the difference between 
 *		its maximum value and its minimum value is exactly 1.
 * 
 * 		Now, given an integer array, you need to find the length of its longest harmonious subsequence
 *		among all its possible subsequences.
 * 
 * Example: Input: [1,3,2,2,5,2,3,7]; Output: 5
 * 		Explanation: The longest harmonious subsequence is [3,2,2,2,3].
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; 
 * Company: LiveRamp.
 */

/**
 * Progress...
 * Create Date: 06/03/2017
 */

// Hashmap.
public class Solution {
    public int findLHS(int[] nums) {
        int longest = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        for (int element : map.keySet()) {
            if (map.containsKey(element + 1)) {
                longest = Math.max(longest, map.get(element) + map.get(element + 1));
            }
        }
        return longest;
    }
}

// Two pointers. (先sort) (貌似two pointer方法总是比hashmap方法快)
public class Solution {
    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        int j = 0;
        int max = 0;
        while(j < nums.length) {
            int diff = nums[j] - nums[i];
            if(diff == 1) {
                j++;
                if(j - i > max) {
                    max = j - i;
                }
            } else if (diff > 1) {
                i++;
            } else {
                j++;
            }
        }
        return max;
    }
}




