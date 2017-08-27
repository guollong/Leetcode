/**
 * Question description: Given two strings S and T, determine if they are both one edit distance apart.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: Snapchat, Uber, Facebook, Twitter. 
 */

/**
 * Progress...
 * Create Date: 08/26/2017
 */

// Naive method: get the edit distance of two strings and see if it is 1. (Time Limit exceeded)

// Improved method taking use of the requirement that two strings are both have one edit distance apart.
// Two cases: 
//  1. Two strings have the same length: only one modification could be made.
//  2. One string has one character more than another string, in this case, only one insertion/deletion could be made.
class Solution {
    public boolean isOneEditDistance(String s, String t) {
        int length1 = s.length();
        int length2 = t.length();
        if (Math.abs(length1 - length2) >= 2) {
            return false;
        }
        
        String longer = length1 > length2 ? s : t;
        String shorter = length1 > length2 ? t : s;
        if (length1 == length2) {
            return isOneModified(longer, shorter);
        }
        return isOneDeleted(longer, shorter);
    }
    
    private boolean isOneModified(String longer, String shorter) {
        int count = 0;
        for (int i = 0; i < longer.length(); i++) {
            if (longer.charAt(i) != shorter.charAt(i)) {
                count++;
            }
        }
        return count == 1;
    }
    
    private boolean isOneDeleted(String longer, String shorter) {
        int index = 0;
        for (; index < shorter.length(); index++) {
            if (longer.charAt(index) != shorter.charAt(index)) {
                break;
            }
        }
        return longer.substring(index + 1).equals(shorter.substring(index));
    }
}

