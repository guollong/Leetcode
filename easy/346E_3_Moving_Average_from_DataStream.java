/**
 * Question description: Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.
 */

// Example: 
// MovingAverage m = new MovingAverage(3);
// m.next(1) = 1
// m.next(10) = (1 + 10) / 2
// m.next(3) = (1 + 10 + 3) / 3
// m.next(5) = (10 + 3 + 5) / 3

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; 
 * Company: Google.
 * Create Date: 02/24/2017
 * Update date: 06/13/2017
 */

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */

// Solution 1: When the total size is greater than the window size, use queue to remove the most
//      oldest element and always keep the size of the queue to be window size.
public class MovingAverage {
    private LinkedList<Integer> queue;
    private int maxSize = 0;
    private double sum =0;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        queue = new LinkedList<>();
        maxSize = size;
    }
    
    public double next(int val) {
        if(queue.size() == maxSize) 
            sum -= queue.poll();        //O(1). dont need to loop to calculate sum
        sum += val;
        queue.add(val);
        return sum / queue.size();
    }
}

// Solution 2: Use array to replace the oldest element to the current element. Substract the oldest 
//      element and add the current element to get the sum.
public class MovingAverage {
    private int[] streamInteger;
    private int insert = 0;
    private int windowSize = 0;
    private int sum = 0;
    private int totalsize = 0;
    
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        streamInteger = new int[size];
        windowSize = size;
    }
    
    public double next(int val) {
        insert = totalsize % windowSize;
        int temp = streamInteger[insert];
        streamInteger[insert] = val;
        totalsize++;
        
        if (totalsize <= windowSize) {
            sum = sum + val;
            return sum / (totalsize + 0.0);
        }
        sum = sum - temp + val;
        return sum / (windowSize + 0.0);
    }
}

// Solution 3: Use LinkedList to hold the pushed elements, get the sum using the same method as solution 2.
public class MovingAverage {
    private List<Integer> list = new LinkedList<>();
    private int start = 0;
    private int windowSize = 0;
    private int sum = 0;
    
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        list = new LinkedList<>();
        windowSize = size;
    }
    
    public double next(int val) {
        list.add(0, val);
        int size = list.size();
        if (size <= windowSize) {
           sum += val;
           return sum / (size + 0.0);
        }
        sum = sum - list.get(windowSize) + val;
        return sum / (windowSize + 0.0);
    }
}





