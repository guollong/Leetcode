/**
 * Question description: Given two arrays, write a function to compute their intersection.
 *
 * Example: Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].
 *
 * Note: Each element in the result should appear as many times as it shows in both arrays.
 * 		 The result can be in any order.
 * Follow up: What if the given array is already sorted? How would you optimize your algorithm?
 * 		 What if nums1's size is small compared to nums2's size? Which algorithm is better?
 * 		 What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; 
 * Company: .
 * Date: 03/26/2017
 */

// Approach 1: Sort and compare. (The sort and compare method is always better than hashmap/hashset method)
public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list = new ArrayList<>();
        int index1 = 0, index2 = 0;
        while (index1 < nums1.length && index2 < nums2.length) {
            if (nums1[index1] == nums2[index2]) {
                list.add(nums1[index1]);
                index1++;
                index2++;
            } else if (nums1[index1] < nums2[index2]) {
                index1++;
            } else {
                index2++;
            }
        }
        int[] output = new int[list.size()];
        int index = 0;
        for (Integer i : list) {
            output[index++] = i;
        }
        return output;
    }
}

// Approach 2: HashMap
public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < nums1.length; i++) {
            if (map.containsKey(nums1[i])) {
                map.put(nums1[i], map.get(nums1[i]) + 1);
            } else {
                map.put(nums1[i], 1);
            }
        }
        for (int i = 0; i < nums2.length; i++) {
            if (map.containsKey(nums2[i])) {
                list.add(nums2[i]);
                if (map.get(nums2[i]) > 1) {
                    map.put(nums2[i], map.get(nums2[i]) - 1);
                } else {
                    map.remove(nums2[i]);
                }
            }
        }
        int[] result = new int[list.size()];
        int i = 0;
        for (int element : list) {
            result[i++] = element;
        }
        return result;
    }
}


