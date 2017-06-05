/**
 * Question description: Given an integer (signed 32 bits), write a function to check whether it is a power of 4.
 * 
 * Example: Given num = 16, return true. Given num = 5, return false.
 *
 * Follow up: Could you solve it without loops/recursion?
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; 
 * Company: .
 * Create Date: 04/03/2017
 * Update date: 06/05/2017
 */

// Iteration.
public class Solution {
    public boolean isPowerOfFour(int num) {
        if (num == 0) {
            return false;
        }
        while ((num & 3) == 0) {
            num >>>= 2;
        }
        return num == 1;
    }
}

// Recursion.
public class Solution {
    public boolean isPowerOfFour(int num) {
        // base case.
        if (num == 1) {
            return true;
        }
        if (num == 0 || (num & 3) != 0) {
            return false;
        }
        // recursive case.
        return isPowerOfFour(num >>> 2);
    }
}

// Idea: It's easy to find that power of 4 numbers have those 3 common features.
//      1. greater than 0.
//      2. only have one '1' bit in their binary notation,so we use x & (x-1) to delete the lowest '1',
//         and if then it becomes 0,it prove that there is only one '1' bit.
//      3. Third,the only '1' bit should be locate at the odd location,for example,16.It's binary is 
//         00010000.So we can use '0x55555555' to check if the '1' bit is in the right place.

// Solution1 without loop and recursion.
public class Solution {
    // If N is a power of 4: X == floor((log N) / (log 4))
    public boolean isPowerOfFour(int n) {
        return n == 0 ? false : n == Math.pow(4, Math.floor(Math.log(n) / Math.log(4)));
    }
}

// Solution2 without loop and recursion.
public class Solution {
    public boolean isPowerOfFour(int num) {
        return num > 0 && (num & (num - 1)) == 0 && (num & 0x55555555) != 0;
        // 0x55555555 is to get rid of those power of 2 but not power of 4, so that the 
        //      single 1 bit always appears at the odd position.
    }
}

// Solution3 without loop and recursion: change number to quaternary and then check if it starts with "10".
public class Solution {
    public boolean isPowerOfFour(int num) {
        return Integer.toString(num, 4).matches("10*");
    }
}



