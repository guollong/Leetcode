/**
 * Question description: Write a function that takes a string as input and returns the string reversed.
 * 		Example: Given s = "hello", return "olleh".
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; 
 * Company: 暂时无.
 * Date: 02/24/2017
 */

// Approach 1: Initialize a stringbuilder with argument s, and use the reverse method in the
//      StringBuilder class to reverse the string.
public class Solution {
    public String reverseString(String s) {
        StringBuilder res = new StringBuilder(s);
        return res.reverse().toString();
    }
}

// Approach 2: Convert the string to a char array, and then exchange head and tail(two pointers: front and back).
public class Solution {
    public String reverseString(String s) {
        char[] charArray = s.toCharArray();
        int front = 0;
        int back = s.length() - 1;
        while (front < back) {
            char temp = charArray[front];
            charArray[front++] = charArray[back];
            charArray[back--] = temp;
        }
        return new String(charArray);
    }
}

// Jinglong的超时解法。
// Implement a stack with linkedlist and pop to a stringbuilder.
public class Solution {
    public String reverseString(String s) {
        List<Character> reverse = new LinkedList<Character>();
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            reverse.add(0, s.charAt(i));
        }
        for (int i = 0; i < reverse.size(); i++) {
            output.append(reverse.get(i));
        }
        return output.toString();
    }
}
