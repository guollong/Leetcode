/**
 * Question description: The string "PAYPALISHIRING" is written in a zigzag pattern on a given 
 *		number of rows like this: (you may want to display this pattern in a fixed font for 
 *		better legibility)
 * 
 *	P   A   H   N
 *	A P L S I I G
 * 	Y   I   R
 *
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given a number of rows:
 * 
 * Example: string convert(string text, int nRows);
 *			convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: 暂时无.
 */

/**
 * Progress...
 * Create Date: 06/20/2017
 */

// Solution from discussion. Build a stringbuilder(or StringBuffer) array with "nRows" elements. 
//		Loop over the whole string, append the characters to cooresponding stringbuilder element.
//		Finally, append all stringbuilders to the first element and return it.
public class Solution {
    public String convert(String s, int nRows) {
        char[] c = s.toCharArray();
        int length = s.length();
        StringBuilder[] sb = new StringBuilder[nRows];
        for (int i = 0; i < sb.length; i++) {
            sb[i] = new StringBuilder();
        }
        
        int i = 0;
        while (i < length) {
            for (int idx = 0; idx < nRows && i < length; idx++) {
                sb[idx].append(c[i++]);
            }// vertically down
            for (int idx = nRows-2; idx >= 1 && i < length; idx--) {
                sb[idx].append(c[i++]);
            }// obliquely up
        }
        for (int idx = 1; idx < sb.length; idx++) {
            sb[0].append(sb[idx]);
        }
        return sb[0].toString();
    }
}

// Jinglong's Solution.
public class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        List<String> stringlist = new ArrayList<>();
        String temp = s;
        int number = 2 * numRows - 2; 
        while (temp.length() != 0) {
            // The left string length is greater than number.
            if (temp.length() >= number) {
                stringlist.add(temp.substring(0, numRows));
                stringlist.add(reverseString(temp.substring(numRows, number)));
                temp = temp.substring(number);
            } else if (temp.length() > numRows) {
                stringlist.add(temp.substring(0, numRows));
                stringlist.add(reverseString(temp.substring(numRows)));
                temp = "";
            } else if (temp.length() > 0 && stringlist.size() % 2 == 1) {
                stringlist.add(reverseString(temp));
                temp = "";
            } else if (temp.length() > 0 && stringlist.size() % 2 != 1) {
                stringlist.add(temp);
                temp = "";
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            if (i == 0 || i == numRows - 1) {
                for (int j = 0; j < stringlist.size(); j += 2) {
                    // 最后一个string可能有缺的元素。
                    temp = stringlist.get(j);
                    if (i < temp.length()) {
                        result.append(temp.charAt(i));
                    }
                }
            } else {
                for (int j = 0; j < stringlist.size(); j++) {
                    // 最后一个string可能有缺的元素。
                    temp = stringlist.get(j);
                    if (j != stringlist.size() - 1 && j % 2 == 1 && i - 1 < temp.length()) {
                        result.append(temp.charAt(i - 1));
                    } else if (j % 2 == 0 && i < temp.length()) {
                        result.append(temp.charAt(i));
                    }
                    int diff = numRows - 2 - temp.length();
                    if (j == stringlist.size() - 1 && j % 2 == 1 && i - diff - 1 >= 0) {
                        result.append(temp.charAt(i - diff - 1));
                    }
                }
            }
        }
        return result.toString();
    }
    
    private String reverseString(String s) {
        StringBuilder s1 = new StringBuilder(s);
        return s1.reverse().toString();
    }
}

