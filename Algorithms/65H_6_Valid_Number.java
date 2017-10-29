/**
 * Question description: Validate if a given string is numeric.
 * 
 * Examples: "0" => true
 *           " 0.1 " => true
 *           "abc" => false
 *           "1 a" => false
 *           "2e10" => true
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Hard; 
 * Company: LinkedIn.
 */

/**
 * Progress...
 * Create Date: 08/21/2017
 * Update Date: 10/29/2017
 */

// Idea: (validation condition)
//  1. If we see [0-9] we reset the number flags.
//  2. We can only see . if we didn't see e or ..
//  3. We can only see e if we didn't see e but we did see a number. We reset numberAfterE flag.
//  4. We can only see + and - in the beginning and after an e
//  5. any other character break the validation.
class Solution {
    public boolean isNumber(String s) {
        s = s.trim();

        boolean pointSeen = false;
        boolean eSeen = false;
        boolean numberSeen = false;
        boolean numberAfterE = true;
        
        // '.' and 'e' could only appear at most once.
        // When there is an 'e' in the string, set numberAfterE to be false, later then, only we 
        // see a number, numberAfterE will be changed to true again.
        
        // The last character must be a number and numberAfterE must be true.
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if('0' <= c && c <= '9') {
                numberSeen = true;
                numberAfterE = true;
            } else if (c == '.') {
                if (eSeen || pointSeen) {
                    return false;
                }
                pointSeen = true;
            } else if (c == 'e') {
                if (eSeen || !numberSeen) {
                    return false;
                }
                numberAfterE = false;
                eSeen = true;
            } else if (c == '-' || c == '+') {
                if (i != 0 && s.charAt(i-1) != 'e') {
                    return false;
                }
            } else {
                return false;
            }
        }

        return numberSeen && numberAfterE;
    }
}





