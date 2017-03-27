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
 * Difficulty: Easy; Company: .
 * Date: 03/26/2017
 */

// first sort and use two pointers to find their intersection.
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

