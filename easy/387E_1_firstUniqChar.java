/*************************************************************************
    > Function: Given a string, find the first non-repeating character in it 
    > and return it's index. If it doesn't exist, return -1.
    > 
    > Example:  s = "leetcode", return 0.
    >           s = "loveleetcode", return 2.
    >
    > Author: Jinglong Guo
    > Created Time: Sun Dec 18 19:59:27 2016
 ************************************************************************/

// 3种方法：sort and compare, hashmap, and alphabet array.

// Approach 1: Sort and compare. (2nd)

// Approach 2: alphabet array. (1st)
public class Solution {
    public int firstUniqChar(String s) {
        int length = s.length();
        int[] alphabet = new int[26];
        for (int i = 0; i < length; i++) {
            char temp = s.charAt(i);
            alphabet[temp - 'a']++;
        }
        for (int i = 0; i < length; i++) {
            char temp = s.charAt(i);
            if (alphabet[temp - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}

// Approach 3: hashmap. (3rd)
public class Solution {
    public int firstUniqChar(String s) {
        int length = s.length();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            char temp = s.charAt(i);
            if (map.containsKey(temp)) {
                map.put(temp, map.get(temp) + 1);
            } else {
                map.put(temp, 1);
            }
        }
        for (int i = 0; i < length; i++) {
            char temp = s.charAt(i);
            if (map.containsKey(temp)) {
                if (map.get(temp) == 1) {
                    return i;
                }
            }
        }
        return -1;
    }
}

