/**
 * Question description: Suppose Andy and Doris want to choose a restaurant for dinner, 
 *		and they both have a list of favorite restaurants represented by strings.
 *		You need to help them find out their common interest with the least list index sum. 
 *		If there is a choice tie between answers, output all of them with no order requirement. 
 *		You could assume there always exists an answer.
 *
 * Example: 
 * Input: ["Shogun", "Tapioca Express", "Burger King", "KFC"]
 *		  ["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
 * Output: ["Shogun"]
 * Explanation: The only restaurant they both like is "Shogun".
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; 
 * Company: .
 */

/**
 * Progress...
 * Create Date: 06/01/2017
 */

public class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        List<String> result = new ArrayList<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        int minSum = Integer.MAX_VALUE;
        for (int i = 0; i < list2.length; i++) {
            if (map.containsKey(list2[i])) {
                if (i + map.get(list2[i]) < minSum) {
                    minSum = i + map.get(list2[i]);
                    List<String> temp = new ArrayList<>();
                    temp.add(list2[i]);
                    result = temp;
                } else if (i + map.get(list2[i]) == minSum) {
                    result.add(list2[i]);
                }
            }
        }
        return result.toArray(new String[result.size()]);
    }
}






