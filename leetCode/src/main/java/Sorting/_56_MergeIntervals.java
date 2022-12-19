package Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class _56_MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return null;
        }
        Arrays.sort(intervals, (e1, e2) -> (e1[0] - e2[0]));
        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] lastArr = res.get(res.size() - 1);
            if (lastArr[1] >= intervals[i][0]) {
                lastArr[1] = Math.max(lastArr[1], intervals[i][1]);
            } else {
                res.add(intervals[i]);
            }
        }
//         return res.toArray(new int[res.size()][2]);
        return res.stream().toArray(int[][]::new);
    }
}
