/**
 * Question description: Count the number of prime numbers less than a non-negative number, n.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; 
 * Company: Bloomberg, Apple, Facebook.
 */

/**
 * Progress...
 * Create Date: 06/08/2017
 */

// My solution: Always think about what the start and end pointer should be and 
//		what is the stop critiria of the while loop.
public class Solution {
    public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }
        int start = 0;
        int end = x / 2;
        int mid = 0;
        while (start <= end) {
            mid = start + (end - start) / 2;
            int division = x / (mid + 1);
            if (division == (mid + 1)) {
                return mid + 1;
            } else if (division > (mid + 1)) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return end + 1;
    }
}

// Another solution from discussion.
public class Solution {
    public int mySqrt(int x) {
        if (x == 0)
            return 0;
        int left = 1, right = x / 2;
        while (true) {
            int mid = left + (right - left) / 2;
            if (mid > x / mid) {
                right = mid - 1;
            } else {
                if (mid + 1 > x / (mid + 1))
                    return mid;
                left = mid + 1;
            }
        }
    }
}