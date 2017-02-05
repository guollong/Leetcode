/**
 * Question description: Given two strings s and t, determine if they are isomorphic.
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * 
 * All occurrences of a character must be replaced with another character while preserving the order of characters. 
 * No two characters may map to the same character but a character may map to itself.
 * For example, Given "egg", "add", return true. Given "foo", "bar", return false. Given "paper", "title", return true.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; Company: Linkedin.
 * Date: 02/04/2017
 */

/**
 * Answer in discussion. 
 * Notes: Still not familiar with how to define an array in java. 
 *        For string, we could use a 256-length array to store the occurance of characters, or use hashmap.
 */
public class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] count1 = new int[256];
        int[] count2 = new int[256];
        char[] string1 = s.toCharArray();
        char[] string2 = t.toCharArray();
        int count = 1;
        for(int i = 0; i < s.length(); i++) {
            if(count1[string1[i]] != count2[string2[i]]) {
                return false;
            }
            if(count1[string1[i]] == 0) {
                count1[string1[i]] = count;
                count2[string2[i]] = count;
                count++;
            }
        }
        return true;
    }
}
















