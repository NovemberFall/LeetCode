package BinarySearch;

import java.util.ArrayList;
import java.util.List;

class _1146_SnapshotArray {
    private int snap_cnt;
    private List<int[]>[] data;

    public _1146_SnapshotArray(int length) {
        snap_cnt = 0;
        data = new List[length];
        for (int i = 0; i < length; i++) {
            data[i] = new ArrayList<>();
        }
    }

    public void set(int index, int val) {
        data[index].add(new int[]{snap_cnt, val});
    }

    public int snap() {
        return snap_cnt++;
    }

    public int get(int index, int snap_id) {
        int pos = binarySearch(data[index], snap_id);
        return pos == -1 ? 0 : data[index].get(pos)[1];
    }

    private int binarySearch(List<int[]> list, int snap_id) {
        int left = 0, right = list.size() - 1;
        int res = -1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            int[] pair = list.get(mid);
            if (pair[0] == snap_id) {
                res = mid;
                left = mid + 1;
            } else if (pair[0] < snap_id) {
                res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }
}
