/**
 * Question description: Given a pattern and a string str, find if str follows the same pattern.
 * 		Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.
 * Examples:
 *		pattern = "abba", str = "dog cat cat dog" should return true.
 *		pattern = "abba", str = "dog cat cat fish" should return false.
 *		pattern = "aaaa", str = "dog cat cat dog" should return false.
 *		pattern = "abba", str = "dog dog dog dog" should return false.
 *
 * Notes: You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; 
 * Company: Dropbox, Uber.
 */

/**
 * Progress...
 * Create Date: 06/10/2017
 */

// Solution 1: Use 2 hashmap, check corresponding relation from pattern to string and from string to pattern.
// 		Certain key(char) in the pattern must relates to certain string. So does from the string to pattern.
public class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] substring = str.split(" ");
        if (substring.length != pattern.length()) {
            return false;
        }
        Map<Character, String> mapPatternToStr = new HashMap<>();
        Map<String, Character> mapStrToPattern = new HashMap<>();
        
        for (int i = 0; i < pattern.length(); i++) {
            char temp = pattern.charAt(i);
            if (mapPatternToStr.containsKey(temp)) {
                if (!substring[i].equals(mapPatternToStr.get(temp))) {
                    return false;
                }
            } else {
                mapPatternToStr.put(temp, substring[i]);
            }
            
            if (mapStrToPattern.containsKey(substring[i])) {
                if (pattern.charAt(i) != mapStrToPattern.get(substring[i])) {
                    return false;
                }
            } else {
                mapStrToPattern.put(substring[i], pattern.charAt(i));
            }
        }
        return true;
    }
}

// Solution 2: 1 hashmap (pattern as keys and str as values). If the key is in the map, return false when
//      the value is not the value in the map. If the key is not in the map, return false when the map contains
//      this value, else put key and value in the map.
public class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] arrayStr = str.split("\\s+");
        if (pattern.length() != arrayStr.length) {
            return false;
        }
        Map<Character, String> map = new HashMap<>();
        for(int i = 0 ; i < pattern.length(); i++){
            char key = pattern.charAt(i);
            String value = arrayStr[i];
            if (map.containsKey(key)){
                if (!map.get(key).equals(value)) {
                    return false;
                }
            } else {
                if (map.containsValue(value)) {
                    return false;
                } else {
                    map.put(key, value);
                }
            }
        }
        return true;
    }
}

// Solution 3: 2 hashmap built from the pattern and string, storing the key and indices(list).
// 		Then loop over the pattern, comparing two list getting from string and pattern.
public class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] substring = str.split(" ");
        if (substring.length != pattern.length()) {
            return false;
        }
        Map<String, List<Integer>> patternMap = new HashMap<>();
        Map<String, List<Integer>> strMap = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            String tempKey1 = pattern.charAt(i) + "";
            List<Integer> list;
            if (patternMap.containsKey(tempKey1)) {
                list = patternMap.get(tempKey1);
            } else {
                list = new ArrayList<>();
            }
            list.add(i);
            patternMap.put(tempKey1, list);

            String tempKey2 = substring[i];
            if (strMap.containsKey(tempKey2)) {
                list = strMap.get(tempKey2);
            } else {
                list = new ArrayList<>();
            }
            list.add(i);
            strMap.put(tempKey2, list);
        }
        
        for (int i = 0; i < substring.length; i++) {
            List<Integer> list1 = patternMap.get(pattern.charAt(i) + "");
            List<Integer> list2 = strMap.get(substring[i]);
            if (!list1.equals(list2)) {
                return false;
            }
        }
        return true;
    }
}





