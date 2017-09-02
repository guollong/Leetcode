/**
 * Question description: Given a string of numbers and operators, return all possible results from computing all the 
 *		different possible ways to group numbers and operators. The valid operators are +, - and *.
 * 
 * Example 1: Input: "2-1-1"; Output: [0, 2]
 * 	Explaination: ((2-1)-1) = 0; (2-(1-1)) = 2
 * 
 * Example 2: Input: "2*3-4*5"; Output: [-34, -14, -10, -10, 10]
 * 	Explaination:
 *	(2*(3-(4*5))) = -34
 *	((2*3)-(4*5)) = -14
 *	((2*(3-4))*5) = -10
 *	(2*((3-4)*5)) = -10
 *	(((2*3)-4)*5) = 10
 *
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: 暂时无.
 */

/**
 * Progress...
 * Create Date: 09/01/2017
 */

// Divide and Conquer.
class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                String part1 = input.substring(0, i);
                String part2 = input.substring(i + 1, input.length());
                List<Integer> list1 = diffWaysToCompute(part1);
                List<Integer> list2 = diffWaysToCompute(part2);
                for (int res1 : list1) {
                    for (int res2 : list2) {
                        int res = 0;
                        switch (c) {
                            case '+':
                                res = res1 + res2;
                                break;
                            case '-':
                                res = res1 - res2;
                                break;
                            case '*':
                                res = res1 * res2;
                                break;
                        }
                        result.add(res);
                    }
                }
            }
        }
        if (result.size() == 0) {
            result.add(Integer.valueOf(input));
        }
        return result;
    }
}

