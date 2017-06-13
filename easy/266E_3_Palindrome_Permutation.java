/**
 * Question description: Given a string, determine if a permutation of the string could form a palindrome.
 * 		Example: "code" -> False, "aab" -> True, "carerac" -> True.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; 
 * Company: Google, Uber, Bloomberg.
 * Create Date: 02/24/2017
 * Update date: 06/13/2017
 */

// Solution 1: Sort first and count. Most effective.
public class Solution {
    public boolean canPermutePalindrome(String s) {
        char[] sArray = s.toCharArray();
        Arrays.sort(sArray);
        int oddCount = 0;
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            if (sArray[i] != sArray[i - 1]) {
                if (count % 2 == 1) {
                    oddCount++;
                }
                count = 1;
            } else {
                count++;
            }
        }
        if (count % 2 == 1) {
            oddCount++;
        }
        return oddCount <= 1;
    }
}

// Solution 2: USE HashMap. Get the count of each character and there could only have 1 or 0 characters which have odd count.
public class Solution {
    public boolean canPermutePalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char key = s.charAt(i);
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }
        int oddCount = 0;
        for (int count : map.values()) {
            if (count % 2 == 1) {
                oddCount++;
            }
        }
        return oddCount <= 1;
    }
}

// Solution 3: Improved method using hashset. 
public class Solution {
    public boolean canPermutePalindrome(String s) {
        Set<Character> set = new HashSet<Character>();
        for(int i = 0; i < s.length(); ++i){
            if (!set.contains(s.charAt(i)))
                set.add(s.charAt(i));
            else 
                set.remove(s.charAt(i));
        }
        return set.size() == 0 || set.size() == 1;
    }
}


