package Intervals;

import java.util.Arrays;

class _435_NonOverlapping_Intervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int res = 0;
        int prevEnd = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (prevEnd <= intervals[i][0]) {
                prevEnd = intervals[i][1];
            } else {
                res++;
                prevEnd = Math.min(prevEnd, intervals[i][1]);
            }
        }
        return res;
    }
}
