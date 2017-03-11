/**
 * Question description: Given a string, sort it in decreasing order based on the frequency of characters.
 * Examples:
 * 		Input: "tree"
 * 		Output: "eert"
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; Company: .
 * Date: 03/10/2017
 */

// 解题说明：得到字母和对应的频率，再放进数组（节点为字母+频率）当中排序，最后append到StringBuilder里。

public class Solution {
    public String frequencySort(String s) {
        // map for counting the frequency of characters.
        Map<Character, Integer> map = new HashMap<>();
        List<Node> list = new ArrayList<>();
        
        // put characters and corresponding frequencies into the map.
        int slength = s.length();
        for (int i = 0; i < slength; i++) {
            int count = map.getOrDefault(s.charAt(i), 0) + 1;
            map.put(s.charAt(i), count);
        }
        // Since map doesn't have order, so we put them in an array for further sorting.
        int mapSize = map.size();
        Node[] resultArray = new Node[mapSize];
        int count = 0;
        for (Character c : map.keySet()) {
            Node node = new Node(c, map.get(c));
            resultArray[count++] = node;
        }

        // Sort an array of Node based on their frequencies.
        for (int out = 1; out < mapSize; out++) {
            int in = out;
            Node temp = resultArray[out];
            while(in > 0 && resultArray[in - 1].frequency < temp.frequency) {
                resultArray[in] = resultArray[in - 1];
                in--;
            }
            if (in != out) {
                resultArray[in] = temp;
            }
        }
        
        // Construct the string output.
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < resultArray[i].frequency; j++) {
                result.append(resultArray[i].c);
            }
        }
        return result.toString();
    }
    
    // Node with character and their frequencies.
    private static class Node{
        public char c;
        public int frequency;
        
        Node(char c, int f) {
            this.c = c;
            frequency = f;
        }
    }
}