/**
 * Question description: Given an array of integers, find if the array contains any duplicates. 
 *			Your function should return true if any value appears at least twice in the array.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; 
 * Company: Palantir, Airbnb, Yahoo.
 * Date: 03/25/2017
 */

// Although the running time complexity is O(nlogn), it is quicker than hashmap method.
public class Solution {
    public boolean containsDuplicate(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return false;
        }
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return true;
            }
        }
        return false;
    }
}

// Approach 2: HashMap. 
public class Solution {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return true;
            } else {
                map.put(nums[i], 1);
            }
        }
        return false;
    }
}

