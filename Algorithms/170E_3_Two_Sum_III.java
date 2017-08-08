/**
 * Author: Jinglong Guo
 * Difficulty: Easy; 
 * Company: Linkedin.
 * Create Date: 02/03/2017
 * Update date: 06/15/2017
 * Notes: always take big data into consideration. O(n^2) is the worst case.
 */

/**
 * Design and implement a TwoSum class. It should support the following operations: add and find.
 * add - Add the number to an internal data structure.
 * find - Find if there exists any pair of numbers which sum is equal to the value.
 * For example: add(1); add(3); add(5); find(4) -> true; find(7) -> false
 */

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */

// Solution 1: Using hashmap.
public class TwoSum {
    Map<Integer, Integer> map;
    /** Initialize your data structure here. */
    public TwoSum() {
        map = new HashMap<>();
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        map.put(number, map.getOrDefault(number, 0) + 1);
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for (int element : map.keySet()) {
            int anotherEle = value - element;
            if (element == anotherEle && map.get(element) > 1) {
                return true;
            }
            if (element != anotherEle && map.containsKey(anotherEle)) {
                return true;
            }
        }
        return false;
    }
}

// Solution 2: Use arraylist and two pointers.
public class TwoSum {
    List<Integer> list;
    /** Initialize your data structure here. */
    public TwoSum() {
        list = new ArrayList<>();
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        list.add(number);
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        Collections.sort(list);
        int front = 0; 
        int rear = list.size() - 1;
        while (front < rear) {
            int sum = list.get(front) + list.get(rear);
            if (sum == value) {
                return true;
            } else if (sum < value) {
                front++;
            } else {
                rear--;
            }
        }
        return false;
    }
}

