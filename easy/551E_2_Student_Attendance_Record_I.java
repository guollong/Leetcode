/**
 * Question description: You are given a string representing an attendance record for a student. 
 *		The record only contains the following three characters: 'A' : Absent; 'L' : Late; 'P' : Present.
 * 
 *		A student could be rewarded if his attendance record doesn't contain more than one 'A' (absent)
 *		or more than two continuous 'L' (late).
 *
 *		You need to return whether the student could be rewarded according to his attendance record.
 *
 * Example: Input: "PPALLP", Output: True;
 *			Input: "PPALLL", Output: False;
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; 
 * Company: Google.
 */

/**
 * Progress...
 * Create Date: 06/01/2017
 */

public class Solution {
    public boolean checkRecord(String s) {
        int absentCount = 0;
        int lateCount = 0;
        char[] sArray = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
        	// count the number of absent days.
            if (sArray[i] == 'A') {
                absentCount++;
            }

            // count the number of continous late days.
            if (sArray[i] == 'L') {
                lateCount++;
            } else {
                lateCount = 0;
            }
            if (absentCount >= 2 || lateCount >= 3) {
                return false;
            }
        }
        return true;
    }
}
