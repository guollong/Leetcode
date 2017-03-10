/**
 * Question description: Given scores of N athletes, find their relative ranks and the people with the top three highest scores, 
 * 			who will be awarded medals: "Gold Medal", "Silver Medal" and "Bronze Medal".
 * Example: Input: [5, 4, 3, 2, 1]
 * 			Output: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; Company: .
 * Date: 03/09/2017
 */

// Jinglong's solution.
// Notes: Don't need to write sort algorithm by ourselves, just use the sort method in API.
// 		  Java should make a deep copy for getting a new same array.

public class Solution {
    public String[] findRelativeRanks(int[] nums) {
        
        int length = nums.length;
        String[] result = new String[length];
        Map<Integer, Integer> map = new HashMap<>();
        
        int[] tempArray = nums.clone(); 
        Arrays.sort(nums);
        
        // put the score and rank into a map for quick search.
        for (int i = 0; i < length; i++) {
            map.put(nums[i], length - i);
        }
        
        for (int i = 0; i < tempArray.length; i++) {
            int rank = map.get(tempArray[i]);
            if (rank == 1) {
                result[i] = "Gold Medal";
            } else if (rank == 2) {
                result[i] = "Silver Medal";
            } else if (rank == 3) {
                result[i] = "Bronze Medal";
            } else {
                result[i] = rank + "";
            }
        }
        return result;
    }
}