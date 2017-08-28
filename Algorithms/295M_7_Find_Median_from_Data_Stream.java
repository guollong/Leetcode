/**
 * Question description: Median is the middle value in an ordered integer list. If the size of the list is even, 
 *		there is no middle value. So the median is the mean of the two middle value.
 * 
 * Examples: [2,3,4] , the median is 3
 *			 [2,3], the median is (2 + 3) / 2 = 2.5
 * 
 * Design a data structure that supports the following two operations:
 * 	1. void addNum(int num) - Add a integer number from the data stream to the data structure.
 * 	2. double findMedian() - Return the median of all elements so far.
 * 
 * For example: 
 * 	addNum(1)
 * 	addNum(2)
 * 	findMedian() -> 1.5
 * 	addNum(3) 
 * 	findMedian() -> 2
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: Google. 
 */

/**
 * Progress...
 * Create Date: 08/28/2017
 */

class MedianFinder {
	// maxHeap is always larger or equal to minHeap. 
    // store the first half of the numbers.
    PriorityQueue<Integer> maxHeap;
    // store the second half of the numbers. (default)
    PriorityQueue<Integer> minHeap;
    
    /** initialize your data structure here. */
    public MedianFinder() {
        // maxHeap = new PriorityQueue<Integer>(10, new Comparator<Integer>() {
        //     @Override
        //     public int compare(Integer a, Integer b) {
        //         return b - a;
        //     }
        // });
        maxHeap = new PriorityQueue<Integer>(10, Collections.reverseOrder());
        minHeap = new PriorityQueue<Integer>();
    }
    
    
    public void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
        if (maxHeap.size() < minHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }
    
    public double findMedian() {
        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        }
        return ((double) maxHeap.peek() + (double) minHeap.peek()) / 2;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

