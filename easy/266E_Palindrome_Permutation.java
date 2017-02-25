/**
 * Question description: Given a string, determine if a permutation of the string could form a palindrome.
 * 		Example: "code" -> False, "aab" -> True, "carerac" -> True.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; Company: .
 * Date: 02/24/2017
 */

// Improved method using hashset.
// 字母的个数要不然全部为偶数，要不然只有一个为奇数。用hashset可以把个数为偶数的字母抵消掉。
public class Solution {
    public boolean canPermutePalindrome(String s) {
        Set<Character> set=new HashSet<Character>();
        for(int i=0; i<s.length(); ++i){
            if (!set.contains(s.charAt(i)))
                set.add(s.charAt(i));
            else 
                set.remove(s.charAt(i));
        }
        return set.size()==0 || set.size()==1;
    }
}

// Jinglong's solution.
// USE HashMap. 统计每个字母出现的次数。
// 如果字符串长度为奇数，
public class Solution {
    public boolean canPermutePalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }
        
        int testBit = 0;
        if (s.length() % 2 == 1) {
            for (Integer frequency : map.values()) {
                if (frequency % 2 == 1) {
                    testBit++;
                }
            }
            if (testBit > 1) {
                return false;
            }
            return true;
            
        } else {
            for (Integer frequency : map.values()) {
                if (frequency % 2 == 1) {
                    return false;
                }
            }
            return true;
        }
    }
}

