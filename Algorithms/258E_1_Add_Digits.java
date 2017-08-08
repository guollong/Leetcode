/**
 * The digital root(also repeated digital sum) of a non-negative integer is the value obtained by an iterative process
 * of summing digits, on each iteration using the result from the previous iteration to compute a digit sum.
 * For example, the digital root of 65,536 is 7, because 6 + 5 + 5 + 3 + 6 = 25 and 2 + 5 = 7.
 */

/**
 * Question description: Calculate the digital root of one non-negative number.
 * Example: Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; 
 * Company: Adobe, Microsoft.
 * Date: 03/08/2017
 */

// Approach 1: O(1) method.
public class Solution {
    public int addDigits(int num) {
        return num - 9 * ((num - 1) / 9);
    }
}

// Approach 2: General recursive method.
public class Solution {
    public int addDigits(int num) {
        if (num < 10) {
            return num;
        }
        int count = 0;
        int temp = num;
        while (temp != 0) {
            count += temp % 10;
            temp = temp / 10;
        }
        return addDigits(count);
    }
}



