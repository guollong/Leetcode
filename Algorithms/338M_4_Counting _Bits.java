/**
 * Question description: Given a non negative integer number num. For every numbers i in the 
 *		range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and 
 *		return them as an array.
 * 
 * Example: Input: 5; Output: [0,1,1,2,1,2].
 *
 * Follow up: 
 *		It is easy to solve it in O(n*sizeof(integer)). Could you do it in single pass?
 *		Could you do it without any built-in functions??
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: 暂时无.
 */

/**
 * Progress...
 * Create Date: 06/19/2017
 */

// Solution 1: Use built-in function: Integer.bitCount()
public class Solution {
    public int[] countBits(int num) {
        int[] result = new int[num + 1];
        for (int i = 0; i <= num ; i++) {
            result[i] = Integer.bitCount(i);
        }
        return result;
    }
}

// Solution 2: Without built-in function.
public class Solution {
    public int[] countBits(int num) {
        int[] result = new int[num + 1];
        int count = 0;
        for (int i = 0; i <= num ; i++) {
            count = 0;
            int number = i;
            for (int j = 0; j < 32; j++) {
                count += number & 1;
                number >>= 1;
            }
            result[i] = count;
        }
        return result;
    }
}

// Solution 3: One single pass. (Running time complexity: O(n))
// Recursive method. Example: 10010111; result = the last bit + 1s in 1001011
public class Solution {
    public int[] countBits(int num) {
        int[] result = new int[num + 1];
        for (int i = 0; i <= num ; i++) {
            result[i] = result[i / 2] + i % 2;
        }
        return result;
    }
}


