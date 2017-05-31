/**
 * Question description: Given a roman numeral, convert it to an integer.
 * 			Input is guaranteed to be within the range from 1 to 3999.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; 
 * Company: Microsoft, Bloomberg, Uber, Facebook, Yahoo.
 */

/**
 * Progress......
 * Create date: 03/26/2017
 * Update Date 1: 05/30/2017 (final version)
 *      (problem: Don't know the rules and forget the solution)
 */

/**
 * Rules: 
 * (1). Basic symbol values:
        Symbol	I	V	X	L	C	D	M
        Value   1	5	10	50	100	500	1,000
 * (2). Symbols are placed from left to right in order of value, starting with the largest.
 * (3). In a few specific cases, to avoid confusing and hard to read numbers with four characters 
        repeated in succession (such as IIII or XXXX), subtractive notation is used:
        Number	        4	9	40	90	400	900
        Notation        IV	IX	XL	XC	CD	CM
 * (4). 在一个数的上面画横线，表示这个数扩大1000倍（本题只考虑3999以内的数，所以用不到这条规则）
 * (5). Examples: XIII: 8; MCMIV: 1904; IV: 4;
 */

/**
 * Methodology:
 * (1). Create a switch case table to look up the value of different symbols.
 * (2). Loop over the input roman number, add symbol value to the output integer. However, if the
 *      previous symbol is 'I', 'X' or 'C' and the cooresponding value of the previous symbol is 
 *      smaller than the current symbol, substract double value of the previous symbol.
 */

public class Solution {
    public int romanToInt(String s) {
        char[] sArray = s.toCharArray();
        int sum = getInt(sArray[0]);
        for (int i = 1; i < s.length(); i++) {
            sum += getInt(sArray[i]);
            char pre = sArray[i - 1];
            if ((pre == 'I' || pre == 'X' || pre == 'C') && getInt(pre) < getInt(sArray[i])) {
                sum -= 2 * getInt(pre);
            }
        }
        return sum;
    }
    
    private int getInt(char romanChar) {
        int temp = 0;
        switch (romanChar) {
            case 'I': temp = 1;
                    break;
            case 'V': temp = 5;
                    break;
            case 'X': temp = 10;
                    break;
            case 'L': temp = 50;
                    break;
            case 'C': temp = 100;
                    break;
            case 'D': temp = 500;
                    break;
            case 'M': temp = 1000;
        }
        return temp;
    }
}



