/**
 * Question description: Given an array of strings, group anagrams together.
 * 
 * Example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
 * Return:
 *	[
 *	  ["ate", "eat","tea"],
 *	  ["nat","tan"],
 *	  ["bat"]
 *	]
 * Note: All inputs will be in lower-case.
 *
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: Amazon, Bloomberg, Uber, Facebook, Yelp.
 */

/**
 * Progress...
 * Create Date: 08/23/2017
 */

// Accepted solution.
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // corner case.
        if (strs == null || strs.length == 0) {
            return new ArrayList<List<String>>();
        }

        // key: the sorted order of anagram. value: all anagrams of this sorted string.
        Map<String, List<String>> map = new HashMap<>();
        
        for (String s : strs) {
            char[] sArray = s.toCharArray();
            Arrays.sort(sArray);
            String keyStr = String.valueOf(sArray);
            if (!map.containsKey(keyStr)) {
                map.put(keyStr, new ArrayList<String>());
            }
            map.get(keyStr).add(s);
        }
        return new ArrayList<List<String>>(map.values());
    }
}

// Brute force solution. Time Limited exceeded.
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        
        // key: the first element of each list in result; value: the occurrances of this element.
        Map<String, Map<Character, Integer>> map = new HashMap<>();
        
        for (String s : strs) {
            int i;
            // check if the string is an anagram of some pervious strings.
            for (i = 0; i < result.size(); i++) {
                Map<Character, Integer> submap = map.get(result.get(i).get(0));
                if (isAnagram(s, submap)) {
                    result.get(i).add(s);
                    break;
                }
            }
            // If this element doesn't belong to any list in the result.
            if (i == result.size()) {
                List<String> newList = new ArrayList<>();
                newList.add(s);
                result.add(newList);
                // Build the occurance map.
                Map<Character, Integer> tempMap = new HashMap<>();
                for (char c : s.toCharArray()) {
                    tempMap.put(c, tempMap.getOrDefault(c, 0) + 1);
                }
                map.put(s, tempMap);
            }
        }
        return result;
    }
    
    private boolean isAnagram(String s, Map<Character, Integer> template) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        return map.equals(template);
    }
}


