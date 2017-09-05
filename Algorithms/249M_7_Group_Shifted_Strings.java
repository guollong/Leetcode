/**
 * Question description: Given a string, we can "shift" each of its letter to its successive letter, for example: "abc" -> "bcd". 
 *		We can keep "shifting" which forms the sequence: "abc" -> "bcd" -> ... -> "xyz". Given a list of strings which contains 
 *		only lowercase alphabets, group all strings that belong to the same shifting sequence.
 *
 * Example, given: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"], 
 * A solution is:
 *	[
 *	  ["abc","bcd","xyz"],
 *	  ["az","ba"],
 *	  ["acef"],
 *	  ["a","z"]
 *	]
 *
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: Google, Uber.
 */

/**
 * Progress...
 * Create Date: 09/04/2017
 */

// Solution 1: The same idea as the question (group anagrams)
// The same shifting sequence with the same length have the same sequence after substracting offset.
public class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> result = new ArrayList<List<String>>();
         
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strings) {
            int offset = str.charAt(0) - 'a';
            String key = "";
            for (int i = 0; i < str.length(); i++) {
                char c = (char) (str.charAt(i) - offset);
                if (c < 'a') {
                    c += 26;
                }
                key += c;
            }
            if (!map.containsKey(key)) {
                List<String> list = new ArrayList<String>();
                map.put(key, list);
            }
            map.get(key).add(str);
        }
        
        // Add all lists in which all elements have the same shifting sequence to the result.
        for (List<String> list : map.values()) {
            result.add(list);
        }
        return result;
    }
}

// Solution 2: My original solution. (More effecient)
// 		Step1: Put all strings with the same length together (Map: key: length; value: list of strings with the same length).
// 		Step2: Group all strings with length i that belong to the same shifting sequence.
class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> result = new LinkedList<>();
        
        // put all strings with the same length together.
        Map<Integer, List<String>> map = new HashMap<>();
        for (int i = 0; i < strings.length; i++) {
            int length = strings[i].length();
            if (map.containsKey(length)) {
                map.get(length).add(strings[i]);
            } else {
                List<String> list = new ArrayList<>();
                list.add(strings[i]);
                map.put(length, list);
            }
        }
        
        for (List<String> list : map.values()) {
            // Group all strings with length i that belong to the same shifting sequence.
            while (list.size() > 0) {
                List<String> sublist = new ArrayList<>();
                String template = list.get(0);
                sublist.add(list.get(0));
                list.remove(0);
                int index = 0;
                while (index < list.size()) {
                    if (isShift(template, list.get(index))) {
                        sublist.add(list.get(index));
                        list.remove(index);
                        index--;
                    }
                    index++;
                }
                result.add(sublist);
            }
        }
        return result;
    }
    
    private boolean isShift(String s1, String s2) {
        for (int i = 1; i < s2.length(); i++) {
            int dist1 = s2.charAt(i) - s2.charAt(i - 1);
            int dist2 = s1.charAt(i) - s1.charAt(i - 1);
            dist1 = dist1 < 0 ? dist1 + 26 : dist1;
            dist2 = dist2 < 0 ? dist2 + 26 : dist2;
            if (dist1 != dist2) {
                return false;
            } 
        }
        return true;
    }
}


