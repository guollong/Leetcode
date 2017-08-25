/**
 * Question description: Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 * 
 * Example: Given "25525511135", return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 *
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: 暂时无.
 */

/**
 * Progress...
 * Create Date: 08/24/2017
 */

// Solution 1: 3-layer for loop.
class Solution {
    // Idea: partition the ip address string into 4 parts using 3 indices, check the validation of each string, 
    //      if all 4 parts are valid, add the valid ip address to the result.
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        int length = s.length();
        
        for (int i = 1; i < 4 && i < length - 2; i++) { // i is the first partition point.
            for (int j = i + 1; j < i + 4 && j < length - 1; j++) { // j is the second partition point.
                for (int k = j + 1; k < j + 4 && k < length; k++) { // k is the third partition point.
                    String s1 = s.substring(0, i);
                    String s2 = s.substring(i, j);
                    String s3 = s.substring(j, k);
                    String s4 = s.substring(k);
                    if (isValid(s1) && isValid(s2) && isValid(s3) && isValid(s4)) {
                        result.add(s1 + '.' + s2 + '.' + s3 + '.' + s4);
                    }
                }
            }
        }
        return result;
    }

    private boolean isValid(String s) {
        if (s.length() > 3 || (s.charAt(0) == '0' && s.length() > 1) || Integer.parseInt(s) > 255) {
            return false;
        }
        return true;
    }
}


// Solution 2: DFS (Backtracking). Figure it out latter.




