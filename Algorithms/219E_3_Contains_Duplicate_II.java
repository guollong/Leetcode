/**
 * Question description: Given an array of integers and an integer k, find out whether 
 *		there are two distinct indices i and j in the array such that nums[i] = nums[j] 
 *		and the absolute difference between i and j is at most k.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; 
 * Company: Palatir, Aribnb.
 */

/**
 * Progress...
 * Create Date: 06/12/2017
 */

// Solution 1: Use hashmap to record the index of element.
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        
        Map<Integer, Integer> indices = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (indices.containsKey(nums[i])) {
                if (indices.get(nums[i]) + k >= i) {
                    return true;
                }
            }
            indices.put(nums[i], i);
        }
        return false;
    }
}

// Solution 2: Use hashset.
public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > k) {
                set.remove(nums[i - k - 1]);
            }
            if (!set.add(nums[i])) {
                return true;
            }
        }
        return false;
    }
}

