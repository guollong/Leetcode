/**
 * Question description: Write a program to find the n-th ugly number. Ugly numbers are positive numbers 
 *		whose prime factors only include 2, 3, 5. For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the 
 *		sequence of the first 10 ugly numbers.
 * 
 * Note: 1 is typically treated as an ugly number, and n does not exceed 1690.
 *
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: Google.
 */

/**
 * Progress...
 * Create Date: 09/02/2017
 */

// Solution 1: The same idea with ugly number II.
// Running time complexity: O(K * N).
class Solution {
    // merge sort of k arrays. (k is the number of primes)
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] dp = new int[n];
        int[] pointers = new int[primes.length];
        
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                min = Math.min(min, dp[pointers[j]] * primes[j]);
            }
            dp[i] = min;
            
            for (int j = 0; j < primes.length; j++) {
                if (min == dp[pointers[j]] * primes[j]) {
                    pointers[j]++;
                }
            }
        }
        return dp[n - 1];
    }
}

// Solution 2: Improved solution 1. (merge 2 for loops into one, and reduce the times of multiplications.)
class Solution {
    // merge sort of k arrays.
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] ugly = new int[n];
        int[] pointers = new int[primes.length];
        
        // primes 个用于比较的元素。。。 
        int[] val = new int[primes.length];
        Arrays.fill(val, 1);
        
        // next ugly number.
        int next = 1;
        
        for (int i = 0; i < n; i++) {
            ugly[i] = next;
            
            next = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                // skip duplicate and avoid extra multiplication.
                // 为了合并两个for循环，并且只有在必要的时候更新指针，减少了乘法的运算次数。
                if (val[j] == ugly[i]) {
                    val[j] = ugly[pointers[j]++] * primes[j];
                }
                // find next ugly number.
                next = Math.min(next, val[j]);
            }
        }
        
        return ugly[n - 1];
    }
}


// Solution 3: Use heap. (PriorityQueue). Time complexity: O(N * log(k))
class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] ugly = new int[n];
        
        PriorityQueue<Num> heap = new PriorityQueue<>();
        for (int i = 0; i < primes.length; i++) {
            heap.add(new Num(primes[i], 1, primes[i]));
        }
        ugly[0] = 1;
        
        for (int i = 1; i < n; i++) {
            ugly[i] = heap.peek().val;
            
            while (heap.peek().val == ugly[i]) {
                Num next = heap.poll();
                heap.add(new Num(next.parent * ugly[next.pointer], next.pointer + 1, next.parent));
            }
        }
        
        return ugly[n - 1];
    }
    
    private class Num implements Comparable<Num> {
        int val;
        int pointer;
        int parent;
        
        public Num(int v, int p, int parent) {
            val = v;
            pointer = p;
            this.parent = parent;
        }
        
        @Override
        public int compareTo(Num number) {
            return val - number.val;
        }
    }
}







