/**
 * Question description: Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; Company: .
 * Date: 03/02/2017
 */

// solution from discussion.(现在还不会)
int getSum(int a, int b) {
    return b == 0 ? a : getSum(a^b, (a&b)<<1); //be careful about the terminating condition;
}






