/**
 * Question description: Given an array of size n, find the majority element. 
 * 		The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 *		You may assume that the array is non-empty and the majority element always exist in the array.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; Company: .
 * Date: 03/25/2017
 */

// Approach 1: use hashmap recording the value and frequency of numbers.
// 		Then loop the map to get the majority element.
public class Solution {
    public int majorityElement(int[] nums) {
        int length = nums.length;
        int threshold = length / 2;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        int max = 0;
        int majority = 0;
        for (Integer key : map.keySet()) {
            int temp = map.get(key);
            if (temp > threshold && temp > max) {
                majority = key;
                max = temp;
            }
        }
        return majority;
    }
}

// Approach 2: First sort the array, loop over the sorted array to get the majority element.
// 通常情况下，直接操作array比用高级数据结构的效率要高。
public class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int count = 1;
        int majority = nums[0];
        int max = 0;
        int length = nums.length;
        for (int i = 1; i < length; i++) {
            if (nums[i] == nums[i - 1]) {
                count++;
                // if it is the last element in the array.
                if (i == length - 1) {
                    if (count > max) {
                        majority = nums[i];
                    }
                }
            } else {
                if (count > max) {
                    max = count;
                    majority = nums[i - 1];
                }
                count = 1;
            }
        }
        return majority;
    }
}