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
 * Difficulty: Easy; Company: .
 * Date: 02/24/2017
 */

// 需要考虑的情况： 当length小于windowSize; 当length大于windowSize;
// integer to double: 乘以1.0
public class MovingAverage {

    List<Integer> streamInteger;
    int windowSize;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        streamInteger = new ArrayList<>();
        windowSize = size;
    }
    
    public double next(int val) {
        streamInteger.add(val);
        int length = streamInteger.size();
        int sum = 0;
        if (length < windowSize) {
            sum = 0;
            for (int i = 0; i < length; i++) {
                sum = sum + streamInteger.get(i);
            }
            return sum * 1.0 / length;
            
        } else {
            for (int i = length - windowSize; i < length; i++) {
                sum += streamInteger.get(i);
            }
            return sum * 1.0 / windowSize;
        }

    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */

