/**
 * Question description: Compare two version numbers version1 and version2.
 * 		If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.
 * 
 * You may assume that the version strings are non-empty and contain only digits and the . character.
 * 		The . character does not represent a decimal point and is used to separate number sequences.
 *		For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level 
 *		revision of the second first-level revision.
 * 
 * Here is an example of version numbers ordering: 0.1 < 1.1 < 1.2 < 13.37
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: Microsoft, Apple. 
 */

/**
 * Progress...
 * Create Date: 08/24/2017
 */

class Solution {
    public int compareVersion(String version1, String version2) {
        String[] versionNum1 = version1.split("\\.");
        String[] versionNum2 = version2.split("\\.");
        
        int length1 = versionNum1.length;
        int length2 = versionNum2.length;
        int length = Math.max(length1, length2);
        
        for (int i = 0; i < length; i++) {
            int number1 = i < length1 ? Integer.parseInt(versionNum1[i]) : 0;
            int number2 = i < length2 ? Integer.parseInt(versionNum2[i]) : 0;
            int compare = number1.compareTo(number2);
            if (compare != 0) {
                return compare;
            }
        }
        return 0;
    }
}


