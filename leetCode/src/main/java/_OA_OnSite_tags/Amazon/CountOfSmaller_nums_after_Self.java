package _OA_OnSite_tags.Amazon;

import java.util.ArrayList;
import java.util.List;

public class CountOfSmaller_nums_after_Self {
    class Item {
        int val;
        int index;
        public Item(int v, int i) {
            val = v;
            index = i;
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        Item[] items = new Item[n];
        for (int i = 0; i < n; i++) {
            items[i] = new Item(nums[i], i);
        }

        int[] count = new int[n];
        mergeSort(items, 0, n - 1, count);
        List<Integer> res = new ArrayList<>();
        for (int i : count) {
            res.add(i);
        }
        return res;
    }

    private void mergeSort(Item[] items, int lo, int hi, int[] count) {
        if (lo >= hi) return;
        int mid = lo + (hi - lo) / 2;
        mergeSort(items, lo, mid, count);
        mergeSort(items, mid + 1, hi, count);
        merge(items, lo, mid, mid + 1, hi, count);
    }

    private void merge(Item[] items, int lo, int loEnd, int hi, int hiEnd, int[] count) {
        int len = hiEnd - lo + 1;
        Item[] sorted = new Item[len];
        int rightCounter = 0;
        int loPtr = lo, hiPtr = hi;
        int index = 0;
        while (loPtr <= loEnd && hiPtr <= hiEnd) {
            if (items[loPtr].val > items[hiPtr].val) {
                rightCounter++;
                sorted[index++] = items[hiPtr++];
            } else {
                count[items[loPtr].index] += rightCounter;
                sorted[index++] = items[loPtr++];
            }
        }

        while (loPtr <= loEnd) {
            count[items[loPtr].index] += rightCounter;
            sorted[index++] = items[loPtr++];
        }

        while (hiPtr <= hiEnd) {
            sorted[index++] = items[hiPtr++];
        }

        System.out.println(lo);
        System.arraycopy(sorted, 0, items, lo, len);
    }

    public static void main(String[] args) {
        int [] nums = new int[]{4, 1, 3, 2};
        CountOfSmaller_nums_after_Self sol = new CountOfSmaller_nums_after_Self();
        List<Integer> res =  sol.countSmaller(nums);
        System.out.println(res);
    }
}
