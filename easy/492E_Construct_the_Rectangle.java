/**
 * Question description: Given the area of a rectangle, get length and width with smallest difference.
 * 		Notes: width could be larger than legth.
 * Example: Input: 4; Output: [2, 2]
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; Company: .
 * Date: 03/09/2017
 */

public class Solution {
    public int[] constructRectangle(int area) {
        int threshold = (int)Math.sqrt(area);
        int[] result = new int[2];
        for (int i = threshold; i >= 1; i--) {
            int width = i;
            if (area % width == 0) {
                result[0] = area / width;
                result[1] = width;
                break;
            }
        }
        return result;
    }
}