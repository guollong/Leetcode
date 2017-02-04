/**
 * Question: Design a class which receives a list of words in the constructor, and implements a method 
 * that takes two words word1 and word2 and return the shortest distance between these two words in the list.
 * For example, Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
 * Given word1 = “coding”, word2 = “practice”, return 3.
 * Given word1 = "makes", word2 = "coding", return 1.
 * Note: You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
 */

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */


/**
 * Author: Jinglong Guo
 * Difficulty: Easy; Company: Linkedin.
 * Date: 02/02/2017
 * Notes: should take duplicate into consideration. We couldn't directly assign String[] words to an array because 
 * that may causes amortized cost. It is much faster to store them in a map.
 */

public class WordDistance {
    
    private Map<String, List<Integer>> map;
    public WordDistance(String[] words) {
        map = new HashMap<String, List<Integer>>();
        for (int i = 0; i< words.length; i++) {
            if (!map.containsKey(words[i])) {
                List<Integer> list = new ArrayList<Integer>();
                list.add(i);
                map.put(words[i], list);
            } else {
                map.get(words[i]).add(i);
            }
        }
    }
    
    public int shortest(String word1, String word2) {
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);
        int min = Integer.MAX_VALUE;
        for (Integer i : list1) {
            for (Integer j : list2) {
                if (Math.abs(i - j) < min) {
                    min = Math.abs(i - j);
                }
            }
        }
        return min;
    }
}