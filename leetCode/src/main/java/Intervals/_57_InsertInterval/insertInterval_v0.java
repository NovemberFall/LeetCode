package Intervals._57_InsertInterval;

import java.util.ArrayList;
import java.util.List;

class insertInterval_v0 {
    class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<>();
        for (Interval curInterval : intervals) {
            if (curInterval.end < newInterval.start) {
                res.add(curInterval);
            } else if (newInterval == null || newInterval.end < curInterval.start) {
                res.add(newInterval);
                newInterval = null;
                res.add(curInterval);
            } else {
                newInterval.start = Math.min(newInterval.start, curInterval.start);
                newInterval.end = Math.max(newInterval.end, curInterval.end);
            }
        }

        if (newInterval == null) {
            return res;
        }
        res.add(newInterval);
        return res;
    }
}
