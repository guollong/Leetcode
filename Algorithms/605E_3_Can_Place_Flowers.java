/**
 * Question description: Suppose you have a long flowerbed in which some of the plots 
 *		are planted and some are not. However, flowers cannot be planted in adjacent 
 *		plots - they would compete for water and both would die.
 *
 * 		Given a flowerbed (represented as an array containing 0 and 1, where 0 means 
 *		empty and 1 means not empty), and a number n, return if n new flowers can be 
 *		planted in it without violating the no-adjacent-flowers rule.
 *
 * Example 1: Input: flowerbed = [1,0,0,0,1], n = 1; Output: True
 * Example 2: Input: flowerbed = [1,0,0,0,1], n = 2; Output: False
 *
 */


/**
 * Author: Jinglong Guo
 * Difficulty: Easy; 
 * Company: LinkedIn.
 */

/**
 * Progress...
 * Create Date: 06/13/2017
 */

public class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int length = flowerbed.length;
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) && (i == length - 1 || flowerbed[i + 1] == 0)) {
                count++;
                i++;
            }
        }
        return count >= n;
    }
}




