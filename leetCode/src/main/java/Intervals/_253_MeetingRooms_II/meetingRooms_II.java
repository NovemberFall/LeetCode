package Intervals._253_MeetingRooms_II;

import java.util.Arrays;
import java.util.PriorityQueue;

class meetingRooms_II {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;

        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(intervals.length,
                (e1, e2) -> (e1[1] - e2[1]));

        minHeap.offer(intervals[0]);
        int res = 1;

        for (int i = 1; i < intervals.length; i++) {
            int[] curMeeting = intervals[i];
            int[] prevMeeting = minHeap.poll();
            if (curMeeting[0] >= prevMeeting[1]) {
                prevMeeting[1] = curMeeting[1];
            } else {
                res++;
                minHeap.offer(curMeeting);
            }
            minHeap.offer(prevMeeting);
        }
        return res;
//        return minHeap.size();
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1, 4}, {2, 8}, {5, 7}, {5, 9}, {3, 4}};
        meetingRooms_II meetingRooms = new meetingRooms_II();
        int size = meetingRooms.minMeetingRooms(intervals);
        System.out.println(size);
    }
}
