package Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class _57_InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals == null || intervals.length == 0) {
            return new int[][]{newInterval};
        }

        List<int[]> res = new ArrayList<>();
        boolean inserted = false;
        for (int[] curInterval : intervals) {
            if (curInterval[1] < newInterval[0]) {
                res.add(curInterval);
            } else if (curInterval[0] > newInterval[1]) {
                if (!inserted) {
                    res.add(newInterval);
                    inserted = true;
                }
                res.add(curInterval);
            } else {
                newInterval[0] = Math.min(newInterval[0], curInterval[0]);//get min
                newInterval[1] = Math.max(newInterval[1], curInterval[1]);//get max
            }
        }

        if (!inserted) {
            res.add(newInterval);
        }
        int[][] ans = new int[res.size()][2];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = res.get(i);
        }
        return ans;
//        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][]{
                {1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}
        };
        _57_InsertInterval insertInterval = new _57_InsertInterval();
        int[][] res = insertInterval.insert(intervals, new int[]{4, 8});
        System.out.println(Arrays.deepToString(res));
        // [[1, 2], [3, 10], [12, 16]]
    }
}
