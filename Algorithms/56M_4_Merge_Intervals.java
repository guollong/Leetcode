/**
 * Question description: Given a collection of intervals, merge all overlapping intervals.
 * 
 * Example: Given [1,3],[2,6],[8,10],[15,18], return [1,6],[8,10],[15,18].
 *
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: Google, Facebook, Twitter, Microsoft, Bloomberg, Yelp.
 */

/**
 * Progress...
 * Create Date: 06/26/2017
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

// Idea: sort the intervals first and loop over the sorted intervals to merge it.
// Note the implementation of the comparator.
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() <= 1) {
            return intervals;
        }
        List<Interval> result = new ArrayList<>();
        Collections.sort(intervals, new intervalComparator());
        result.add(intervals.get(0));
        
        for (int i = 1; i < intervals.size(); i++) {
            Interval inter1 = result.get(result.size() - 1);
            Interval inter2 = intervals.get(i);
            if (inter1.end < inter2.start) {
                result.add(inter2);
            } else {
                result.remove(result.size() - 1);
                result.add(new Interval(inter1.start, Math.max(inter1.end, inter2.end)));
            }
        }
        return result;
    }
    
    private class intervalComparator implements Comparator<Interval> {
           // Overriding the compare method to sort the age 
        @Override
        public int compare(Interval inter1, Interval inter2) {
            return inter1.start - inter2.start;
        }
    }
}


