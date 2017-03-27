/**
 * Question description: Given a roman numeral, convert it to an integer.
 * 			Input is guaranteed to be within the range from 1 to 3999.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; Company: .
 * Date: 03/26/2017
 */

// Some regulations of roman numbers.
// Symbol	I	V	X	L	C	D	M
// Value	1	5	10	50	100	500	1,000
// 计数规则：
//      相同的数字连写，所表示的数等于这些数字相加得到的数，例如：III = 3
//      小的数字在大的数字右边，所表示的数等于这些数字相加得到的数，例如：VIII = 8
//      小的数字，限于（I、X和C）在大的数字左边，所表示的数等于大数减去小数所得的数，例如：IV = 4
//      正常使用时，连续的数字重复不得超过三次
//      在一个数的上面画横线，表示这个数扩大1000倍（本题只考虑3999以内的数，所以用不到这条规则

public class Solution {
    public int romanToInt(String s) {
        
        char[] romanArray = s.toCharArray();
        int sum = getInt(romanArray[0]);
        for (int i = 1; i < s.length(); i++) {
            char temp = romanArray[i - 1];
            if ((temp == 'I' || temp == 'X' || temp == 'C') && getInt(romanArray[i]) > getInt(temp)) {
                sum = sum + getInt(romanArray[i]) - 2 * getInt(temp);
            } else {
                sum += getInt(romanArray[i]);
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



