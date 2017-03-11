/**
 * Question description: Given a non negative integer number num. For every numbers i 
 * in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.
 * Example: For num = 5 you should return [0,1,1,2,1,2].
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; Company: .
 * Date: 03/10/2017
 */

// Integer class has several bit level methods, such as lowestOneBit(int i) and bitCount.
public class Solution {
    public int[] countBits(int num) {
        int[] result = new int[num + 1];
        for (int i  = 0; i <= num; i++) {
            result[i] = Integer.bitCount(i);
        }
        return result;
    }
}


