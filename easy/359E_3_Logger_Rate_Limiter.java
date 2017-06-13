/**
 * Question description: Design a logger system that receive stream of messages along with its timestamps, each message 
 * 						 should be printed if and only if it is not printed in the last 10 seconds.
 *   Given a message and a timestamp, return true if the message should be printed in the given timestamp, otherwise returns false.
 */

// Example:
// Logger logger = new Logger();
// logger.shouldPrintMessage(1, "foo"); returns true; 		// logging string "foo" at timestamp 1
// logger.shouldPrintMessage(2,"bar"); returns true;		// logging string "bar" at timestamp 2
// logger.shouldPrintMessage(3,"foo"); returns false;		// logging string "foo" at timestamp 3
// logger.shouldPrintMessage(8,"bar"); returns false;		// logging string "bar" at timestamp 8
// logger.shouldPrintMessage(11,"foo"); returns true;		// logging string "foo" at timestamp 11

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; 
 * Company: .
 * Create Date: 02/24/2017
 * Update date: 06/12/2017
 */

// Jinglong's solution.
public class Logger {
    Map<String, Integer> map;
    
    /** Initialize your data structure here. */
    public Logger() {
        map = new HashMap<>();
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!map.containsKey(message)) {
            map.put(message, timestamp);
        } else {
            int time = map.get(message);
            if (timestamp - time < 10) {
                return false;
            }
            map.put(message, timestamp);
        }
        return true;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */
