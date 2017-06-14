/*************************************************************************
	> Function: Given an array of integers, return indices of the two numbers 
    > such that they add up to a specific target.
    > 
    > Example:  Given nums = [2, 7, 11, 15], target = 9,
                Because nums[0] + nums[1] = 2 + 7 = 9,
                return [0, 1].
    >
	> Author: Jinglong Guo
	> Company: LinkedIn, Uber, Airbnb, Facebook, Amazon, Microsoft, Apple, Yahoo
	>	   Dropbox, Bloomberg, Yelp, Adobe.
	> Create date: 12/18/2017
	> Update date: 06/14/2017
 ************************************************************************/

/**
 * Approach #1 (Brute Force) 
 * running time complexity: O(n^2)
 * jinglong's method. 
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }                        
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}

/**
 * Approach #2 (Two-pass Hash Table)
 * running time complexity: O(n)
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        // put the elements in array in the map.
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        // check if the other element is in the map. Searching an element in hashtable takes 
        // amortized O(1) time.
        for (int j = 0; j < nums.length; j++) {
            int temp = target - nums[j];
            if (map.containsKey(temp) && map.get(temp) != j) {
                return new int[] {j, map.get(temp)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}

/**
 * Approach #2 (One-pass Hash Table)
 * running time complexity: O(n)
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (map.containsKey(temp)) {
                return new int[] {map.get(temp), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}

