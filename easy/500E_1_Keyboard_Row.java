/**
 * Question description: Given a List of words, return the words that can be typed 
 *  using letters of alphabet on only one row's of American keyboard.
 *
 * Example: Input: ["Hello", "Alaska", "Dad", "Peace"]; Output: ["Alaska", "Dad"]
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; 
 * Company: .
 */

/**
 * Progress...
 * Create Date: 06/01/2017
 */

// Approach 1: for every string in the array, check the first character belongs to which row
//      in the keyboard and then check the rest of the string.
public class Solution {
    public String[] findWords(String[] words) {
        // Define three rows of characters. Remember to convert the String to all lower case.
        String firstRow = "qwertyuiop";
        String secondRow = "asdfghjkl"; 
        String thirdRow = "zxcvbnm";
        List<String> res = new LinkedList<>();
        // Determine which row to search according to the first element.
        for (int i = 0; i < words.length; i++) {
            String element = words[i].toLowerCase();
            if (firstRow.contains("" + element.charAt(0))) {
                if (inTheSameRow(element, firstRow)) {
                    res.add(words[i]);
                }
            } else if (secondRow.contains("" + element.charAt(0))) {
                if (inTheSameRow(element, secondRow)) {
                    res.add(words[i]);
                }
            } else {
                if (inTheSameRow(element, thirdRow)) {
                    res.add(words[i]);
                }
            }
        }
        // Convert string list to string array.
        String[] result = res.toArray(new String[0]);
        return result;
    }
    
    private boolean inTheSameRow(String s, String template) {
        for (int j = 1; j < s.length(); j++) {
            if (!template.contains("" + s.charAt(j))) {
                return false;
            }
        }
        return true;
    }
}

// Approach 2: HashMap records the row number of characters.
public class Solution {
    public String[] findWords(String[] words) {
        String[] strs = {"QWERTYUIOP","ASDFGHJKL","ZXCVBNM"};
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++){
            for(char c : strs[i].toCharArray()){
                map.put(c, i);//put <char, rowIndex> pair into the map
            }
        }
        List<String> res = new LinkedList<>();
        for(String w : words){
            if (w.equals("")) {
                continue;
            }
            // get the row number of first character in the American keyboard.
            int index = map.get(w.toUpperCase().charAt(0));
            for(char c : w.toUpperCase().toCharArray()){
                if(map.get(c) != index){
                    index = -1; //don't need a boolean flag. 
                    break;
                }
            }
            if(index != -1) {
                res.add(w);     //if index != -1, this is a valid string
            }
        }
        return res.toArray(new String[0]);
    }
}

















