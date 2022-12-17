package TwoPointers;

import java.util.Arrays;

class _88_MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int idx = m + n - 1;
        int i = m - 1, j = n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[idx--] = nums1[i--];
            } else {
                nums1[idx--] = nums2[j--];
            }
        }
        while (i >= 0) {
            nums1[idx--] = nums1[i--];
        }
        while (j >= 0) {
            nums1[idx--] = nums2[j--];
        }
    }

    public static void main(String[] args) {
        _88_MergeSortedArray mergeSortedArray = new _88_MergeSortedArray();
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};
        mergeSortedArray.merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }
}
