package to400;

import java.util.HashMap;


public class _359_LoggerRateLimiter {


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
