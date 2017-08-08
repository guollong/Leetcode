/**
 * Question description: Given an input string, reverse the string word by word.
 * 
 * Example: Given s = "the sky is blue", return "blue is sky the".
 *
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: Microsoft, Snapchat, Apple, Bloomberg, Yelp.
 */

/**
 * Progress...
 * Create Date: 06/27/2017
 */

public class Solution {
    public String reverseWords(String s) {
        String[] sArray = s.trim().split("\\s+");
        int threshold = sArray.length / 2;
        StringBuilder result = new StringBuilder();
        for (int i = sArray.length - 1; i > 0; i--) {
            result.append(sArray[i] + " ");
        }
        result.append(sArray[0]);
        return result.toString();
    }
}


