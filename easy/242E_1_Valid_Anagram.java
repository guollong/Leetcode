/**
 * Question description: Given two strings s and t, write a function to determine if t is an anagram of s.
 * 		"anagram" defination: A word or phrase that is created by rearranging the letters of another word or phrase.
 * Example: s = "anagram", t = "nagaram", return true.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; 
 * Company: .
 * Date: 03/25/2017
 */

// 通常的解题思路有3种：sort完逐一比较，hashmap统计频率，还有用alphabet统计频率（只适用于string，用来统计character出现的频率，并且效率最高）
// 好像还有一种规律：直接操作array比用hashmap效率高。

// Approach 1: Alphabet-length array record frequencies of characters.
public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] alphabet = new int[26]; 
        for (int i = 0; i< s.length(); i++) {
            alphabet[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i< t.length(); i++) {
            if (alphabet[t.charAt(i) - 'a'] == 0) {
                return false;
            } else {
                alphabet[t.charAt(i) - 'a']--;
            }
        }
        return true;
    }
}

// Approach 2: Arrays.sort(nums) and then loop arrays.
public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        Arrays.sort(sArray);
        Arrays.sort(tArray);
        for (int i = 0; i< s.length(); i++) {
            if (sArray[i] != tArray[i]) {
                return false;
            }
        }
        return true;
    }
}

// Approach 3: HashMap (省略)


