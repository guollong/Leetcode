/**
 * Author: Jinglong Guo
 * Difficulty: Easy; 
 * Company: Linkedin.
 * Date: 02/03/2017
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

public class TwoSum {
    
    Map<Integer, Integer> data;

    /** Initialize your data structure here. */
    public TwoSum() {
        data = new HashMap<Integer, Integer>();
    }
    
    /** Add the number to an internal data structure.. */
    // Running time complexity: O(1)
    public void add(int number) {
        if (data.containsKey(number)) {
            data.put(number, data.get(number) + 1);
        } else {
            data.put(number, 1);
        }
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    // Running time complexity: O(n)
    public boolean find(int value) {
        for (Integer element : data.keySet()) {
            int anotherEle = value - element;
            if ((element != anotherEle && data.containsKey(anotherEle)) || (anotherEle == element && data.get(element) != 1)){
                return true;
            }
        }
        return false;
    }
}
