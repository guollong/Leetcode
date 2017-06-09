/**
 * Question description: Given an array of integers and an integer k, you need to find the 
 *		number of unique k-diff pairs in the array. Here a k-diff pair is defined as an integer
 *		pair (i, j), where i and j are both numbers in the array and their absolute difference is k.
 *
 * Example 1: Input: [3, 1, 4, 1, 5], k = 2; Output: 2
 * 		Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5). Although we have 
 *				two 1s in the input, we should only return the number of unique pairs.
 * Example 2: Input: [1, 2, 3, 4, 5], k = 1; Output: 4
 * Example 3: Input: [1, 3, 1, 5, 4], k = 0; Output: 1
 *		Explanation: There is one 0-diff pair in the array, (1, 1).
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; 
 * Company: Amazon.
 */

/**
 * Progress...
 * Create Date: 06/09/2017
 */

// Two pointers. Sort first.
public class Solution {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                for (int j = i + 1; j < nums.length; j++) {
                    int diff = nums[j] - nums[i];
                    if (diff == k) {
                        count++;
                        break;
                    } else if (diff > k){
                        break;
                    }
                }
            }
        }
        return count;
    }
}

// Hashmap.
public class Solution {
    public int findPairs(int[] nums, int k) {
        if (k < 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (int element : map.keySet()) {
            if (k == 0) {
                if (map.get(element) >= 2) {
                    count++;
                }
            } else {
                if (map.containsKey(element + k)) {
                    count++;
                }
            }
        }
        return count;
    }
}



