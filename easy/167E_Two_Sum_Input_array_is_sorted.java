/**
 * Question description: Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
 * 		The function twoSum should return indices of the two numbers
 * Note: You may assume that each input would have exactly one solution and you may not use the same element twice.
 *
 * Example: Input: numbers={2, 7, 11, 15}, target=9; Output: index1=1, index2=2
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; Company: .
 * Date: 03/11/2017
 */

// solution from discussion. (Use two pointers)
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

// my original solution. (use hashmap: not good)
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] index = new int[2];
        int length = numbers.length;
        for (int i = 0; i < length; i++) {
            int value = map.getOrDefault(numbers[i], 0) + 1;
            map.put(numbers[i], value);
        }
        int index1 = 0, value1 = 0, index2 = 0;
        for (index1 = 0; index1 < length; index1++) {
            value1 = numbers[index1];
            if (map.containsKey(target - value1)) {
                break;
            }
        }
        index[0] = index1 + 1;
        for (index1 = index1 + 1; index1 < length; index1++) {
            if (numbers[index1] == target - value1) {
                index2 = index1;
                break;
            }
        }
        index[1] = index2 + 1;
        return index;
    }
}


