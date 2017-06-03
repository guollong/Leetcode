/**
 * Question description: Write an algorithm to determine if a number is "happy".
 * 		A happy number is a number defined by the following process: Starting with any positive integer, 
 *		replace the number by the sum of the squares of its digits, and repeat the process until the number 
 *		equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. 
 *		Those numbers for which this process ends in 1 are happy numbers.
 *
 * Example: 19 is a happy number
 *		1^2 + 9^2 = 82
 *		8^2 + 2^2 = 68
 *		6^2 + 8^2 = 100
 *		1^2 + 0^2 + 0^2 = 1
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; 
 * Company: Uber, Airbnb, Twitter.
 * Create Date: 03/28/2017
 * Update date: 06/02/2017
 */

public class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    public boolean isHappy(int n) {
        if (map.containsKey(n)) {
            return false;
        } else {
            map.put(n, 1);
        }
        int temp = n;
        int sum = 0;
        while (temp != 0) {
            int remainder = temp % 10;
            sum += remainder * remainder;
            temp = temp / 10;
        }
        if (sum == 1) {
            return true;
        }
        return isHappy(sum);
    }
}





