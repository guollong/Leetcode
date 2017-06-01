/**
 * Question description: Assume you are an awesome parent and want to give your children some cookies.
 * 		But, you should give each child at most one cookie. Each child i has a greed factor gi, which 
 *		is the minimum size of a cookie that the child will be content with; and each cookie j has a 
 *		size sj. If sj >= gi, we can assign the cookie j to the child i, and the child i will be content.
 *		Your goal is to maximize the number of your content children and output the maximum number.
 *
 * Note: You may assume the greed factor is always positive. 
 * 		 You cannot assign more than one cookie to one child.
 * Example:
 * 		Input: [1,2,3], [1,1]; Output: 1 ([1,2,3]: child greed factor; [1,1]: cookies number).
 * 		Input: [1,2], [1,2,3]; Output: 2
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; 
 * Company: .
 * Date: 03/13/2017
 */

// Solution from discussion.
// s: the array of sizes of supply cookies.
// g: the array of greedies of each children.
// Idea: loop the supply array, when the element is bigger than one child's greedy, increase 1 to the index of
// children' greedies and find a supplier to the next child.
public class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int gi = 0;
        for (int si = 0; gi < g.length && si < s.length; si++) {
            if (g[gi] <= s[si]) {
                gi++;
            }
        }
        return gi;
    }
}
     


