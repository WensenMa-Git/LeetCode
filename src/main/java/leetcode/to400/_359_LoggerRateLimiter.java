package leetcode.to400;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/logger-rate-limiter/
 * Subject: Map
 * #Easy, #Google
 */
public class _359_LoggerRateLimiter {

    //Preferred Solution.
    HashMap<String, Integer> map;

    public _359_LoggerRateLimiter() {
        map = new HashMap<>();
    }


    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!map.containsKey(message) || timestamp - map.get(message) >= 10) {
            map.put(message, timestamp);
            return true;
        }
        return false;
    }
}

//Provide a second solution.
class Logger {
    private Map<String, Integer> map;
    /** Initialize your data structure here. */
    public Logger() {
        map = new HashMap<>();
    }

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
     If this method returns false, the message will not be printed.
     The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!map.containsKey(message)) {
            map.put(message, timestamp + 10);
            return true;
        } else {
            if (timestamp < map.get(message)) {
                return false;
            } else {
                map.put(message, timestamp + 10);
                return true;
            }
        }
    }
}
