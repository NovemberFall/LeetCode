package Design._635_DesignLogStorageSystem;

/*
You are given several logs, where each log contains a unique ID and timestamp.
Timestamp is a String that has the following format: Year:Month:Day:Hour:Minute:Second,
for example, 2017:01:01:23:59:59. All domains are zero-padded decimal numbers.

Input
["LogSystem", "put", "put", "put", "retrieve", "retrieve"]
[[],
    [1, "2017:01:01:23:59:59"], [2, "2017:01:01:22:59:59"], [3, "2016:01:01:00:00:00"],
    ["2016:01:01:01:01:01", "2017:01:01:23:00:00", "Year"], ["2016:01:01:01:01:01", "2017:01:01:23:00:00", "Hour"]]
Output
[null, null, null, null, [3, 2, 1], [2, 1]]

Explanation
LogSystem logSystem = new LogSystem();
logSystem.put(1, "2017:01:01:23:59:59");
logSystem.put(2, "2017:01:01:22:59:59");
logSystem.put(3, "2016:01:01:00:00:00");

// return [3,2,1], because you need to return all logs between 2016 and 2017.
logSystem.retrieve("2016:01:01:01:01:01", "2017:01:01:23:00:00", "Year");

// return [2,1], because you need to return all logs between Jan. 1, 2016 01:XX:XX and Jan. 1, 2017 23:XX:XX.
// Log 3 is not returned because Jan. 1, 2016 00:00:00 comes before the start of the range.
logSystem.retrieve("2016:01:01:01:01:01", "2017:01:01:23:00:00", "Hour");
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DesignLogStorageSystem {
    private List<String[]> timeStamps;
    private Map<String, Integer> indexes;

    public DesignLogStorageSystem() {
        timeStamps = new ArrayList<>();
        indexes = new HashMap<>();
        indexes.put("Year", 4);
        indexes.put("Month", 7);
        indexes.put("Day", 10);
        indexes.put("Hour", 13);
        indexes.put("Minute", 16);
        indexes.put("Second", 19);
    }

    public void put(int id, String timestamp) {
        timeStamps.add(new String[]{Integer.toString(id), timestamp});
    }

    public List<Integer> retrieve(String s, String e, String gra) {
        List<Integer> res = new ArrayList<>();
        int index = indexes.get(gra);
        for (String[] ts : timeStamps) {
            if (ts[1].substring(0, index).compareTo(s.substring(0, index)) >= 0
                && ts[1].substring(0, index).compareTo(e.substring(0, index)) <= 0) {
                res.add(Integer.parseInt(ts[0]));
            }
        }
        return res;
    }
}
