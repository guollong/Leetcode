/**
 * Given a positive integer num, write a function which returns True if num is a perfect square else False.
 * Note: Do not use any built-in library function such as sqrt.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; Company: Linkedin.
 * Date: 02/06/2017
 * Notes: In this problem, I think the binary search is the best solution.
 */

// improved solution2: Binary search(O(logn))
public class Solution {
    public boolean isPerfectSquare(int num) {
        int low = 1, high = num;
        while (low <= high) {
            long mid = (low + high) >>> 1;
            if (mid * mid == num) {
                return true;
            } else if(mid * mid < num) {
                low = (int)mid + 1;
            } else {
                high = (int)mid - 1;
            }
        }
        return false;
    }
}

// Improved solution: A square number is 1+3+5+7+...
// Notes: cannot use sum equals to num. Time limited exceeded.
public class Solution {
    public boolean isPerfectSquare(int num) {
        int i = 1;
        while(num > 0) {
            num -= i;
            i = i + 2;
        }
        return num == 0;
    }
}

// My own solution. 
public class Solution {
    public boolean isPerfectSquare(int num) {
        if (num < 0) {
            return false;
        }
        if (num == 0 || num == 1) {
            return true;
        }
        for (int i = 1; i <= num / 2; i++) {
            if (i * i == num) {
                return true;
            }
        }
        return false;
    }
}