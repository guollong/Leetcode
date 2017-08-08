/**
 * Question description: Given two strings representing two complex numbers. You need to return a string representing 
 *		their multiplication. Note i2 = -1 according to the definition.
 *
 * Example 1: Input: "1+1i", "1+1i"; Output: "0+2i"
 * 		Explanation: (1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i, and you need convert it to the form of 0+2i.
 * Example 2: Input: "1+-1i", "1+-1i"; Output: "0+-2i"
 *		Explanation: (1 - i) * (1 - i) = 1 + i2 - 2 * i = -2i, and you need convert it to the form of 0+-2i.
 *
 * Note: The input strings will not have extra blank.
 *		 The input strings will be given in the form of a+bi, where the integer a and b will both belong to the range 
 *			of [-100, 100]. And the output should be also in this form.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: Amazon.
 */

/**
 * Progress...
 * Create Date: 07/22/2017
 */

// My solution.
public class Solution {
    // The correct expression of operators: {"-","\\+","/","\\*","x","\\^","X"};
    public String complexNumberMultiply(String a, String b) {
        String[] input1 = a.split("\\+");
        String[] input2 = b.split("\\+");
        int res_part1 = Integer.parseInt(input1[0]) * Integer.parseInt(input2[0]);
        int res_part2 = Integer.parseInt(input1[1].substring(0, input1[1].length() - 1)) * Integer.parseInt(input2[0]);
        int res_part3 = Integer.parseInt(input1[0]) * Integer.parseInt(input2[1].substring(0, input2[1].length() - 1));
        int res_part4 = Integer.parseInt(input1[1].substring(0, input1[1].length() - 1)) * 
            Integer.parseInt(input2[1].substring(0, input2[1].length() - 1));
        return (res_part1 - res_part4 + "+") + (res_part2 + res_part3 + "i");
    }
}

// More simpler and clearer solution from discussion.
public class Solution {
    public String complexNumberMultiply(String a, String b) {
        String x[] = a.split("\\+|i");
        String y[] = b.split("\\+|i");
        int a_real = Integer.parseInt(x[0]);
        int a_img = Integer.parseInt(x[1]);
        int b_real = Integer.parseInt(y[0]);
        int b_img = Integer.parseInt(y[1]);
        return (a_real * b_real - a_img * b_img) + "+" + (a_real * b_img + a_img * b_real) + "i";

    }
}


