/**
 * Question description: Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
 * 		The function twoSum should return indices of the two numbers
 * Note: You may assume that each input would have exactly one solution and you may not use the same element twice.
 *
 * Example: Input: numbers={2, 7, 11, 15}, target=9; Output: index1=1, index2=2
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; 
 * Company: .
 * Date: 03/11/2017
 * Update date: 05/31/2017
 */

// Two pointers: most effective.
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int length = numbers.length;
        int start = 0;
        int end = length - 1;
        while (start < end) {
            int addition = numbers[start] + numbers[end];
            if (addition == target) {
                break;
            }
            if (addition < target) {
                start = start + 1;
            } else {
                end = end - 1;
            }
        }
        return new int[]{start + 1, end + 1};
    }
}

// HashMap
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                return new int[]{map.get(target - numbers[i]) + 1, i + 1};
            }
            map.put(numbers[i], i);
        }
        return new int[]{};
    }
}


