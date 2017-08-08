/**
 * Question description: Given a non-empty array of integers, return the third maximum number 
 *		in this array. If it does not exist, return the maximum number. The time complexity must be in O(n).
 * Example: Input: [3, 2, 1]; Output: 1
 *			Input: [1, 2]; Output: 2
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; 
 * Company: Amazon.
 */

/**
 * Progress...
 * Create Date: 06/09/2017
 */

// precondition: the array is non-empty.
// If it does not exist, return the maximum number. The time complexity must be in O(n).
// Consider duplicate key.

// Solution 1: Running time complexity. Loop...
public class Solution {
    public int thirdMax(int[] nums) {
        Integer firstMax = null;
        Integer secondMax = null;
        Integer thirdMax = null;
        for (Integer element : nums) {
            if (element.equals(firstMax) || element.equals(secondMax) || element.equals(thirdMax)) {
                continue;
            }
            if (firstMax == null || element > firstMax) {
                thirdMax = secondMax;
                secondMax = firstMax;
                firstMax = element;
            } else if (secondMax == null || element > secondMax) {
                thirdMax = secondMax;
                secondMax = element;
            } else if (thirdMax == null || element > thirdMax) {
                thirdMax = element;
            }
        }
        return thirdMax == null ? firstMax : thirdMax;
    }
}

// Solution 2: priority queue.
public class Solution {
    public int thirdMax(int[] nums) {
        PriorityQueue<Integer> priQueue = new PriorityQueue<>();
        Set<Integer> set = new HashSet<>();
        for (int element : nums) {
            if (!set.contains(element)) {
                priQueue.offer(element);
                set.add(element);
                if (priQueue.size() > 3) {
                    set.remove(priQueue.poll());
                }
            }
        }
        if (priQueue.size() < 3) {
            while (priQueue.size() > 1) {
                priQueue.poll();
            }
        }
        return priQueue.peek();
    }
}

// Solution 3: my original solution: create a set for input. loop two times to remove firstMax and secondMax.
public class Solution {
    // precondition: the array is non-empty.
    // If it does not exist, return the maximum number. The time complexity must be in O(n).
    // Consider duplicate key.
    public int thirdMax(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int element : nums) {
            if (!map.containsKey(element)) {
                map.put(element, 1);
            }
        }
        if (map.size() < 3) {
            int max = Integer.MIN_VALUE;
            for (int element : map.keySet()) {
                if (max < element) {
                    max = element;
                }
            }
            return max;
        }
        // get the first maximum and first minimum of the array. 
        // Replace the first maximum value with the minimum value minus 1.
        int maxFirst = Integer.MIN_VALUE;
        int minFirst = Integer.MAX_VALUE;
        for (int element : map.keySet()) {
            maxFirst = Math.max(element, maxFirst);
            minFirst = Math.min(element, minFirst);
        }
        minFirst = (minFirst == -2147483648) ? -2147483648 : minFirst - 1;
        map.remove(maxFirst);
        map.put(minFirst, 1);
        
        // get the second maximum of the array. 
        // Replace the second maximum value with the minimum value minus 1.
        int maxSecond = Integer.MIN_VALUE;
        for (int element : map.keySet()) {
            maxSecond = Math.max(element, maxSecond);
        }
        map.remove(maxSecond);
        map.put(minFirst, 1);
        
        int maxThird = Integer.MIN_VALUE;
        for (int element : map.keySet()) {
            maxThird = Math.max(element, maxThird);
        }
        return maxThird;
    }
}










