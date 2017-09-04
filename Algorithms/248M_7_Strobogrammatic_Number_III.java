/**
 * Question description: A strobogrammatic number is a number that looks the same when rotated 180 degrees 
 *		(looked at upside down). Write a function to count the total strobogrammatic numbers that exist in 
 *		the range of low <= num <= high.
 *
 * Example: Given low = "50", high = "100", return 3. Because 69, 88, and 96 are three strobogrammatic numbers.
 *
 * Note: Because the range might be a large number, the low and high numbers are represented as string.
 *
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: Google.
 */

/**
 * Progress...
 * Create Date: 09/03/2017
 */

// Solution 1: Use DFS.
class Solution {
    private static final char[][] pairs = {{'0', '0'}, {'1', '1'}, {'6', '9'}, {'8', '8'}, {'9', '6'}};
    
    public int strobogrammaticInRange(String low, String high) {
        int[] count = {0};
        for (int len = low.length(); len <= high.length(); len++) {
            char[] chars = new char[len];
            dfs(low, high, chars, 0, len - 1, count);
        }
        return count[0];
    }
    
    public void dfs(String low, String high, char[] chars, int left, int right, int[] count) {
        if (left > right) {
            String s = new String(chars);
            if ((s.length() == low.length() && s.compareTo(low) < 0) || 
                (s.length() == high.length() && s.compareTo(high) > 0)) {
                return;
            }
            count[0]++;
            return;
        }
        for (char[] p : pairs) {
            chars[left] = p[0];
            chars[right] = p[1];
            if (chars.length != 1 && chars[0] == '0') {
                continue;
            }
            if (left == right && p[0] != p[1]) {
                continue;
            }
            dfs(low, high, chars, left + 1, right - 1, count);
        }
    }
}


// Solution 2: Use the idea in Strobogrammatic Number II. Find all numbers where number of digits are from the 
//      length of low to the length of the high. Count numbers in the list which are in the range.
class Solution {
    public int strobogrammaticInRange(String low, String high) {
        int lenLow = low.length();
        int lenHigh = high.length();
        int count = 0;
        List<String> result = new ArrayList<>();
        for (int i = lenLow; i <= lenHigh; i++) {
            List<String> list = strobogrammatic(i);
            result.addAll(list);
        }
        
        for (String number : result) {
            if ((number.length() == lenLow && number.compareTo(low) < 0)) {
                continue;
            }
            if ((number.length() == lenHigh && number.compareTo(high) > 0)) {
                continue;
            }
            count++;
        }
        return count;
    }
    
    private List<String> strobogrammatic(int n) {
        return strobogrammaticHelper(n, n);
    }
    
    private List<String> strobogrammaticHelper(int n, int m) {
        if (n == 0) {
            return new ArrayList<>(Arrays.asList(""));
        }
        if (n == 1) {
            return new ArrayList<>(Arrays.asList("0", "1", "8"));
        }
        
        List<String> list = strobogrammaticHelper(n - 2, m);
        List<String> result = new ArrayList<>();
        for (String s : list) {
            if (n != m) {
                result.add("0" + s + "0");
            }
            result.add("1" + s + "1");
            result.add("6" + s + "9");
            result.add("8" + s + "8");
            result.add("9" + s + "6");
        }
        return result;
    }
}


// Solution 3: Use DFS to get all possible numbers, and count the numbers in range. 
//	(效率很低，但是是按照自己想法实现的一个dfs，可以用作以后参考。)
class Solution {
    private List<String> stroboChar = new ArrayList<>(Arrays.asList("0", "1", "6", "8", "9"));
    
    public int strobogrammaticInRange(String low, String high) {
        int lenLow = low.length();
        int lenHigh = high.length();
        
        List<String> result = new ArrayList<>();
        for (int i = lenLow; i <= lenHigh; i++) {
            List<String> list = dfs(i);
            for (String s : list) {
                if (s.equals("")) {
                    break;
                }
                String sub = formStrobo(s);
                if (i % 2 == 0) {
                    result.add(sub);
                } else {
                    result.add(sub.substring(0, i / 2 + 1) + "0" + sub.substring(i / 2 + 1));
                    result.add(sub.substring(0, i / 2 + 1) + "1" + sub.substring(i / 2 + 1));
                    result.add(sub.substring(0, i / 2 + 1) + "8" + sub.substring(i / 2 + 1));
                }
            }
            if (i == 1) {
                result.add("0");
                result.add("1");
                result.add("8");
            }
        }

        // count the numbers in range.
        int count = 0;
        for (String number : result) {
            if ((number.length() == lenLow && number.compareTo(low) < 0)) {
                continue;
            }
            if ((number.length() == lenHigh && number.compareTo(high) > 0)) {
                continue;
            }
            count++;
        }
        
        return count;
    }
    
    private String formStrobo(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '6') {
                sb.append("9");
            } else if (s.charAt(i) == '9') {
                sb.append("6");
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
    
    private List<String> dfs(int n) {
        List<String> result = new ArrayList<>();
        dfsHelper(result, n, "");
        return result;
    }
    
    private void dfsHelper(List<String> result, int n, String sub) {
        if (sub.length() == n / 2) {
            result.add(sub);
            return;
        }
        int i = 0;
        if (n != 1 && sub.length() == 0) {
            i = 1;
        }
        for (; i < stroboChar.size(); i++) {
            sub = sub + stroboChar.get(i);
            dfsHelper(result, n, sub);
            sub = sub.substring(0, sub.length() - 1);
        }
    }
}



