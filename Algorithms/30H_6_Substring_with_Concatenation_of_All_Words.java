/**
 * Question description: You are given a string, s, and a list of words, words, that are all of the same length. 
 *		Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once 
 *		and without any intervening characters.
 * 
 * Example, given: s: "barfoothefoobarman", words: ["foo", "bar"]
 * 
 * You should return the indices: [0,9]. (order does not matter).
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Hard; 
 * Company: 暂时不明.
 */

/**
 * Progress...
 * Create Date: 08/22/2017
 */

// Solution 1: Two maps: Precompute the template map (toFind). For each substring, get another map (found) to 
// 		see if it is the same as the template map.
class Solution {

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        // corner case.
        if (s == null || words == null) {
            return null;
        }
        if (s.length() == 0 || words.length == 0) {
            return result;
        }
        
        // Template map.
        HashMap<String, Integer> toFind = new HashMap<>();
        // Compute the frequencies of each words in the substring to see if two maps are the same.
        HashMap<String, Integer> found = new HashMap<>();
        
        int size = words.length;            // number of words.
        int wordLen = words[0].length();    // length of each word.
        int totalLen = size * wordLen;      // length of permutation.

        // Build the template map.
        for (int i = 0; i < size; i++) {
            toFind.put(words[i], toFind.getOrDefault(words[i], 0) + 1);
        }
        
        for (int i = 0; i <= s.length() - totalLen; i++) {
            found.clear();
            int j;
            for (j = 0; j < size; j++) {
                int k = i + j * wordLen;
                String sub = s.substring(k, k + wordLen);
                if (!toFind.containsKey(sub)) {
                    break;
                }
                found.put(sub, found.getOrDefault(sub, 0) + 1);
                if (found.get(sub) > toFind.get(sub)) {
                    break;
                }
            }
            if (j == size) {
                result.add(i);
            }
        }
        return result;
    }
}


// Solution 2: brute force algorithm. Time limit exceeded.
// Find the permuation of all indices of words array, build string and find the indices in string s.
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        
        // Find the permuation string of the words array.
        List<List<String>> permutation = permuteUnique(words);
        
        // Build permutation string from list and find the indices in string s.
        for (int i = 0; i < permutation.size(); i++) {
            List<String> list = permutation.get(i);
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < list.size(); j++) {
                sb.append(list.get(j));
            }
            
            List<Integer> index = strStr(s, sb.toString());
            result.addAll(index);
        }
        
        return result;
    }
    
    private List<List<String>> permuteUnique(String[] words) {
        Arrays.sort(words);
        List<List<String>> result = new ArrayList<>();
        int[] visited = new int[words.length];
        permuteUniqueHelper(result, words, new ArrayList<>(), visited);
        return result;
    }
    
    private void permuteUniqueHelper(List<List<String>> result, String[] words, List<String> list, int[] visited) {
        if (list.size() == words.length) {
            result.add(new ArrayList<String>(list));
            return;
        }
        for (int i = 0; i < words.length; i++) {
            if (visited[i] == 1 || (i != 0 && words[i].equals(words[i - 1]) && visited[i - 1] == 1)) {
                continue;
            }
            visited[i] = 1;
            list.add(words[i]);
            permuteUniqueHelper(result, words, list, visited);
            list.remove(list.size() - 1);
            visited[i] = 0;
        }
    }
    
    public List<Integer> strStr(String s, String sub) {
        List<Integer> result = new ArrayList<>();
        int index = s.indexOf(sub, 0);
        while (index >= 0) {
            result.add(index);
            if (index + 1 >= s.length()) {
                break;
            }
            index = s.indexOf(sub, index + 1);
        }
        return result;
    }
}




