/**
 * Question description: You have a total of n coins that you want to form in a staircase shape, 
 *		where every k-th row must have exactly k coins.
 * Given n, find the total number of full staircase rows that can be formed.
 * n is a non-negative integer and fits within the range of a 32-bit signed integer.
 *
 * Example1: n = 5
 * The coins can form the following rows:
 * 	¤
 * 	¤ ¤
 * 	¤ ¤
 * Because the 3rd row is incomplete, we return 2.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; Company: .
 * Date: 04/05/2017
 */

// 数学方法。
public class Solution {
    public int arrangeCoins(int n) {
        return (int) ((Math.sqrt(1 + 8.0 * n) - 1) / 2);
    }
}

// binary search. Always thinking about the binary search method. 
// 还是尽量不使用除法，可以将其变为乘法或者移位运算。
public class Solution {
    public int arrangeCoins(int n) {
        int start = 0;
        int end = n;
        int mid = 0;
        while (start <= end){
            mid = (start + end) >>> 1;
            if ((0.5 * mid * mid + 0.5 * mid ) <= n){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return start - 1;
    }
}


