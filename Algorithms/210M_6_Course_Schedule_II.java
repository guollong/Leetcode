/**
 * Question description: There are a total of n courses you have to take, labeled from 0 to n - 1. Some courses 
 *		may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed 
 *		as a pair: [0,1]. 
 *	Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should 
 *		take to finish all courses. There may be multiple correct orders, you just need to return one of them. 
 *		If it is impossible to finish all courses, return an empty array.
 *
 * Example 1: 2, [[1,0]]
 *	There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1]
 * 
 * Example 2: 4, [[1,0],[2,0],[3,1],[3,2]]
 *	There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. 
 *		Both courses 1 and 2 should be taken after you finished course 0. So one correct course order is [0,1,2,3]. 
 *		Another correct ordering is[0,2,1,3].
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: Facebook, Zenefits. 
 */

/**
 * Progress...
 * Create Date: 08/06/2017
 */

public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Use adjacency list to represent directed graph.
        List<Integer>[] graph = new ArrayList[numCourses];
        int[] degree = new int[numCourses];
        
        // Initialization and build graph.
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < prerequisites.length; i++) {
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
            degree[prerequisites[i][0]]++;
        }
        
        // Perform BFS to find the order of courses to take.
        Queue<Integer> queue = new LinkedList<>();
        int[] result = new int[numCourses];
        int index = 0;
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 0) {
                queue.add(i);
            }
        }
        
        while (!queue.isEmpty()) {
            int course = queue.poll();
            result[index++] = course;
            for(int i = 0; i < graph[course].size(); i++){
                int pointer = graph[course].get(i);
                degree[pointer]--;
                if (degree[pointer] == 0) {
                    queue.add(pointer);
                }
            }
        }

        // Attention here: If the graph has circle, we cannot take all courses, so return [].
        if (index != numCourses) {
            return new int[0];
        }
        return result;
    }
}




