/**
 * Question description: You are playing the following Bulls and Cows game with your friend: You write down a number and 
 *		ask your friend to guess what the number is. Each time your friend makes a guess, you provide a hint that indicates 
 *		how many digits in said guess match your secret number exactly in both digit and position (called "bulls") and how 
 *		many digits match the secret number but locate in the wrong position (called "cows"). Your friend will use successive 
 *		guesses and hints to eventually derive the secret number.
 *
 * Example 1: Secret number:  "1807", Friend's guess: "7810", return "1A3B".
 *		(A represents for the bulls, and B represents for the cows)
 * 
 * Example 2: Secret number:  "1123", Friend's guess: "0111", return "1A1B".
 * 
 * You may assume that the secret number and your friend's guess only contain digits, and their lengths are always equal.
 *
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: 暂时无.
 */

/**
 * Progress...
 * Create Date: 09/02/2017
 */

// Solution 1: Two passes.
class Solution {
    public String getHint(String secret, String guess) {
        int bull = 0;
        int cow = 0;
        
        // 1st pass: Create a frequency map for elements which are not bulls. (Template)
        int[] template = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            if (guess.charAt(i) == secret.charAt(i)) {
                bull++;
            } else {
                template[secret.charAt(i) - '0']++;
            }
        }
        
        // 2nd pass: Compute the number of cows. For those who are not match the secret, get how many 
        //  elements are existed in secret (template).
        for (int i = 0; i < guess.length(); i++) {
            if (guess.charAt(i) != secret.charAt(i)) {
                if (template[guess.charAt(i) - '0'] > 0) {
                    cow++;
                    template[guess.charAt(i) - '0']--;
                }
            }
        }
        return bull + "A" + cow + "B";
    }
}

// Solution 2: One pass.
// 神奇啦。。。。。
class Solution {
    public String getHint(String secret, String guess) {
        int bull = 0;
        int cow = 0;
        
        int[] numbers = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            int s = secret.charAt(i) - '0';
            int g = guess.charAt(i) - '0';
            if (s == g) {
                bull++;
            } else {
                // Increment cows when either number from secret was already seen in guess or vice versa.
                if (numbers[s] < 0) {
                    cow++;
                }
                if (numbers[g] > 0) {
                    cow++;
                }
                numbers[s]++;
                numbers[g]--;
            }
        }
        
        return bull + "A" + cow + "B";
    }
}



