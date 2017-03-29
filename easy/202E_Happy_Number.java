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
 * Difficulty: Easy; Company: .
 * Date: 03/28/2017
 */

// To be a happy girl.
// 如果数字陷入无限循环中，则为false。为所有sum建立一个set，当有重复数字出现时，则返回false。
// HAPPY Number 最终返回的sum是1.
// set.add(element)-->如果element存在返回false，添加成功返回true；
public class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        int remainder, temp, sum;
        while (set.add(n)) {
            temp = n;
            sum = 0;
            while (temp > 0) {
                remainder = temp % 10;
                sum += remainder * remainder;
                temp = temp / 10;
            }
            if (sum == 1) {
                return true;
            } else {
                n = sum;
            }
        }
        return false;
    }
}





