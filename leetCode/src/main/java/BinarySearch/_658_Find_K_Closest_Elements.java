package BinarySearch;

import java.util.ArrayList;
import java.util.List;

class _658_Find_K_Closest_Elements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res =new ArrayList<>();
        if (arr == null || arr.length == 0 || k == 0) {
            return res;
        }

        int close = cloest(arr, x);
        int left = close - 1, right = close + 1;
        while (right - left - 1 < k) {
            if (left < 0) {
                right++;
            } else if (right >= arr.length) {
                left--;
            } else if (Math.abs(arr[left] - x) <= Math.abs(arr[right] - x)) {
                left--;
            } else {
                right++;
            }
        }
        for (int i = left + 1; i < right; i++) {
            res.add(arr[i]);
        }
        return res;
    }

    private int cloest(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left < right - 1) {
            int mid = (left + right) >>> 1;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (Math.abs(arr[left] - target) <= Math.abs(arr[right] - target)) {
            return left;
        } else {
            return right;
        }
    }
}
