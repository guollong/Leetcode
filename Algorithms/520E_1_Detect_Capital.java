/**
 * Question description: Given a word, you need to judge whether the usage of capitals in it is right or not.
 * 		We define the usage of capitals in a word to be right when one of the following cases holds:
 * 			All letters in this word are capitals, like "USA".
 * 			All letters in this word are not capitals, like "leetcode".
 * 			Only the first letter in this word is capital if it has more than one letter, like "Google".
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; 
 * Company: Google.
 * Date: 02/24/2017
 */

// three cases: 1. string only has one letter 2: The first two letters are upper case; 3. left cases
public class Solution {
    public boolean detectCapitalUse(String word) {
        if (word.length() <= 1) {
            return true;
        }
        char[] charWord = word.toCharArray();
        for (int i = 0; i < word.length(); i++) {
            if (charWord[0] < 97 && charWord[1] < 97) {
                for (int j = 2; j < word.length(); j++) {
                    if (charWord[j] >= 97) {
                        return false;
                    }
                }
            } else {
                for (int j = 1; j < word.length(); j++) {
                    if (charWord[j] < 97) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}

// one line solution: 正则表达式
// "+" represents for the numbers of characters.
// 该表达式意义：均为大写 | 均为小写 | 第一个大写并且其余均为小写。
public class Solution {
    public boolean detectCapitalUse(String word) {
        return word.matches("[A-Z]+|[a-z]+|[A-Z][a-z]+");
    }
}

