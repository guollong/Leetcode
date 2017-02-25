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
 * Difficulty: Easy; Company: .
 * Date: 02/24/2017
 */

// 正确使用stringbuilder，在循环的时候使用。
// 截取字符串举例：s.substring(0,2);
public class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> result = new LinkedList<>();
        for (int i = 0; i < s.length() - 1;) {
            if (s.charAt(i) == '+' && s.charAt(i + 1) == '+') {
                result.add(s.substring(0, i) + "--" + s.substring(i + 2, s.length()));
                i++;
            } else if (s.charAt(i) == '-' && s.charAt(i + 1) == '+') {
                i++;
            } else {
                i = i + 2;
            }
        }
        return result;
    }
}

// 可以用s.indexOf("++", start position)来找子字符串首次出现的index
public class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        List list = new ArrayList();
        for (int i=-1; (i = s.indexOf("++", i+1)) >= 0; )
            list.add(s.substring(0, i) + "--" + s.substring(i+2));
        return list;
    }
}




 




