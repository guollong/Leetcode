/**
 * Question description: All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for 
 *		example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within 
 *		the DNA. Write a function to find all the 10-letter-long sequences (substrings) that occur more than 
 *		once in a DNA molecule.
 * 
 * Example: Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",
 *		Return: ["AAAAACCCCC", "CCCCCAAAAA"].
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: . 
 */

/**
 * Progress...
 * Create Date: 08/31/2017
 */

// Idea: Get all 10-letter long substrings, put them into a set, if the set has the element, if will return false
//		while adding new element, so we add the element into the result. (Attention that the result cannot have duplicates.)
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> result = new HashSet<>();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < s.length() - 10 + 1; i++) {
            String sub = s.substring(i, i + 10);
            if (!set.add(sub)) {
                result.add(sub);
            }
        }
        return new ArrayList<String>(result);
    }
}



