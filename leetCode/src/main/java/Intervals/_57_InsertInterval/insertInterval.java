package Intervals._57_InsertInterval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class insertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals == null || intervals.length == 0) {
            return new int[][]{newInterval};
        }

        List<int[]> result = new ArrayList<>();

        for (int[] curInterval : intervals) {
            if (newInterval == null || curInterval[1] < newInterval[0]) {
                result.add(curInterval);
            } else if (newInterval[1] < curInterval[0]) {
                result.add(newInterval);
                result.add(curInterval);
                newInterval = null;
            } else {
                newInterval[0] = Math.min(newInterval[0], curInterval[0]);//get min
                newInterval[1] = Math.max(newInterval[1], curInterval[1]);//get max
            }
        }

        if (newInterval != null) {
            result.add(newInterval);
        }
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][]{
                {1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}
        };
        insertInterval insertInterval = new insertInterval();
        int[][] res = insertInterval.insert(intervals, new int[]{4, 8});
        System.out.println(Arrays.deepToString(res));
        // [[1, 2], [3, 10], [12, 16]]
    }
}
