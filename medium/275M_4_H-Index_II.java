/**
 * Question description: Follow up for H-Index: What if the citations array is sorted in 
 *		ascending order? Could you optimize your algorithm?
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: Google.
 */

/**
 * Progress...
 * Create Date: 06/27/2017
 */

// Binary search idea.
public class Solution {
    public int hIndex(int[] citations) {
        int length = citations.length;
        int left = 0;
        int right = length - 1;
        int mid = 0;
        
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (citations[mid] == (length - mid)) {
                return length - mid;
            } else if (citations[mid] > (length - mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return length - (right + 1);
    }
}



