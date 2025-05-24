package _JavaAPI.Reference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListWithTwoDArray {
    public static void main(String[] args) {
        int[][] intervals = new int[][]{
                {1, 3}, {2, 6}, {8, 10}, {15, 18}
        };

        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);
        int [] arr = res.get(0);
        System.out.println(Arrays.toString(arr));
        arr[1] = 4;

        System.out.println(Arrays.toString(res.get(0)));
    }
}
