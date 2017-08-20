/**
 * Question description: Design and implement a data structure for Least Recently Used (LRU) cache. 
 *		It should support the following operations: get and put.
 *		get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 *		put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, 
 *			it should invalidate the least recently used item before inserting a new item.
 * 
 * Follow up: Could you do both operations in O(1) time complexity?
 * 
 * Example: 
 *	LRUCache cache = new LRUCache(2);
 *	cache.put(1, 1);
 *	cache.put(2, 2);
 *	cache.get(1);       // returns 1
 *	cache.put(3, 3);    // evicts key 2
 *	cache.get(2);       // returns -1 (not found)
 *	cache.put(4, 4);    // evicts key 1
 *	cache.get(1);       // returns -1 (not found)
 *	cache.get(3);       // returns 3
 *	cache.get(4);       // returns 4
 *
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Hard; 
 * Company: Google, Uber, Facebook, Twitter, Zenefits, Amazon, Microsoft, Snapchat, Yahoo, Bloomberg, Palantir. 
 */

/**
 * Progress...
 * Create Date: 08/19/2017
 */

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

// Solution: hashtable + doubly linkedlist.
class LRUCache {
    private int capacity;
    Map<Integer, DoublyListNode> cache;
    DoublyListNode head;
    DoublyListNode tail;
    
    public LRUCache(int capacity) {
        cache = new HashMap<Integer, DoublyListNode>();
        this.capacity = capacity;
        head = new DoublyListNode(-1, -1);
        tail = new DoublyListNode(-1, -1);
        
        // Note that initially the head and tail should be linked together.
        tail.pre = head;
        head.next = tail;
    }
    
    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        
        // If the key is in the map, get the value and move it to the tail of the doubly linkedList, 
        // indicating that the node is the last being modified.
        
        // remove the current node from the list.
        DoublyListNode curr = cache.get(key);
        curr.next.pre = curr.pre;
        curr.pre.next = curr.next;
        
        // move the current node to the tail.
        moveToTail(curr);
        
        // return the value of key.
        return curr.value;
    }
    
    public void put(int key, int value) {
        // If the key is in the map, update the value of key. The position of the key has been updated by the get method.
        if (get(key) != -1) {
            cache.get(key).value = value;
            return;
        }
        
        if (cache.size() == capacity) {
            cache.remove(head.next.key);
            head.next = head.next.next;
            head.next.pre = head;
        }
        
        // Create a new node and insert it to the tail.
        DoublyListNode node = new DoublyListNode(key, value);
        cache.put(key, node);
        moveToTail(node);
    }
    
    private void moveToTail(DoublyListNode current) {
        current.pre = tail.pre;
        tail.pre = current;
        current.pre.next = current;
        current.next = tail;
    }

    
    class DoublyListNode{
        int key;
        int value;
        DoublyListNode pre;
        DoublyListNode next;
        
        DoublyListNode(int key, int value) {
            this.key = key;
            this.value = value;
            pre = null;
            next = null;
        }
    }

}





// ????????????????????????????????
// Couldn't understand why could not use a treemap.
class LRUCache {

    private TreeMap<Integer, NodeWithIndex> cache;
    private int index;
    private int capacity;
    
    public LRUCache(int capacity) {
        cache = new TreeMap<Integer, NodeWithIndex>(new MyComparator());
        index = 0;
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (cache.containsKey(key)) {
            return cache.get(key).value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        // If the key is in the map, just update its value and time.
        if (cache.containsKey(key)) {
            cache.put(key, new NodeWithIndex(key, value, index++));
            return;
        }
        
        // If the key is not in the map, check the capacity. If the cache is not full, 
        // just insert the key-value pair. However, if the cache is full, invalidate 
        // the oldest pair, and put the latest pair in the map.
        if (index + 1 > capacity) {
            // remove the oldest node.
            cache.pollFirstEntry();
        }
        cache.put(key, new NodeWithIndex(key, value, index++));
    }
    
    class NodeWithIndex{
        int key;
        int value;
        int index;
        
        NodeWithIndex(int key, int value, int index) {
            this.key = key;
            this.value = value;
            this.index = index;
        }
    }
    
    class MyComparator implements Comparator<NodeWithIndex>{
        @Override
        public int compare(NodeWithIndex node1, NodeWithIndex node2) {
            return node1.index - node2.index;
        }
    }
}

