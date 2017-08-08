/**
 * Question description: You are a product manager and currently leading a team to develop a new product. 
 * 		Unfortunately, the latest version of your product fails the quality check. Since each version is
 *		developed based on the previous version, all the versions after a bad version are also bad.
 * 
 * 		Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which 
 *		causes all the following ones to be bad.
 * 
 * 		You are given an API bool isBadVersion(version) which will return whether version is bad. 
 *		Implement a function to find the first bad version. You should minimize the number of calls to the API.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; 
 * Company: Facebook.
 */

/**
 * Progress...
 * Create Date: 06/08/2017
 */

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

// We want to find the first bad version, so we need to keep the bad version always in the search list.
//		I handle this by setting the end to "mid" when it is a bad version.      
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int front = 1;
        int end = n;
        int mid = 0;
        while (front < end) {
            mid = front + (end - front) / 2;
            if (isBadVersion(mid)) {
                end = mid;
            } else {
                front = mid + 1;
            }
        }
        return front;
    }
}



