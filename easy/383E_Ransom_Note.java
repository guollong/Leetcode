/**
 * Question description: Given an arbitrary ransom note string and another string containing letters 
 * 		from all the magazines, write a function that will return true if the ransom note can be constructed 
 * 		from the magazines ; otherwise, it will return false.
 * Notes: Each letter in the magazine string can only be used once in your ransom note.
 *
 * Example:
 * 		canConstruct("a", "b") -> false
 * 		canConstruct("aa", "ab") -> false
 * 		canConstruct("aa", "aab") -> true
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; Company: .
 * Date: 03/13/2017
 */

// 剖析题意：可否用magazine里的元素构建字符串ransomNote（ransom：赎金）
// Solution from discussion. 用长度为26的数组记录每个字母出现的次数。
public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int lengthR = ransomNote.length();
        int lengthM = magazine.length();
        int[] array = new int[26];
        for (int i = 0; i < lengthM; i++) {
            array[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < lengthR; i++) {
            int count = array[ransomNote.charAt(i) - 'a']--;
            if (count - 1 < 0) {
                return false;
            }
        }
        return true;
    }
}

// My solution: 用map来记录每个字母出现的次数。
public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int lengthR = ransomNote.length();
        int lengthM = magazine.length();
        
        Map<Character, Integer> mapM = new HashMap<>();

        for (int i = 0; i < lengthM; i++) {
            int count = mapM.getOrDefault(magazine.charAt(i), 0) + 1;
            mapM.put(magazine.charAt(i), count);
        }
        for (int i = 0; i < lengthR; i++) {
            Character key = ransomNote.charAt(i);
            if (mapM.containsKey(key)) {
                if (mapM.get(key) == 1) {
                    mapM.remove(key);
                } else {
                    mapM.put(key, mapM.get(key) - 1);
                }
            } else {
                return false;
            }
        }
        return true;
    }
}



