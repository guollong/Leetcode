/**
 * Question description: Given an array S of n integers, find three integers in S such that 
 *		the sum is closest to a given number, target. Return the sum of the three integers. 
 *		You may assume that each input would have exactly one solution.
 *
 * Example, given array S = {-1 2 1 -4}, and target = 1.
 *		The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 *
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

// Jinglong's solution based on 3 sum.
public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new LinkedList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int[] temp = new int[nums.length - i - 1];
                System.arraycopy(nums, i + 1, temp, 0, nums.length - i - 1);
                List<List<Integer>> threesumList = threeSum(temp, target - nums[i]);
                if (threesumList.size() > 0) {
                    for (int j = 0; j < threesumList.size(); j++) {
                        List<Integer> threesumSublist = new LinkedList<>(threesumList.get(j));
                        threesumSublist.set(0, nums[threesumSublist.get(0) + i + 1]);
                        threesumSublist.set(1, nums[threesumSublist.get(1) + i + 1]);
                        threesumSublist.set(2, nums[threesumSublist.get(2) + i + 1]);
                        threesumSublist.add(nums[i]);
                        result.add(threesumSublist);
                    }
                }
            }
        }
        return result;
    }
    
    private List<List<Integer>> threeSum(int[] num, int target) {
        List<List<Integer>> res = new LinkedList<>(); 
        for (int i = 0; i < num.length - 2; i++) {
            if (i == 0 || (i > 0 && num[i] != num[i - 1])) {
                int low = i + 1;
                int high = num.length - 1;
                int sum = 0;

                while (low < high) {
                    sum = num[low] + num[high] + num[i];
                    if (sum == target) {
                        res.add(Arrays.asList(i, low, high));
                        while (low < high && num[low] == num[low + 1]) {
                            low++;
                        }
                        while (low < high && num[high] == num[high - 1]) {
                            high--;
                        }
                        low++; 
                        high--;
                    } else if (sum < target) {
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


// Solution based on 3 sum and 2 sum.


