/*************************************************************************
	> Function: Given two arrays, write a function to compute their intersection.
    > 
    > Example:  Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
    >
	> Author: Jinglong Guo
	> Created Time: Sun Dec 18 19:59:27 2016
 ************************************************************************/

/**
 * running time complexity: O(n)
 * jinglong's method. 
 */
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> num1 = new HashSet<Integer>();
        Set<Integer> resultSet = new HashSet<Integer>();
        
        for (int i = 0; i < nums1.length; i++) {
            num1.add(nums1[i]);
        }
        for (int j = 0; j < nums2.length; j++) {
            if (num1.contains(nums2[j])) {
                resultSet.add(nums2[j]);
            }
        }
        int[] result = new int[resultSet.size()];
        int k = 0;
        for (int value : resultSet) {
            result[k++] = value;
        }
        return result;
    }
}

/**
 * running time complexity: O(nlogn) (take the time complexity of the sort method)
 * one of the methods. 
 */
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                set.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] result = new int[set.size()];
        int k = 0;
        for (Integer num : set) {
            result[k++] = num;
        }
        return result;
    }
}
















