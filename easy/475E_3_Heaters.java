/**
 * Question description: Winter is coming! Your first job during the contest is to design a 
 *		standard heater with fixed warm radius to warm all the houses.
 * 
 * 		Now, you are given positions of houses and heaters on a horizontal line, find out 
 *		minimum radius of heaters so that all houses could be covered by those heaters.
 *
 *		So, your input will be the positions of houses and heaters seperately, and your 
 *		expected output will be the minimum radius standard of heaters.
 * 
 * Example: Input: [1,2,3],[2]; Output: 1
 *          Input: [1,2,3,4],[1,4]; Output: 1
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; 
 * Company: .
 */

/**
 * Progress...
 * Create Date: 06/15/2017
 */

// Solution1: Two pointers. (Always requires the array to be sorted.)
public class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        
        int i = 0; 
        int result = 0;
        for (int house : houses) {
            while (i < heaters.length - 1 && Math.abs(heaters[i + 1] - house) <= Math.abs(heaters[i] - house)) {
                i++;
            }
            result = Math.max(result, Math.abs(heaters[i] - house));
        }
        return result;
    }
}


// Solution 2: 
// The idea is to leverage decent Arrays.binarySearch() function provided by Java.
// For each house, find its position between those heaters (Arrays.binarySearch(int[] nums, int key)).
// Calculate the distances between this house and left heater and right heater, get a MIN value of those two values. Corner cases are there is no left or right heater.
// Get MAX value among distances in step 2. It's the answer.
public class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int result = Integer.MIN_VALUE;
        
        for (int house : houses) {
            // Arrays.binarySearch(int[] nums, int key): This method returns index of the 
            // search key if it is contained in the array, else it returns (-(insertion point) - 1).
            int index = Arrays.binarySearch(heaters, house);
            if (index < 0) {
                index = -(index + 1);
            }
            // Calculate the distances between this house and left heater and right heater. 
            // Corner case: no left heater or no right heater.
            int dist1 = index - 1 >= 0 ? house - heaters[index - 1] : Integer.MAX_VALUE;
            int dist2 = index < heaters.length ? heaters[index] - house : Integer.MAX_VALUE;
            
            result = Math.max(result, Math.min(dist1, dist2));
        }
        return result;
    }
}






