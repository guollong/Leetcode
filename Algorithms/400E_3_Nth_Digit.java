/**
 * Question description: Find the nth digit of the infinite integer sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...
 * 
 * Example 1: Input: 3; Output: 3
 * Example 2: Input: 11; Output: 0; Explanation: The 11th digit of the sequence is a 0, which is part of the number 10.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; 
 * Company: Google.
 */

/**
 * Progress...
 * Create Date: 06/10/2017
 */

// Straight forward way to solve the problem in 3 steps:
// 	1>. find the length of the number where the nth digit is from
//	2>. find the actual number where the nth digit is from
// 	3>. find the nth digit and return
public class Solution {
	public int findNthDigit(int n) {
		int len = 1;
		long count = 9;

		while (n > len * count) {
			n -= len * count;
			len++;
			count *= 10;
		}
		
        int start = (int) count;
		start += (n - 1) / len;
		String s = Integer.toString(start);
		return (int) (s.charAt((n - 1) % len) - '0');
	}
}



