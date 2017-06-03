/**
 * Question description: Write a program to check whether a given number is an ugly number.
 *		Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 
 *		For example, 6, 8 are ugly while 14 is not ugly since it includes another prime factor 7.
 *		Note that 1 is typically treated as an ugly number.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; 
 * Company: .
 * Create Date: 03/29/2017
 * Update date: 06/03/2017
 */

public class Solution {
    public boolean isUgly(int num) {
        if (num <= 0) {
            return false;
        }
        for (int i = 2; i < 6; i++) {
            while (num % i == 0) {
                num /= i;
            }
        }
        return num == 1;
    }
}

// Could save the time check 4.
public class Solution {
    public boolean isUgly(int num) {
        if (num <= 0) {
            return false;
        }
        if (num == 1) {
            return true;
        }
    	while (num % 2 == 0) num = num / 2;
    	while (num % 3 == 0) num = num / 3;
    	while (num % 5 == 0) num = num / 5;
        return num == 1;
    }
}

// Ways to get the prime factors of an integer. 
// Easy comprehensive.
public static List<Integer> primeFactors(int number) {
    int n = number;
    List<Integer> factors = new ArrayList<Integer>();
    for (int i = 2; i <= n; i++) {
        while (n % i == 0) {
            factors.add(i);
            n /= i;
        }
    }
    return factors;
}

// Improved version of getting prime factors.
public static List<Integer> primeFactors(int numbers) {
    int n = numbers;
    List<Integer> factors = new ArrayList<Integer>();
    for (int i = 2; i <= n / i; i++) {
        while (n % i == 0) {
            factors.add(i);
            n /= i;
        }
    }
    if (n > 1) {
        factors.add(n);
    }
    return factors;
}


