/**
 * Question: Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.
 * For example, Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
 * Given word1 = “coding”, word2 = “practice”, return 3.
 * Given word1 = "makes", word2 = "coding", return 1.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; Company: Linkedin.
 * Date: 02/02/2017
 * Notes: should take duplicate into consideration.
 */

public class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        List<Integer> index1 = new ArrayList<Integer>();
        List<Integer> index2 = new ArrayList<Integer>();
        List<Integer> distance = new ArrayList<Integer>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                index1.add(i);
            }
            if (words[i].equals(word2)) {
                index2.add(i);
            }
        }
        for (Integer i : index1) {
            for (Integer j : index2) {
                distance.add(Math.abs(i - j));
            }
        }
        Collections.sort(distance);
        return distance.get(0);
    }
}

/**
 * Improvement: For each iteration, updates the index1 and index2, when the distance get 
 * 				smaller, assign the smaller value to the min value.
 */
public class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int index1 = -1, index2 = -1, min = Integer.MAX_VALUE;
        
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) 
                index1 = i;
    
            if (words[i].equals(word2)) 
                index2 = i;
                
            if (index1 != -1 && index2 != -1 && Math.abs(index1 - index2) < min)
                min = Math.abs(index1 - index2);
        }
        return min;
    }
}