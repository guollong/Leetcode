/**
 * Question description: Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.
 * 
 * Note: The length of both num1 and num2 is < 5100.
 * 		 Both num1 and num2 contains only digits 0-9.
 * 		 Both num1 and num2 does not contain any leading zero.
 *		 You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; Company: .
 * Date: 03/27/2017
 */

// 简化的方法。
public class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        // for loop condition: any strings has elements or carry equals to 1.
        // if index < 0, add 0 to the local sum.
        // carry: whether have carry??
        for(int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0 || carry == 1; i--, j--){
            int x = i < 0 ? 0 : num1.charAt(i) - '0';
            int y = j < 0 ? 0 : num2.charAt(j) - '0';
            sb.append((x + y + carry) % 10);
            carry = (x + y + carry) / 10;
        }
        return sb.reverse().toString();
    }
}

// Jinglong's original method.(the same idea)
public class Solution {
    public String addStrings(String num1, String num2) {
        int index1 = num1.length() - 1, index2 = num2.length() - 1;
        int addOne = 0;
        StringBuilder output = new StringBuilder();
        
        while (index1 >= 0 && index2 >= 0) {
            int temp;
            if (addOne != 0) {
                temp = num1.charAt(index1) - '0' + num2.charAt(index2) - '0' + 1;
            } else {
                temp = num1.charAt(index1) - '0' + num2.charAt(index2) - '0';
            }
            addOne = temp / 10;
            temp = temp % 10;
            output.append(temp);
            index1--;
            index2--;
        }
        
        while (index1 >= 0) {
            if (addOne != 0) {
                int temp = num1.charAt(index1) - '0' + 1;
                addOne = temp / 10;
                temp = temp % 10;
                output.append(temp);
            } else {
                output.append(num1.charAt(index1) - '0');
            }
            index1--;
        }
        
        while (index2 >= 0) {
            if (addOne != 0) {
                int temp = num2.charAt(index2) - '0' + 1;
                addOne = temp / 10;
                temp = temp % 10;
                output.append(temp);
            } else {
                output.append(num2.charAt(index2) - '0');
            }
            index2--;
        }
        if (addOne != 0) {
            output.append(1);
        }
        return output.reverse().toString();
    }
}