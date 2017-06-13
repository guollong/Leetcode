/**
 * Question: Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.
 * For example, Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
 * Given word1 = “coding”, word2 = “practice”, return 3.
 * Given word1 = "makes", word2 = "coding", return 1.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; 
 * Company: Linkedin.
 * Create Date: 02/02/2017
 * Update date: 06/13/2017
 */

// Solution 1: Loop over the string array, update the min distance only when the indices are changed.
//      faster than next simpler version.
public class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int index1 = -1;
        int index2 = -1;
        int minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                index1 = i;
                if (index2 != -1 && minDistance > Math.abs(index1 - index2)) {
                    minDistance = Math.abs(index1 - index2);
                }
            }
            if (words[i].equals(word2)) {
                index2 = i;
                if (index1 != -1 && minDistance > Math.abs(index1 - index2)) {
                    minDistance = Math.abs(index1 - index2);
                }
            }
        }
        return minDistance;
    }
}

// Simpler version. 
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