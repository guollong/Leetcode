/**
 * Question description: Given an array of meeting time intervals consisting of start and 
 * 		end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.
 * 
 * Example: Input: [[0, 30],[5, 10],[15, 20]]; Output: false.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; 
 * Company: Facebook.
 * Create Date: 03/25/2017
 * Update date: 06/13/2017
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

// Solution 1: Sort the intervals based on the starting time (implement comparator). Then loop 
//      over the sorted array, if the meet starts before the end of the previous meeting, return false;
public class Solution {
    public boolean canAttendMeetings(Interval[] intervals) {
        Arrays.sort(intervals, new IntervalComparator());
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start < intervals[i - 1].end) {
                return false;
            }
        }
        return true;
    }
    
    private class IntervalComparator implements Comparator<Interval>{
    	@Override
    	public int compare(Interval inter1, Interval inter2) {
    		return inter1.start - inter2.start;
    	}
    }
}

// Simpler version: The same idea with above solution, but combine the comparator with arrays.sort method.
public class Solution {
    public boolean canAttendMeetings(Interval[] intervals) {
        if (intervals == null) {
            return false;
        }
        // sort an array of user-defined objects using comparator.
        Arrays.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });
        
        // For array intervals, if the start of the current element is less than
        // the end of the previous element, return false.
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start < intervals[i - 1].end) {
                return false;
            }
        }
        return true;
    }
}

