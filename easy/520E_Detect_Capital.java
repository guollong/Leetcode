/**
 * Question description: Given a word, you need to judge whether the usage of capitals in it is right or not.
 * 		We define the usage of capitals in a word to be right when one of the following cases holds:
 * 			All letters in this word are capitals, like "USA".
 * 			All letters in this word are not capitals, like "leetcode".
 * 			Only the first letter in this word is capital if it has more than one letter, like "Google".
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; Company: .
 * Date: 02/24/2017
 */


// Forget to check if the word only has single letter.
// two cases: 1. the first letter is upper case; 2: the first letter is lower case.
public class Solution {
    public boolean detectCapitalUse(String word) {
        if (word.length() == 1) {
            return true;
        }
        char[] wordArray = word.toCharArray();
        char firstLetter = wordArray[0];
        if (firstLetter >= 'A' && firstLetter <= 'Z') {
            if (wordArray[1] >= 'A' && wordArray[1] <= 'Z') {
                for (int i = 2; i < wordArray.length; i++) {
                    if (wordArray[i] < 'A' || wordArray[i] > 'Z') {
                        return false;
                    }
                }
                return true;
            } else if (wordArray[1] >= 'a' && wordArray[1] <= 'z') {
                for (int i = 2; i < wordArray.length; i++) {
                    if (wordArray[i] < 'a' || wordArray[i] > 'z') {
                        return false;
                    }
                }
                return true;
            } 
        } else if (firstLetter >= 'a' && firstLetter <= 'z') {
            for (int i = 1; i < wordArray.length; i++) {
                if (wordArray[i] < 'a' || wordArray[i] > 'z') {
                    return false;
                }
            }
            return true;
            
        }
        return false;
    }
}





