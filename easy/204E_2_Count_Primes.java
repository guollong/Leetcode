/**
 * Question description: Count the number of prime numbers less than a non-negative number, n.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; 
 * Company: Amazon, Microsoft.
 */

/**
 * Progress...
 * Create Date: 06/08/2017
 */

// Traditional solution: loop from 2 to n, check whether the number is a prime number.
// Running time complexity: O(n * sqrt(n))
// 不管它简单与否，那个check prime的方法老是忘记。。。。。。
public class Solution {
    public int countPrimes(int n) {
        int count = 0;
        int i = 2;
        while (i < n) {
            if (isPrime(i)) {
                count++;
            }
            i++;
        }
        return count;
    }
    
    private boolean isPrime(int n) {
        int temp = n;
        // from 2 to n / 2, if n / i equals to 0, it is not a prime.
        for (int i = 2; i <= (int) Math.sqrt(n); i++) {
            temp = n % i;
        	if (temp == 0) {
        	    return false;
        	}
        }
        return true;
    }
}

// Sieve of Eratosthenes: Finding all prime numbers up to any given limit. It does
//      so by iteratively marking as composite (i.e., not prime) the multiples of 
//      each prime, starting with the multiples of 2.
// Running time complexity: O(n)
public class Solution {
    public int countPrimes(int n) {
        if (n < 3) {
            return 0;
        }
        int count = 0;
        boolean[] isPrimes = new boolean[n];
        Arrays.fill(isPrimes, Boolean.TRUE); // Could use Arrays.fill to put values of an array.
        isPrimes[0] = false;
        isPrimes[1] = false;
        for (int i = 2; i <= (int) Math.sqrt(n); i++) {
            if (isPrimes[i]) {
                for (int j = 2; i * j < n; j++) {
                    isPrimes[i * j] = false;
                }
            }
        }
        for (boolean element : isPrimes) {
            if (element) {
                count++;
            }
        }
        return count;
    }
}



