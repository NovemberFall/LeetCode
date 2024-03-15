package Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class _56_MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length < 1) {
            return null;
        }
        Arrays.sort(intervals, (e1, e2) -> (e1[0] - e2[0]));

        List<int[]> list = new ArrayList<>();
        list.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] lastInterval = list.get(list.size() - 1);
            if (lastInterval[1] >= intervals[i][0]) {
                lastInterval[1] = Math.max(lastInterval[1], intervals[i][1]);
            } else {
                list.add(intervals[i]);
            }
        }

        int[][] res = new int[list.size()][2];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
//         return res.toArray(new int[res.size()][2]);
    }
}
