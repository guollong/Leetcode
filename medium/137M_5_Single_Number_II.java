/**
 * Question description: Given an array of integers, every element appears three times except 
 *		for one, which appears exactly once. Find that single one.
 * 
 * Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * 
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: Palantir, Airbnb.
 */

/**
 * Progress...
 * Create Date: 07/09/2017
 */

// Bit manipulation.

// Solution 1.

// First time number appear -> save it in "ones"
// Second time -> clear "ones" but save it in "twos" for later check
// Third time -> try to save in "ones" but value saved in "twos" clear it.

// Initially, ones = 0, twos = 0;
// First time appearance: ones = number, twos = number & (~number) = 0;
// Second time appearance: ones = number ^ number = 0, twos = number;
// Third time appearance: ones = number & (~number) = 0, twos = 0;
// Note: a ^ -a = 0
public class Solution {
    public int singleNumber(int[] A) {
        int ones = 0, twos = 0;
        for (int i = 0; i < A.length; i++){
            ones = (ones ^ A[i]) & ~twos;
            twos = (twos ^ A[i]) & ~ones;
        }
        return ones;
    }
}


// Solution 2: finite state machine solution.
public class Solution {
    public int singleNumber(int[] A) {
        // Implement a three-time counter that if a bit appears three times, it will be zero.
        // #curent  income  ouput
        // # ab      c/c       ab/ab
        // # 00      1/0       01/00
        // # 01      1/0       10/01
        // # 10      1/0       00/10
        // a=~abc+a~b~c;
        // b=~a~bc+~ab~c;
        int a = 0;
        int b = 0;
        for (int c : A) {
            int temp = (~a & b & c) | (a & ~b & ~c);
            b = (~a & ~b & c) | (~a & b & ~c);
            a = temp;
        }
        // we need find the number that is 01,10 => 1, 00 => 0.
        return a | b;
    }
}



