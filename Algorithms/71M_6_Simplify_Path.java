/**
 * Question description: Given an absolute path for a file (Unix-style), simplify it.
 * 
 * Example: path = "/home/", => "/home"
 *		path = "/a/./b/../../c/", => "/c"
 * 
 *	Corner case: Input: "/../"; output: "/";         // no directory to go back.
 *		Input: "/home//foo/"; Output: "/home/foo";  // multiple "/"s, treat it as one "/".
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: Microsoft, Facebook.
 */

/**
 * Progress...
 * Create Date: 08/24/2017
 */

// Solution 1: Using stack. (Push all valid words into the stack.)
// Simple to understand.
class Solution {
    public String simplifyPath(String path) {
        String[] pathArray = path.split("/");
        Set<String> skip = new HashSet<>(Arrays.asList("", ".", ".."));
        StringBuilder result = new StringBuilder();
        
        // Loop over the whole path array to fill the stack.
        Stack<String> stack = new Stack<>();
        for (String s : pathArray) {
            if (s.equals("..") && !stack.empty()) {
                stack.pop();
            } else if (!skip.contains(s)) {
                stack.push(s);
            }
        }
        
        // Loop over the modified array to form output.
        for (String s : stack) {
            result.append("/" + s);
        }
        return result.length() == 0 ? "/" : result.toString();
    }
}


// Solution 2: My own solution: Modify the path array directly. (More efficient)
// Idea: Modify the path array directly, set the element to be "" if it is "." or "..", also when
//      encounter "..", we need to set the first non empty element before ".." to be "".
class Solution {
    public String simplifyPath(String path) {
        String[] pathArray = path.split("/");
        StringBuilder result = new StringBuilder();
        
        // Modify the path array.
        for (int i = 1; i < pathArray.length; i++) {
            if (pathArray[i].equals(".")) {
                pathArray[i] = "";
            } else if (i != 1 && pathArray[i].equals("..")) {
                pathArray[i] = "";
                int index = i - 1;
                while (index >= 1 && pathArray[index].equals("")) {
                    index--;
                }
                pathArray[index] = "";
            }
        }
        
        // Loop over the modified array to form output.
        for (int i = 1; i < pathArray.length; i++) {
            if (!pathArray[i].equals("") && !pathArray[i].equals("..")) {
                result.append("/" + pathArray[i]);
            }
        }
        return result.length() == 0 ? "/" : result.toString();
    }
}
