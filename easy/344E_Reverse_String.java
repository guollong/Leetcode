/**
 * Question description: Write a function that takes a string as input and returns the string reversed.
 * 		Example: Given s = "hello", return "olleh".
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; Company: .
 * Date: 02/24/2017
 */

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

// Improved method from discussion.
// convert the string to a char array, and then exchange head and tail(two pointers: front and back).
public class Solution {
    public String reverseString(String s) {
        char[] charArray = s.toCharArray();
        int front = 0;
        int back = s.length() - 1;
        while (front < back) {
            char temp = charArray[front];
            charArray[front] = charArray[back];
            charArray[back] = temp;
            front++;
            back--;
        }
        return new String(charArray);
    }
}

