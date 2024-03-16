package Intervals;

import java.util.Arrays;
import java.util.PriorityQueue;

class _253_MeetingRooms_II {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;

        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(intervals.length,
                (e1, e2) -> (e1[1] - e2[1]));

        for (int[] arr : intervals) {
            minHeap.offer(arr);
        }

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= minHeap.peek()[1]) {
                minHeap.poll();
            }
        }
        return minHeap.size();
    }

    public int minMeetingRooms_improve(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;

        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(intervals.length,
                (a, b) -> (a - b));

        minHeap.offer(intervals[0][1]);

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= minHeap.peek()) {
                minHeap.poll();
            }
            minHeap.offer(intervals[i][1]);
        }
        return minHeap.size();
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1, 4}, {2, 8}, {5, 7}, {5, 9}, {3, 4}};
        _253_MeetingRooms_II meetingRooms = new _253_MeetingRooms_II();
        int size = meetingRooms.minMeetingRooms(intervals);
        System.out.println(size);
    }
}
