/**
 * Question description: Given two strings s and t, determine if they are isomorphic.
 * 		Two strings are isomorphic if the characters in s can be replaced to get t.
 * 		All occurrences of a character must be replaced with another character while preserving the 
 *		order of characters. No two characters may map to the same character but a character may map to itself.
 *
 * Example: Given "egg", "add", return true.
 *			Given "foo", "bar", return false.
 *			Given "paper", "title", return true.
 * Note: You may assume both s and t have the same length.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; 
 * Company: LinkedIn.
 */

/**
 * Progress...
 * Create Date: 06/11/2017
 */

// Solution 1: Use array to store the position of last occurance.
public class Solution {
    public boolean isIsomorphic(String s, String t) {
        // arrays are not used to record the frequency of characters. But store the position of last occurance.
        // so "array1[index1]++; array2[index2]++;" is not correct.
        int[] array1 = new int[256];
        int[] array2 = new int[256];
        for (int i = 0; i < s.length(); i++) {
            int index1 = (int) s.charAt(i);
            int index2 = (int) t.charAt(i);
            if (array1[index1] != array2[index2]) {
                return false;
            }
            array1[index1] = i + 1;
            array2[index2] = i + 1;
        }
        return true;
    }
}


// Solution 2: 1 hashmap (pattern as keys and str as values). If the key is in the map, return false when
//      the value is not the value in the map. If the key is not in the map, return false when the map contains
//      this value, else put key and value in the map.
public class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        for(int i = 0 ; i < s.length(); i++){
            char a = s.charAt(i);
            char b = t.charAt(i);
            if (map.containsKey(a)){
                if (map.get(a) != b) {
                    return false;
                }
            } else {
                if (map.containsValue(b)) {
                    return false;
                } else {
                    map.put(a, b);
                }
            }
        }
        return true;
    }
}


// Solution 3: 2 hashmaps (the same as the question 290(word pattern)). Check the responding relation with each other.
public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Character> mapStoT = new HashMap<>();
        Map<Character, Character> mapTtoS = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);
            if (!mapStoT.containsKey(charS)) {
                mapStoT.put(charS, charT);
            } else {
                if (charT != mapStoT.get(charS)) {
                    return false;
                }
            }
            
            if (!mapTtoS.containsKey(charT)) {
                mapTtoS.put(charT, charS);
            } else {
                if (charS != mapTtoS.get(charT)) {
                    return false;
                }
            }
        }
        return true;
    }
}




