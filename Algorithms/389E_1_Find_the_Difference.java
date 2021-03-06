/**
 * Question description: Given two strings s and t which consist of only lowercase letters.
 * 		String t is generated by random shuffling string s and then add one more letter at a random position.
 * 		Find the letter that was added in t. 
 */

// Example: 
// Input: s = "abcd"; t = "abcde"
// Output: e
// Explanation: 'e' is the letter that was added.

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; 
 * Company: Google.
 * Date: 03/02/2017
 */

// Approaches: sort and compare, bit manipulation(xor), Other approaches.

// Approach 1: bit manipulation(xor) (better solution)
// Similar to the question that finding the the single number
public class Solution {
    public char findTheDifference(String s, String t) {
        char res = t.charAt(t.length() - 1);
        for (int i = 0; i < s.length(); i++) {
            res ^= s.charAt(i);
            res ^= t.charAt(i);
        }
        return res;
    }
}

// Approach 2: sort and compare
public class Solution {
    public char findTheDifference(String s, String t) {
        char[] charS = s.toCharArray();
        char[] charT = t.toCharArray();
        Arrays.sort(charS);
        Arrays.sort(charT);
        int i = 0;
        for (i = 0; i < s.length(); i++) {
            if (charS[i] != charT[i]) {
                return charT[i];
            }
        }
        return charT[i];
    }
}

// Approach 3: ascii sum.
// Use for loop to sum the ascii of characters in original string.
public class Solution {
    public char findTheDifference(String s, String t) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i); 
            sum += (int) c;
        }
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i); 
            sum -= (int) c;
        }
        return (char) -sum;
    }
}

// Improved approach 3.
public class Solution {
    public char findTheDifference(String s, String t) {
        int sum = 0, j = 0, i = 0;
        char c_t = '\0';
        char c_s = '\0';
        for (; i < s.length();i++, j++) {
            c_s = s.charAt(i);
            c_t = t.charAt(j);
            sum += (int) c_s;
            sum -= (int) c_t;
        }
        sum -= t.charAt(j);
        return (char) -sum;
    }
}




