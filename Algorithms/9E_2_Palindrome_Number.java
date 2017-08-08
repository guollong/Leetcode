/**
 * Question description: Determine whether an integer is a palindrome. Do this without extra space.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; 
 * Company: 暂时无.
 */

/**
 * Progress...
 * Create Date: 06/06/2017
 */

// 注意⚠️： 这里不能用extra space。。。

// Solution 1: 得到x的逆序整数，check是否相同。
public class Solution {
    public boolean isPalindrome(int x) {
        // y is an integer which has inverse ordered decimal bit with x.
        int y = 0;
		int temp = x;
		while(temp > 0){
			int s = temp % 10;
			y = y * 10 + s;
			temp = temp / 10;
		}
		if(x == y){
			return true;
		}
		return false; 
    }
}

// Solution 2: Get the decimal bit number of x, and check whether the front decimal bit is equal to the 
//			rear decimal bit.
public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int count = (int)Math.log10(x) + 1;
        for (int i = 0; i < count / 2; i++) {
            int front = (int) (x / Math.pow(10, count - i - 1) % 10);
            int rear = (int) (x % Math.pow(10, i + 1) / Math.pow(10, i));
            if (front != rear) {
                return false;
            }
        }
        return true;
    }
}



