/**
 * Question description: Given a string and an integer k, you need to reverse the first k characters for every 2k characters counting 
 * 		from the start of the string. If there are less than k characters left, reverse all of them. If there are less than 2k but 
 *		greater than or equal to k characters, then reverse the first k characters and left the other as original.
 * Example:
 *  	Input: s = "abcdefg", k = 2; Output: "bacdfeg"
 * Restrictions:
 *      The string consists of lower English letters only.
 * 		Length of the given string and k will in the range [1, 10000]
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; 
 * Company: Google.
 * Date: 03/26/2017
 */

// Approach 1: Convert s to an char array, invert the element inside the array, 
//      finally convert the char array back to string. 
public class Solution {
    public String reverseStr(String s, int k) {
        char[] arrayS = s.toCharArray();
        int startPosition = 0;
        while (startPosition < s.length()) {
            int end = Math.min(startPosition + k - 1, s.length() - 1);
            swap(arrayS, startPosition, end);
            startPosition += 2 * k;
        }
        return String.valueOf(arrayS);
    }
    
    private void swap(char[] arr, int start, int end) {
        int count = (end - start + 1 ) / 2;
        for (int i = 0; i < count; i++) {
            char temp = arr[start + i];
            arr[start + i] = arr[end - i];
            arr[end - i] = temp;
        }
    }
}

// Approach 2: recursive method.
public class Solution {
    StringBuilder output = new StringBuilder();
    public String reverseStr(String s, int k) {
        int length = s.length();
        // take the min value of k and length, reverse them.
        int end = Math.min(length, k);
        StringBuilder tempString = new StringBuilder();
        tempString.append(s.substring(0, end));
        output.append(tempString.reverse().toString());
        
        // if the length is smaller than k, return.
        if (length <= k) {
            return output.toString();
        } else if (length > k && length <= 2 * k){
            // if the length is between k and 2k, append the left string.
            output.append(s.substring(k, length));
            return output.toString();
        } else {
            // if the length is greater than 2k, recursively call the method.
            output.append(s.substring(k, 2 * k));
            return reverseStr(s.substring(2 * k, length), k);
        }
    }
}


