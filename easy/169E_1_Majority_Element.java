/**
 * Question description: Given an array of size n, find the majority element. 
 * 		The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 *		You may assume that the array is non-empty and the majority element always exist in the array.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; 
 * Company: .
 * Date: 03/25/2017
 * Update date: 05/31/2017
 */

// Approach 1: Boyer–Moore majority vote algorithm. It is an algorithm for finding 
//      the majority of a sequence of elements using linear time and constant space.
public class Solution{
    public int majorityElement(int[] nums) {
        int count = 0, returnValue = 0;
        for (int num : nums) {
            if (count == 0)
                returnValue = num;
            if (num != returnValue)
                count--;
            else
                count++;
        }
        return returnValue;
    }
}

// Approach 2: sort and take the middle element(it must be the majority element.)
public class Solution{
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}

// Approach 3: complicated than approach 2, after sort, it compute the frequencies of 
//      elements and take the element where the frequency is largest.
// This code works for finding the most popular element.
public class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int count = 1;
        int maxCount = Integer.MIN_VALUE;
        int majorEle = nums[0];
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                count++;
                if (count > maxCount) {
                    maxCount = count;
                    majorEle = nums[i];
                }
            } else {
                count = 1;
            }
        }
        return majorEle;
    }
}

// Approach 4: use hashmap recording the value and frequency of numbers.
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
