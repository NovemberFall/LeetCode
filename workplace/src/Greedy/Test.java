package Greedy;

import java.util.Arrays;

public class Test {
    public static int maximumUnits(int[][] boxTypes, int truckSize) {
         Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]); // b[1] - a[1] may cause int overflow, credit to @Zudas.
//        Arrays.sort(boxTypes, (a, b) -> Integer.compare(b[1], a[1]));
        int boxes = 0;
        for (int[] box : boxTypes) {
            if (truckSize >= box[0]) {
                boxes += box[0] * box[1];
                truckSize -= box[0];
                System.out.println(boxes + " truckSize: " + truckSize);
            }else {
                System.out.println(boxes + " truckSize: " + truckSize);
                boxes += truckSize * box[1];
                System.out.println(boxes + " truckSize: " + truckSize);
                return boxes;
            }
        }
        return boxes;
    }
    public static void main(String[] args) {
        int[][] boxTypes = {{1, 3}, {5, 10}, {10, 10}, {3, 9}, {4, 7}};
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        System.out.println(Arrays.deepToString(boxTypes));
        int res = maximumUnits(boxTypes, 10);
        System.out.println(res);
    }
}
