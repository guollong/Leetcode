/**
 * Question description: Given two strings s and t, write a function to determine if t is an anagram of s.
 * 		"anagram" defination: A word or phrase that is created by rearranging the letters of another word or phrase.
 * Example: s = "anagram", t = "nagaram", return true.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; Company: .
 * Date: 03/25/2017
 */

// 和169题（majority element）类似。
// 直接操作array比用hashmap效率高。
public class Solution {
    public boolean isAnagram(String s, String t) {
        char[] array1 = s.toCharArray();
        char[] array2 = t.toCharArray();
        Arrays.sort(array1);
        Arrays.sort(array2);
        if (array1.length != array2.length) {
            return false;
        }
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] != array2[i]) {
                return false;
            }
        }
        return true;
    }
}