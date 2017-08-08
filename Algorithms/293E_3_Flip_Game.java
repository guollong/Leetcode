/**
 * Question description: You are playing the following Flip Game with your friend:
 * 		Given a string that contains two characters: + and -, you and your friend take turns to flip two consecutive "++" into "--". 
 * 		The game ends when a person can no longer make a move and therefore the other person will be the winner.
 * 		Write a function to compute all possible states of the string after one valid move.
 * For example, given s = "++++", after one move, it may become one of the following states: ["--++", "+--+", "++--"]
 * 		If there is no valid move, return an empty list [].
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; 
 * Company: Google.
 * Create Date: 02/24/2017
 * Update date: 06/13/2017
 */


public class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> result = new LinkedList<>();
        int i = 1;
        for ( ; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (curr == '+' && curr == s.charAt(i - 1)) {
                result.add(s.substring(0, i - 1) + "--" + s.substring(i + 1));
            }
        }
        return result;
    }
}

// 可以用s.indexOf("++", start position)来找子字符串首次出现的index
public class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> result = new LinkedList<>();
        int index = 0;
        while (index < s.length() - 1) {
            int position = s.indexOf("++", index);
            if (position < 0) {
                break;
            }
            result.add(s.substring(0, position) + "--" + s.substring(position + 2));
            index = position + 1;
        }
        return result;
    }
}




 




