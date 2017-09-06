/**
 * Question description: Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), 
 *		find the minimum number of conference rooms required.
 *
 * Example: Given [[0, 30],[5, 10],[15, 20]], return 2.
 *
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: Google, Snapchat, Facebook.
 */

/**
 * Progress...
 * Create Date: 09/05/2017
 */

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */

// Solution using heap. Running time complexity: O(n * logn)
// There is another solution that is more efficient than this approach. Should I figure it out ??
class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        
        // Sort the intervals based on starting time.
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval inter1, Interval inter2) {
                return inter1.start - inter2.start;
            }
        });
        
        PriorityQueue<Interval> heap = new PriorityQueue<Interval>(intervals.length, new Comparator<Interval>() {
            @Override
            public int compare(Interval inter1, Interval inter2) {
                return inter1.end - inter2.end;
            }
        });
        
        heap.offer(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            Interval inter = heap.poll();
            if (intervals[i].start >= inter.end) {
                inter.end = intervals[i].end;
            } else {
                heap.offer(intervals[i]);
            }
            heap.offer(inter);
        }
        return heap.size();
    }
}


