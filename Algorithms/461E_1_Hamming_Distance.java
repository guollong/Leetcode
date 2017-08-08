/**
 * Question description: Given two integers x and y, calculate the Hamming distance. Note: 0 ≤ x, y < 2^31.
 * 			The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 * Example: Input: x = 1, y = 4; Output: 2
 * Explanation:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *        ↑   ↑
 * The above arrows point to positions where the corresponding bits are different.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; 
 * Company: Facebook.
 * Date: 02/24/2017
 */

public class Solution {
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}

// Not using bitCount method.
// Notes: ^为异或，只需要得到在异或结果中有多少个1即可.
public class Solution {
    public int hammingDistance(int x, int y) {
        int xor = x ^ y, count = 0;
        for (int i = 0; i < 32; i++) {
        	count += (xor >> i) & 1;
        }
        return count;
    }
}

// jinglong's original solution.
// Notes: 右移或左移时，后面的数字代表是多少位，很容易写错，因为我们通常要做的是乘以2或者除以2，所以一般位数一般为1.
public class Solution {
    public int hammingDistance(int x, int y) {
        int count = 0;
        while (x != 0 || y != 0) {
            if (x % 2 != y % 2) {
                count++;
            }
            x = x >> 1;
            y = y >> 1;
        }
        return count;
    }
}


