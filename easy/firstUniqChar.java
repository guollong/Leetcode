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

/**
 * running time complexity: O(n)
 * jinglong's method. 
 */
public class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            Integer frequency = map.get(s.charAt(i));
            if (frequency == null) {
                frequency = 1;
            } else {
                frequency++;
            }
            map.put(s.charAt(i), frequency);
        }
        for (int j = 0; j < s.length(); j++) {
            if (map.get(s.charAt(j)) == 1) {
                return j;
            }
        }
        return -1;
    }
}