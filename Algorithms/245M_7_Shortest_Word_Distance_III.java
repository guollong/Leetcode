/**
 * Question description: This is a follow up of Shortest Word Distance. The only difference is now word1 could 
 *		be the same as word2. Given a list of words and two words word1 and word2, return the shortest distance 
 *		between these two words in the list.
 * 
 * word1 and word2 may be the same and they represent two individual words in the list.
 * 
 * Example: Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
 *		Given word1 = “makes”, word2 = “coding”, return 1.
 *		Given word1 = "makes", word2 = "makes", return 3.
 * 
 * Note: You may assume word1 and word2 are both in the list.
 *
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: .
 */

/**
 * Progress...
 * Create Date: 09/03/2017
 */

// Solution 1: modify from the first question of this series of questions.
class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int index1 = -1;
        int index2 = -1;
        int minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                if (word1.equals(word2) && index1 != -1) {
                    minDistance = Math.min(minDistance, Math.abs(i - index1));
                } else if (index2 != -1) {
                    minDistance = Math.min(minDistance, Math.abs(i - index2));
                }
                index1 = i;
            } else if (words[i].equals(word2)) {
                if (index1 != -1) {
                    minDistance = Math.min(minDistance, Math.abs(index1 - i));
                }
                index2 = i;
            }

        }
        return minDistance;
    }
}

// Simpler version of solution 1:
class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int index = -1;
        int minDistance = words.length;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1) || words[i].equals(word2)) {
                if (index != -1 && (word1.equals(word2) || !words[index].equals(words[i]))) {
                    minDistance = Math.min(minDistance, i - index);
                }
                index = i;
            }
        }
        return minDistance;
    }
}


// Solution 2: modify from the second question of this series of questions.
class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        // put all indices into a map.
        Map<String, List<Integer>> indices = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (indices.containsKey(words[i])) {
                indices.get(words[i]).add(i);
            } else {
                List<Integer> index = new ArrayList<>();
                index.add(i);
                indices.put(words[i], index);
            }
        }
        
        // find the minDistance.
        int minDistance = Integer.MAX_VALUE;
        List<Integer> list1 = indices.get(word1);
        List<Integer> list2 = indices.get(word2);
        for (int index1 : list1) {
            for (int index2 : list2) {
                if (index1 != index2) {
                    minDistance = Math.min(minDistance, Math.abs(index1 - index2));
                }
            }
        }
        return minDistance;
    }
}
    
