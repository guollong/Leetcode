/**
 * Question description: Given an array of integers, find out whether there are two distinct indices i and j in the 
 *		array such that the absolute difference between nums[i] and nums[j] is at most t and the absolute difference 
 *		between i and j is at most k.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: Palantir, Airbnb.
 */

/**
 * Progress...
 * Create Date: 08/09/2017
 * Update Date: 08/31/2017
 */

// Solution 1: Balanced binary search tree. (TreeSet)
// Idea: Always keep k elements in the treeset, for each element, get the ceil which is the smallest value greater
//      than the current element and the floor which is the largest value less than the current element, check 
//      if they are within the range of t around the current element.
// Running time complexity: O(n * logk).
public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Integer ceil = set.ceiling(nums[i]);
            // Be careful not to exceed the range.
            if (ceil != null && ceil <= t + nums[i]) {
                return true;
            }

            // Be careful not to exceed the range.
            Integer floor = set.floor(nums[i]);
            if (floor != null && nums[i] <= t + floor) {
                return true;
            }
            set.add(nums[i]);
            if (i >= k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }
}

// Solution 2: Using bucket. (inspired by bucket sort)
// Each bucket could only have one element, so we use hashmap to keep this, the key is the id of the bucket.
// Use bucket to store the ceil and floor of the current element.
public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (t < 0 || k <= 0) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int id = getID(nums[i], t + 1);
            // check the current bucket.
            if (map.containsKey(id)) {
                return true;
            }
            // check the left bucket.
            if (map.containsKey(id - 1) && map.get(id - 1) + t >= nums[i]) {
                return true;
            }
            // check the right bucket.
            if (map.containsKey(id + 1) && map.get(id + 1) - t <= nums[i]) {
                return true;
            }
            map.put(id, nums[i]);
            if (i >= k) {
                map.remove(getID(nums[i - k], t + 1));
            }
        }
        return false;
    }
    
    // Get the ID of the bucket from the element x and bucket width k.
    private int getID(int x, int width) {
        // 如果x小于0，问了保证bucket的连贯，id=(x + 1) / width - 1；
        return x < 0 ? (x + 1) / width - 1 : x / width;
    }
}



