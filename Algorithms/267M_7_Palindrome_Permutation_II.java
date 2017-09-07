/**
 * Question description: Given a string s, return all the palindromic permutations (without duplicates) of it. 
 *		Return an empty list if no palindromic permutation could be form.
 * 
 * Example: Given s = "aabb", return ["abba", "baab"].
 *			Given s = "abc", return [].
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: 暂时无.
 */

/**
 * Progress...
 * Create Date: 09/06/2017
 */

// Solution: The combination of "palindrome permutation 1" and permutation with duplicates.
class Solution {
    // Idea:
    //  Step 1: Check if the string could from a palindrome (Using hashmap)
    //  Step 2: Take out all elements with half (count / 2), form the permutation with duplicates.
    //  Step 3: Form the palindromes based on the permutation we get from step2.
    public List<String> generatePalindromes(String s) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder(); // the combination of the half palindrome.
        
        // Step 1.
        Map<Character, Integer> map = new HashMap<>();
        int oddCount = 0;
        String oddChar = "";
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char key : map.keySet()) {
            int count = map.get(key);
            if (count % 2 == 1) {
                oddCount++;
                oddChar += key;
            }
            for (int i = 0; i < count / 2; i++) {
                sb.append(key);
            }
        }
        
        if (oddCount > 1) {
            return result;
        }
        
        // Step 2.
        List<String> permute = permutation(sb.toString());
        
        // Step 3: Form the result.
        for (String sub : permute) {
            StringBuilder palindrome = new StringBuilder(sub);
            result.add(sub + oddChar + palindrome.reverse().toString());
        }
        return result;
    }
    
    private List<String> permutation(String s) {
        List<String> result = new ArrayList<>();
        permutationHelper(result, "", s, s.length());
        return result;
    }
    
    private void permutationHelper(List<String> result, String sub, String s, int n) {
        if (sub.length() == n) {
            result.add(sub);
            return;
        }
        
        for (int i = 0; i < s.length(); i++) {
            if (i != 0 && s.charAt(i) == s.charAt(i - 1)) {
                continue;
            }
            sub = sub + s.charAt(i);
            permutationHelper(result, sub, s.substring(0, i) + s.substring(i + 1), n);
            sub = sub.substring(0, sub.length() - 1);
        }
    }
}



