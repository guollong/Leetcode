/**
 * Question description: Design and implement a data structure for a compressed string iterator. 
 *		It should support the following operations: next and hasNext.
 * 		The given compressed string will be in the form of each letter followed by a positive integer
 *		representing the number of this letter existing in the original uncompressed string.
 *
 * 		next() - if the original string still has uncompressed characters, return the next letter; 
 *			Otherwise return a white space.
 * 		hasNext() - Judge whether there is any letter needs to be uncompressed.
 * 
 * Example:
 *		StringIterator iterator = new StringIterator("L1e2t1C1o1d1e1");
 *		iterator.next(); // return 'L'
 *		iterator.next(); // return 'e'
 *		iterator.next(); // return 'e'
 *		iterator.next(); // return 't'
 *		iterator.next(); // return 'C'
 *		iterator.next(); // return 'o'
 *		iterator.next(); // return 'd'
 *		iterator.hasNext(); // return true
 *		iterator.next(); // return 'e'
 *		iterator.hasNext(); // return false
 *		iterator.next(); // return ' '
 *
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; 
 * Company: Google.
 */

/**
 * Progress...
 * Create Date: 06/11/2017
 */

/**
 * Your StringIterator object will be instantiated and called as such:
 * StringIterator obj = new StringIterator(compressedString);
 * char param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */


// My solution: Use a list to hold the character and its frequency. (the node of list is self-designed.)
public class StringIterator {
    List<Node> list;
    
    public StringIterator(String compressedString) {
        list = new ArrayList<>();
        String temp = compressedString;
        while (temp.length() > 0) {
            char key = temp.charAt(0);
            int index = 1;
            while (index < temp.length() && temp.charAt(index) >= '0' && temp.charAt(index) <= '9') {
                index++;
            }
            int frequency = Integer.parseInt(temp.substring(1, index));
            Node node = new Node(key, frequency);
            list.add(node);
            temp = temp.substring(index);
        }
    }
    
    public char next() {
        if (list.size() == 0) {
            return ' ';
        }
        Node node = list.get(0);
        if (node.frequency == 1) {
            list.remove(0);
        } else {;
            node.frequency--;
        }
        System.out.println(node.key + "; " + node.frequency);
        return node.key;
    }
    
    public boolean hasNext() {
        if (list.size() == 0) {
            return false;
        }
        return true;
    }
    
    private class Node {
        char key;
        int frequency;
        
        public Node(char c, int f) {
            key = c;
            frequency = f;
        }
    }
}



// Clever solution. 真的好聪明啊啊啊啊啊。。。。。
public class StringIterator {
    String res;
    int ptr = 0, num = 0;
    char ch = ' ';
    
    public StringIterator(String s) {
        res = s;
    }
    
    public char next() {
        if (!hasNext())
            return ' ';
        if (num == 0) {
            ch = res.charAt(ptr++);
            while (ptr < res.length() && Character.isDigit(res.charAt(ptr))) {
                num = num * 10 + res.charAt(ptr++) - '0';
            }
        }
        num--;
        return ch;
    }
    
    public boolean hasNext() {
        return ptr != res.length() || num != 0;
    }
}





