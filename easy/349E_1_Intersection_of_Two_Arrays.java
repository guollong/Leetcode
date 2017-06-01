/*************************************************************************
	> Function: Given two arrays, write a function to compute their intersection.
    > 
    > Example:  Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
    >
	> Author: Jinglong Guo
	> Created Time: Sun Dec 18 19:59:27 2016
 ************************************************************************/

/**
 * Difficulty: Easy; 
 * Company: Two Sigma.
 */

/**
 * Approach 1: two hashsets (running time complexity: O(n))
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

/** (The fact is this one is more effective than approach 1.)
 * Approach 2: Sort and compare (Running time complexity: O(nlogn))
 * Notes: We sometimes store the result in a list and need to convert it to the array.
 * 	e.g. String[] result = list.toArray(new String[list.size()]);
 * 	However, this only works for arrays of reference types. For arrays of primitive
 *	types, use the traditional way.
 */
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int pointer1 = 0;
        int pointer2 = 0;
        while (pointer1 < nums1.length && pointer2 < nums2.length) {
            if (nums1[pointer1] < nums2[pointer2]) {
                pointer1++;
            } else if (nums1[pointer1] > nums2[pointer2]) {
                pointer2++;
            } else {
                set.add(nums1[pointer1]);
                pointer1++;
                pointer2++;
            }
        }
	   
        int[] result = new int[set.size()];
        int index = 0;
        for (Integer element : set) {
            result[index++] = element;
        }
        return result;
    }
}
















