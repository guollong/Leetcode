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
 * Difficulty: Easy; 
 * Company: Apple.
 * Date: 03/13/2017
 */

// 3种方法：sort and compare, hashmap, and alphabet array.

// Approach 1: Sort and compare. (2nd)
public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        char[] ransomArray = ransomNote.toCharArray();
        char[] magazineArray = magazine.toCharArray();
        Arrays.sort(ransomArray);
        Arrays.sort(magazineArray);
        int pointer1 = 0;
        int pointer2 = 0;
        while (pointer1 < ransomNote.length() && pointer2 < magazine.length()) {
            if (ransomArray[pointer1] == magazineArray[pointer2]) {
                pointer1++;
                pointer2++;
            } else {
                pointer2++;
            }
        }
        if (pointer1 == ransomNote.length()) {
            return true;
        }
        return false;
    }
}

// Approach 2: alphabet array. (1st)
public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        // alphbet array, length = 26.
        int[] magazineArray = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            magazineArray[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if (--magazineArray[ransomNote.charAt(i) - 'a'] < 0) {
                return false;
            } 
        }
        return true;
    }
}

// Approach 3: hashmap (3rd)
public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> mapMagazine = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            char temp = magazine.charAt(i);
            if (mapMagazine.containsKey(temp)) {
                mapMagazine.put(temp, mapMagazine.get(temp) + 1);
            } else {
                mapMagazine.put(temp, 1);
            }
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            char temp = ransomNote.charAt(i);
            if (!mapMagazine.containsKey(temp)) {
                return false;
            }
            int frequency = mapMagazine.get(temp);
            if (frequency == 1) {
                mapMagazine.remove(temp);
            } else {
                mapMagazine.put(temp, mapMagazine.get(temp) - 1);
            }
        }
        return true;
    }
}



