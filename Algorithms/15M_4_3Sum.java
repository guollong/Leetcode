/**
 * Question description: Given an array S of n integers, are there elements a, b, c in S such that 
 *		a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * 
 * Note: The solution set must not contain duplicate triplets.
 * 
 * Example, given array S = [-1, 0, 1, 2, -1, -4],
 *	A solution set is:
 *	[
 *	  [-1, 0, 1],
 *	  [-1, -1, 2]
 *	]
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: Amazon, Microsoft, Bloomberg, Facebook, Adobe, Works Applications.
 */

/**
 * Progress...
 * Create Date: 06/20/2017
 */

// Solution with 2 sum.
public class Solution {
    public List<List<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> res = new LinkedList<>(); 
        for (int i = 0; i < num.length - 2; i++) {
        	// Avoid duplicates.
            if (i == 0 || (i > 0 && num[i] != num[i - 1])) {
                int[] temp = new int[num.length - i - 1];
                System.arraycopy(num, i + 1, temp, 0, num.length - i -1);
                List<List<Integer>> twosumList = twoSum(temp, - num[i]);
                if (twosumList.size() > 0) {
                    for (int j = 0; j < twosumList.size(); j++) {
                        List<Integer> twosumSublist = new LinkedList<>(twosumList.get(j));
                        twosumSublist.set(0, num[twosumSublist.get(0) + i + 1]);
                        twosumSublist.set(1, num[twosumSublist.get(1) + i + 1]);
                        twosumSublist.add(num[i]);
                        res.add(twosumSublist); 
                    }
                }
            }
        }
        return res;
    }
    
    // Two sum: return the index of two elements that sum to target.
    private List<List<Integer>> twoSum(int[] num, int target) {
        List<List<Integer>> result = new LinkedList<>();
        int left = 0;
        int right = num.length - 1;
        int sum = 0;
        while (left < right) {
            sum = num[left] + num[right];
            if (sum == target) {
                result.add(Arrays.asList(left, right));
                // Attention here: Also avoid duplicates.
                while (left < right && num[left] == num[left + 1]) {
                    left++;
                }
                while (left < right && num[right] == num[right - 1]) {
                    right--;
                }
                        
                left++;
                right--;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return result;
    }
}


// Solution from discussion.
public class Solution {
    public List<List<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> res = new LinkedList<>(); 
        for (int i = 0; i < num.length - 2; i++) {
            // To avoid duplicates, skip the same values.
            if (i == 0 || (i > 0 && num[i] != num[i - 1])) {
                int low = i + 1;
                int high = num.length - 1;
                int sum = 0 - num[i];
                
                // Find triplets that have element num[i]. 
                // Arrays.asList(...) could form a list with certain elements.
                while (low < high) {
                    if (num[low] + num[high] == sum) {
                        res.add(Arrays.asList(num[i], num[low], num[high]));
                        while (low < high && num[low] == num[low + 1]) {
                            low++;
                        }
                        while (low < high && num[high] == num[high - 1]) {
                            high--;
                        }
                        low++; 
                        high--;
                    } else if (num[low] + num[high] < sum) {
                        low++;
                    } else {
                        high--;
                    }
               }
            }
        }
        return res;
    }
}