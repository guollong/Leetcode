/**
 * Given a positive integer num, write a function which returns True if num is a perfect square else False.
 * Note: Do not use any built-in library function such as sqrt.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; 
 * Company: Linkedin.
 * Create Date: 02/06/2017
 * Update Date: 06/05/2017
 * Notes: In this problem, I think the binary search is the best solution.
 */

// My own solution. 
public class Solution {
    public boolean isPerfectSquare(int num) {
        if (num <= 0) {
            return false;
        }
        int number = (num + 1) / 2;
        while (number >= 1) {
            if (number * number == num) {
                return true;
            }
            number--;
        }
        return false;
    }
}

// Improved solution2: Binary search(O(logn))
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
