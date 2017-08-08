/**
 * Question description: Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.
 * 
 * Example: Given a = 1 and b = 2, return 3.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; 
 * Company: Hulu.
 */

/**
 * Progress...
 * Create Date: 06/02/2017
 */


// Steps: 1. First, we can use "and"("&") operation between a and b to find a carry.
//		  2. carry = a & b, then carry = 0001
//		  3. Second, we can use "xor" ("^") operation between a and b to find the different bit, and assign it to a,
// 		  4. Then, we shift carry one position left and assign it to b, b = 0010.
// 		  5. Iterate until there is no carry (or b == 0)

// 照目前的情况来看，只能先记住。。。（无奈）

// Iterative
public int getSum(int a, int b) {
	if (a == 0) return b;
	if (b == 0) return a;

	while (b != 0) {
		int carry = a & b;
		a = a ^ b;
		b = carry << 1;
	}
	
	return a;
}

// Recursive
public int getSum(int a, int b) {
	return (b == 0) ? a : getSum(a ^ b, (a & b) << 1);
}

// Iterative
public int getSubtract(int a, int b) {
	while (b != 0) {
		int borrow = (~a) & b;
		a = a ^ b;
		b = borrow << 1;
	}
	
	return a;
}

// Recursive
public int getSubtract(int a, int b) {
	return (b == 0) ? a : getSubtract(a ^ b, (~a & b) << 1);
}

// Get negative number
public int negate(int x) {
	return ~x + 1;
}











