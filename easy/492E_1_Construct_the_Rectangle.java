/**
 * Question description: Given the area of a rectangle, get length and width with smallest difference.
 * 		Notes: width could be larger than legth.
 * Example: Input: 4; Output: [2, 2]
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; 
 * Company: .
 * Date: 03/09/2017
 */

public class Solution {
    public int[] constructRectangle(int area) {
        int startIndex = (int)Math.floor(Math.sqrt(area));
        while (startIndex > 0) {
            if (area % startIndex == 0) {
                return new int[]{area / startIndex, startIndex};
            }
            startIndex--;
        }
        return new int[]{};
    }
}
