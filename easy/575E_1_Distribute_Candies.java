/**
 * Question description: Given an integer array with even length, where different numbers
 *		in this array represent different kinds of candies. Each number means one candy 
 *		of the corresponding kind. You need to distribute these candies equally in number 
 *		to brother and sister. Return the maximum number of kinds of candies the sister could gain.
 *
 * Example: candies = [1,1,2,2,3,3]; Output: 3
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; 
 * Company: .
 */

/**
 * Progress...
 * Create Date: 06/01/2017
 */

public class Solution {
    public int distributeCandies(int[] candies) {
        Set<Integer> uniqueCandies = new HashSet<Integer>();
        for (int i = 0; i < candies.length; i++) {
            uniqueCandies.add(candies[i]);
        }
        return uniqueCandies.size() > candies.length / 2 ? candies.length / 2 : uniqueCandies.size();
    }
}
