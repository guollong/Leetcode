/**
 * Question description: Count the number of segments in a string, where a segment is defined to be a contiguous sequence of non-space characters.
 * Please note that the string does not contain any non-printable characters.
 * 
 * Example: Input: "Hello, my name is John"; Output: 5
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; 
 * Company: 暂时无.
 * Create Date: 04/03/2017
 * Update date: 06/05/2017
 */

// Solution1: using split method in String class.
public class Solution {
    public int countSegments(String s) {
        String sTrim = s.trim();
        if (sTrim.equals("")) {
            return 0;
        }
        String[] sArray = sTrim.split("\\s+");
        return sArray.length;
    }
}

// Solution2: Use for loop to check each element.
public class Solution {
    public int countSegments(String s) {
        int res = 0;
        for(int i = 0; i < s.length(); i++)
            if (s.charAt(i) != ' ' && (i == 0 || s.charAt(i-1) == ' '))
                res++;        
        return res;
    }
}

