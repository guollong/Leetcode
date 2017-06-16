/**
 * Question description: In LLP world, there is a hero called Teemo and his attacking 
 * can make his enemy Ashe be in poisoned condition. Now, given the Teemo's attacking 
 * ascending time series towards Ashe and the poisoning time duration per Teemo's attacking, 
 * you need to output the total time that Ashe is in poisoned condition.
 *
 * You may assume that Teemo attacks at the very beginning of a specific time point, and makes Ashe be in poisoned condition immediately.
 * Example:
 * 		Input: [1,4], 2; Output: 4
 * 		Input: [1,2], 2; Output: 3
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; Company: .
 * Date: 03/10/2017
 */

// 加法的效率比乘法的效率要高。并且要注意判断corner case。
public class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int sum = 0;
        int length = timeSeries.length;
        if (length == 0) {
            return 0;
        }
        for (int i = 0; i < length - 1; i++) {
            int duraTemp = timeSeries[i + 1] - timeSeries[i];
            if (duraTemp < duration) {
                sum += duraTemp;
            } else {
                sum += duration;
            }
        }
        return sum + duration;
    }
}