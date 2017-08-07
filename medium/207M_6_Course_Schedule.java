/**
 * Question description: There are a total of n courses you have to take, labeled from 0 to n - 1. Some courses 
 *		may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed 
 *		as a pair: [0,1]. Given the total number of courses and a list of prerequisite pairs, is it possible for 
 *		you to finish all courses?
 *
 * Example 1: 2, [[1,0]]
 * 		There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.
 *
 * Example 2: 2, [[1,0],[0,1]]
 *		There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course 
 *		0 you should also have finished course 1. So it is impossible.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: Apple, Yelp, Zenefits. 
 */

/**
 * Progress...
 * Create Date: 08/06/2017
 */

// Best solution: Topological sorting and BFS.
// Use adjacency list to represent directed graph.
// 主要是list array用的好。。。。
public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Use adjacency list to represent directed graph.
        List<Integer>[] graph = new ArrayList[numCourses];
        int[] degree = new int[numCourses];
        
        // Initialization and build graph.
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        for(int i = 0; i < prerequisites.length; i++){
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
            degree[prerequisites[i][0]]++;
        }
        
        // Perform BFS to check if there is any circle in the directed graph.
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 0) {
                queue.add(i);
            }
        }
        
        while (!queue.isEmpty()) {
            int course = queue.poll();
            count++;
            for(int i = 0; i < graph[course].size(); i++){
                int pointer = graph[course].get(i);
                degree[pointer]--;
                if (degree[pointer] == 0) {
                    queue.add(pointer);
                }
            }
        }
        return count == numCourses;
    }
}


// Solution 2: Topological sorting and BFS.
// Use adjacency matrix to represent directed graph.
// 效率和下面的方法相同。。。。
public class Solution {
    // Topological sorting.
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses <= 1 || prerequisites.length == 0) {
            return true;
        }
        // Represent a graph using adjacency matrix.
        int[][] graph = new int[numCourses][numCourses];
        int[] degree = new int[numCourses];
        
        for (int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][0];
            int pre = prerequisites[i][1];
            graph[pre][course] = 1;
            degree[course]++;
        }
        
        // Perform BFS and check if output length is equal to the number of courses.
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++) {
            if (degree[i] == 0) {
                queue.offer(i);
            }
        }
        
        int count = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            count++;
            for (int j = 0; j < numCourses; j++) {
                if (graph[course][j] == 1) {
                    degree[j]--;
                    if (degree[j] == 0) {
                        queue.add(j);
                    }
                }
            }
        }
        return count == numCourses;
    }
}
// Solution 3: Topological sorting and BFS.
// Use adjacency list to represent directed graph.
// Use map to represent graph, key is node and value is a set of linked-out node. But here, we may don't
//		need to avoid duplicates.
public class Solution {
    // Topological sorting.
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses <= 1 || prerequisites.length == 0) {
            return true;
        }
        // Represent a graph using adjacency list.
        Map<Integer, Set<Integer>> map = new HashMap<>();
        Map<Integer, Integer> degree = new HashMap<>();
        
        // Initialization: initially the degree of each courses is 0.
        for (int i = 0; i < numCourses; i++) {
            degree.put(i, 0);
        }
        
        for (int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][0];
            int pre = prerequisites[i][1];
            Set<Integer> tempSet;
            if (map.containsKey(pre)) {
                tempSet = map.get(pre);
            } else {
                tempSet = new HashSet<Integer>();
            }
            if (!tempSet.contains(course)) {
                tempSet.add(course);
                map.put(pre, tempSet);
                degree.put(course, degree.get(course) + 1);
            }
        }
        
        // Perform BFS and check if output length is equal to the number of courses.
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int course : degree.keySet()) {
            if (degree.get(course) == 0) {
                queue.offer(course);
            }
        }
        
        int count = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            count++;
            if (map.containsKey(course)) {
                for (int c : map.get(course)) {
                    degree.put(c, degree.get(c) - 1);
                    if (degree.get(c) == 0) {
                        queue.add(c);
                    }
                }
            }
        }
        return count == numCourses;
    }
}






