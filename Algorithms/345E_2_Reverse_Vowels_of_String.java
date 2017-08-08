/**
 * Question description: Write a function that takes a string as input and reverse only the vowels of a string.
 *
 * Example 1: Given s = "hello", return "holle".
 * Example 2: Given s = "leetcode", return "leotcede". list.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; 
 * Company: Google.
 * Create Date: 04/03/2017
 * Update date: 06/05/2017
 */

// Two pointers method.
public class Solution {
    public String reverseVowels(String s) {
        int index1 = 0;
        int index2 = s.length() - 1;
        String vowels = "aeiouAEIOU";
        char[] result = s.toCharArray();
        
        while (index1 < index2) {
            while (index1 < index2 && !vowels.contains(result[index1] + "")) {
                index1++;
            }
            while (index1 < index2 && !vowels.contains(result[index2] + "")) {
                index2--; 
            }
            Character temp = result[index1];
            result[index1] = result[index2];
            result[index2] = temp;
            index1++;   // don't forget increase the index, otherwise, it will go into infinity loop.
            index2--;
        }
        return new String(result);
    }
}
