/**
 * Question description: A strobogrammatic number is a number that looks the same when rotated 180 degrees 
 *		(looked at upside down). Find all strobogrammatic numbers that are of length = n.
 * 
 * Example: Given n = 2, return ["11","69","88","96"].
 *
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: Google.
 */

/**
 * Progress...
 * Create Date: 09/03/2017
 */

// Recursion.
class Solution {
    public List<String> findStrobogrammatic(int n) {
        return helper(n, n);
    }
    
    private List<String> helper(int n, int m) {
        // base case.
        if (n == 0) {
            return new ArrayList<String>(Arrays.asList(""));
        }
        if (n == 1) {
            return new ArrayList<String>(Arrays.asList("0", "1", "8"));
        }
        
        // recursive case.
        List<String> list = helper(n - 2, m);
        List<String> result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            // Only the beginning could not have '0'.
            if (n != m) {
                result.add("0" + s + "0");
            }
            result.add("1" + s + "1");
            result.add("6" + s + "9");
            result.add("8" + s + "8");
            result.add("9" + s + "6");
        }
        
        return result;
    }
}


