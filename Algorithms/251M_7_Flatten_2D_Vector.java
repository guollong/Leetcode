/**
 * Question description: Implement an iterator to flatten a 2d vector.
 * 
 * Example: Given 2d vector =
 *	[
 *	  [1,2],
 *	  [3],
 *	  [4,5,6]
 *	]
 * By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,2,3,4,5,6].
 *
 * Follow up: As an added challenge, try to code it using only iterators in Java.
 *
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: Google, Airbnb, Twitter, Zenefits.
 */

/**
 * Progress...
 * Create Date: 09/02/2017
 */

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */

// Solution 1: More clear method using List<List<Integer>>.
public class Vector2D implements Iterator<Integer> {
    private List<List<Integer>> template;
    private int listIndex;
    private int elementIndex;
    
    public Vector2D(List<List<Integer>> vec2d) {
        template = vec2d;
        listIndex = 0;
        elementIndex = 0;
    }

    @Override
    public Integer next() {
        return template.get(listIndex).get(elementIndex++);
    }

    @Override
    public boolean hasNext() {
        while (listIndex < template.size()) {
            if (elementIndex < template.get(listIndex).size()) {
                return true;
            } else {
                listIndex++;
                elementIndex = 0;
            }
        }
        return false;
    }
}

// Solution 2: follow up: Only use iterator in java.
//  Idea: 1st: Put all iterator in a queue
//  	  2nd: Keep track of the current iterator
//  	  3rd: Check hasNext() and next() of current
public class Vector2D implements Iterator<Integer> {
    Queue<Iterator<Integer>> queue;
    Iterator<Integer> current;
    
    public Vector2D(List<List<Integer>> vec2d) {
        queue = new LinkedList<>();
        for (List<Integer> list : vec2d) {
            queue.add(list.iterator());
        }
        current = queue.poll();
    }

    @Override
    public Integer next() {
        if (current.hasNext()) {
            return current.next();
        }
        return -1;
    }

    @Override
    public boolean hasNext() {
        if (current == null) {
            return false;
        }
        while (!current.hasNext()) {
            if (!queue.isEmpty()) {
                current = queue.poll();
            } else {
                return false;
            }
        }
        return true;
    }
}


// Solution 3: My original solution using List<List<Integer>>. (remove the element in the template at the same time)
public class Vector2D implements Iterator<Integer> {
    List<List<Integer>> template;
    
    public Vector2D(List<List<Integer>> vec2d) {
        template = vec2d;
    }

    @Override
    public Integer next() {
        Integer next = null;
        if (this.hasNext()) {
            next = template.get(0).get(0);
            template.get(0).remove(0);
        }
        return next;
    }

    @Override
    public boolean hasNext() {
        // remove all empty list at the beginning of the template.
        while (template.size() != 0 && template.get(0).size() == 0) {
            template.remove(0);
        }
        return template.size() != 0;
    }
}



