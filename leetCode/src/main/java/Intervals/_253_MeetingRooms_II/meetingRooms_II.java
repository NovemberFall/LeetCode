package Intervals._253_MeetingRooms_II;

import java.util.Arrays;

class meetingRooms_II {
    public int minMeetingRooms(int[][] intervals) {
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);

        int res = 0, room = 0;
        int startIndex = 0, endIndex = 0;
        while (startIndex < intervals.length) {
            if (start[startIndex] < end[endIndex]) {
                startIndex++;
                room++;
            } else {
                endIndex++;
                room--;
            }
            res = Math.max(res, room);
        }
        return res;
    }
}
