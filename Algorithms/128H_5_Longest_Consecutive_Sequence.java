/**
 * Question description: Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 * 
 * Example: Given [100, 4, 200, 1, 3, 2], The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
 * 
 * Notes: Your algorithm should run in O(n) complexity.
 *
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Hard; 
 * Company: Google, Facebook.
 */

/**
 * Progress...
 * Create Date: 07/28/2017
 */

// Solution 1: Using hashset, two passes, store elements in the set and update the length of longest consecutive sequence 
//		while looping over all elements.

// Idea: Put all elements into a set. Loop over all elements, if the element is the start of a sequence 
//       ("element - 1") is not in the set, test whether x+1, x+2, x+3.... are in the set, find the right
//       boundary of the consecutive sequence and update the length of the longest consecutive sequence.
public class Solution {
    public int longestConsecutive(int[] nums) {
        int result = 0;
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }
        for (int n : nums) {
            // The element is a start of a sequence.
            if (!set.contains(n - 1)) {
                int start = n;
                int length = 1;
                while (set.contains(start + 1)) {
                    start++;
                    length++;
                }
                result = Math.max(result, length);
            }
        }
        return result;
    }
}

// Solution 2: nine chapter algorithm solution. Similiar to solution 1.
public class Solution {
    public int longestConsecutive(int[] nums) {
        int result = 0;
        Set<Integer> set = new HashSet<>();
        for (int element : nums) {
            set.add(element);
        }
        
        int pre = 0;
        int next = 0;

        for (int element : nums) {
            if (set.contains(element)) {
                set.remove(element);
                pre = element - 1;
                next = element + 1;
                while (set.contains(pre)) {
                    set.remove(pre);
                    pre--;
                }
                while (set.contains(next)) {
                    set.remove(next);
                    next++;
                }
                result = Math.max(result, next - pre - 1);
            }
        }
        return result;
    }
}

// Solution 3: Using hashmap, one pass, store the length of the longest consecutive sequence in the boundary of the sequence and
//		keep track of the longest length.
public class Solution {
    public int longestConsecutive(int[] nums) {
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();

        int left = 0;
        int right = 0;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                left = map.containsKey(nums[i] - 1) ? map.get(nums[i] - 1) : 0;
                right = map.containsKey(nums[i] + 1) ? map.get(nums[i] + 1) : 0;
                sum = left + right + 1;
                
                // The value of this intermediate key doesn't matter, we only need to guarantee that this element is in the map.
                // So we could also put 0 to this intermediate key.
                map.put(nums[i], sum);
                
                // update the length of the consecutive sequence in the boundary points of the sequence.
                map.put(nums[i] - left, sum);
                map.put(nums[i] + right, sum);
                
                // keep track of the length of the longest consecutive sequence.
                result = Math.max(result, sum);
            }
        }
        return result;
    }
}

// Solution 4: Union-find solution.
// Not figure it out.




