/**
 * Question description: Given a non-empty array of integers, return the k most frequent elements.
 * 
 * Example: Given [1,1,1,2,2,3] and k = 2, return [1,2].
 *
 * Note: You may assume k is always valid, 1 ? k ? number of unique elements.
 * 		Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: Pocket Gems, Yelp. 
 */

/**
 * Progress...
 * Create Date: 08/02/2017
 */

// Solution 1: Bucket sort.
// Running time complexity: O(n).
public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        
        // Count the frequency of numbers. 
        for (int number : nums) {
            frequencyMap.put(number, frequencyMap.getOrDefault(number, 0) + 1);
        }
        
        // put elements in a bucket, take frequency as index and put all elements share same frequencies in one list.
        List<Integer>[] bucket = new List[nums.length + 1];
        for (int number : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(number);
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<Integer>();
            }
            bucket[frequency].add(number);
        }
        
        for (int i = nums.length; i >= 0 && result.size() < k; i--) {
            if (bucket[i] != null) {
                result.addAll(bucket[i]);
            }
        }
        return result;
    }
}

// Solution 2: Using heap (PriorityQueue). 
// Use PriorityQueue as maxHeap.
// The default priority queue is a minimum heap. However, we could implement maxHeap by implementing 
//      compartor interface and override compare method.

public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n: nums){
            map.put(n, map.getOrDefault(n,0)+1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = 
            new PriorityQueue<>(10, new Comparator<Map.Entry<Integer, Integer>>() {
                @Override
                public int compare(Map.Entry<Integer, Integer> entry1, Map.Entry<Integer, Integer> entry2) {
                    return entry2.getValue() - entry1.getValue();
                }
            });
        
        for (Map.Entry<Integer,Integer> entry: map.entrySet()){
            maxHeap.add(entry);
        }
        
        List<Integer> res = new ArrayList<>();
        while (res.size() < k) {
            res.add(maxHeap.poll().getKey());
        }
        return res;
    }
}

// Solution 3: Use treeMap.
// Similiar to HashMap, TreeMap does not allow duplicates. Thus, we must put all elements with same 
//      frequency in one list.
public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n: nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        
        TreeMap<Integer, List<Integer>> freqMap = new TreeMap<>();
        for (int num : map.keySet()) {
           int freq = map.get(num);
           if (!freqMap.containsKey(freq)) {
               freqMap.put(freq, new LinkedList<>());
           }
           freqMap.get(freq).add(num);
        }
        
        List<Integer> res = new ArrayList<>();
        while (res.size() < k) {
            Map.Entry<Integer, List<Integer>> entry = freqMap.pollLastEntry();
            res.addAll(entry.getValue());
        }
        return res;
    }
}

// Solution 4: self-implemented solution using heap(PriorityQueue). 
// 参考价值：Implement nested class and make a class comparable.
// Running time complexity: O(n).
public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        
        Map<Integer, Integer> map = new HashMap<>();

        // Count the frequency of numbers. 
        for (int number : nums) {
            map.put(number, map.getOrDefault(number, 0) + 1);
        }
        
        PriorityQueue<HeapNode> heap = new PriorityQueue<>();
        for (int number : map.keySet()) {
            int inversefreq = - map.get(number);
            HeapNode node = new HeapNode(inversefreq, number);
            heap.offer(node);
        }
        
        for (int i = 0; i < k; i++) {
            HeapNode node = heap.poll();
            result.add(node.element);
        }
        return result;
    }
    
    private class HeapNode implements Comparable<HeapNode> {
        private int frequency;
        private int element;
        
        public HeapNode(int f, int number) {
            frequency = f;
            element = number;
        }
        
        @Override
        public int compareTo(HeapNode node) {
            return this.frequency - node.frequency;
        }
        
    }
}




