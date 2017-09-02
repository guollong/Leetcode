/**
 * Question description: Given two 1d vectors, implement an iterator to return their elements alternately.
 * 
 * Example: given two 1d vectors: v1 = [1, 2], v2 = [3, 4, 5, 6], the order of elements returned by next 
 *		should be: [1, 3, 2, 4, 5, 6].
 * 
 * Follow up: What if you are given k 1d vectors? How well can your code be extended to such cases?
 *		The "Zigzag" order is not clearly defined and is ambiguous for k > 2 cases. If "Zigzag" does not look 
 *		right to you, replace "Zigzag" with "Cyclic". For example, given the following input:
 * 
 *	[1,2,3]
 *	[4,5,6,7]
 * 	[8,9]
 * It should return [1,4,8,2,5,9,3,6,7].
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

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */

// Solution 1: my own solution using two lists.
public class ZigzagIterator {
    List<Integer> list1;
    List<Integer> list2;
    private int pointer1;
    private int pointer2;
    
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        list1 = v1;
        list2 = v2;
        pointer1 = 0;
        pointer2 = 0;
    }

    public int next() {
        int result = 0;
        if (pointer1 < list1.size() && pointer2 < list2.size()) {
            if (pointer1 == pointer2) {
                result = list1.get(pointer1);
                pointer1++;
            } else {
                result = list2.get(pointer2);
                pointer2++;
            }
        } else if (pointer1 < list1.size()) {
            result = list1.get(pointer1);
            pointer1++;
        } else {
            result = list2.get(pointer2);
            pointer2++;
        }
        return result;
    }

    public boolean hasNext() {
        return pointer1 < list1.size() || pointer2 < list2.size();
    }
}

// Solution 2: Follow up: when we have k vectors, to use a queue to keep the order of output.
public class ZigzagIterator {
    
    LinkedList<Iterator> list;
    
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        list = new LinkedList<Iterator>();
        if (!v1.isEmpty()) {
            list.add(v1.iterator());
        }
        if (!v2.isEmpty()) {
            list.add(v2.iterator());
        }
    }

    public int next() {
        Iterator poll = list.poll();
        int result = (Integer) poll.next();
        if (poll.hasNext()) {
            list.add(poll);
        }
        return result;
    }

    public boolean hasNext() {
        return !list.isEmpty();
    }
}




