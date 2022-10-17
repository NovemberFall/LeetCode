package ObjectOrientedDesign.DesignHitCounter;

import java.util.HashMap;
import java.util.Map;

public class _359_LoggerRateLimiter {
    Map<String, Integer> map;

    public _359_LoggerRateLimiter() {
        map = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        Integer ok = map.get(message);
        if (ok == null || timestamp - ok >= 10) {
            synchronized(this) {
                Integer ts = map.get(message);
                if (ts == null || timestamp - ok >= 10) {
                    map.put(message, timestamp);
                    return true;
                }
            }
        }
        return false;
    }
}
