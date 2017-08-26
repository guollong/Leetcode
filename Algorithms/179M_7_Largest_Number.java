/**
 * Question description: Given a list of non negative integers, arrange them such that they form the largest number.
 * 
 * Example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
 * 
 * Note: The result may be very large, so you need to return a string instead of an integer.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: Works Applications. 
 */

/**
 * Progress...
 * Create Date: 08/25/2017
 */

class Solution {
    public String largestNumber(int[] nums) {
        String[] sNums = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            sNums[i] = nums[i] + "";
        }
        
        // The most important part.
        Comparator<String> myComparator = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                String con1 = s1 + s2;
                String con2 = s2 + s1;
                return con2.compareTo(con1);
            }
        };
        
        Arrays.sort(sNums, myComparator);
        
        // Corner case: when the number sequence are all 0s, return 0.
        if (sNums[0].charAt(0) == '0') {
            return "0";
        }
        
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < sNums.length; i++) {
            result.append(sNums[i]);
        }
        return result.toString();
    }
}



