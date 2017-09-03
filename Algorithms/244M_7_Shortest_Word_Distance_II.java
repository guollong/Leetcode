/**
 * Question: Design a class which receives a list of words in the constructor, and implements a method 
 *      that takes two words word1 and word2 and return the shortest distance between these two words in the list.
 * 
 * Example: words = ["practice", "makes", "perfect", "coding", "makes"].
 *      Given word1 = “coding”, word2 = “practice”, return 3.
 *      Given word1 = "makes", word2 = "coding", return 1.
 * 
 * Note: You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: Linkedin.
 */

/**
 * Progress...
 * Create Date: 02/02/2017
 * Update Date: 09/03/2017
 */

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */

class WordDistance {
    private Map<String, List<Integer>> indices;
    
    public WordDistance(String[] words) {
        indices = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (indices.containsKey(words[i])) {
                indices.get(words[i]).add(i);
            } else {
                List<Integer> index = new ArrayList<>();
                index.add(i);
                indices.put(words[i], index);
            }
        }
    }
    
    public int shortest(String word1, String word2) {
        int minDistance = Integer.MAX_VALUE;
        List<Integer> list1 = indices.get(word1);
        List<Integer> list2 = indices.get(word2);
        for (int index1 : list1) {
            for (int index2 : list2) {
                minDistance = Math.min(minDistance, Math.abs(index1 - index2));
            }
        }
        return minDistance;
    }
}

