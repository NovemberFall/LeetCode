package BinarySearch._4_MedianOfTwoSortedArrays;

class MedianOfTwoSortedArrays_merge {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] res = merge(nums1, nums2);
        int n = res.length;
        if (n % 2 == 0) {
            return (double) (res[(n / 2) - 1] + res[n / 2]) / 2;
        } else {
            return res[n / 2];
        }
    }

    private int[] merge(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int[] merged = new int[m + n];
        int i = 0, j = 0, idx = 0;
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                merged[idx++] = nums1[i++];
            } else {
                merged[idx++] = nums2[j++];
            }
        }
        while (i < m) {
            merged[idx++] = nums1[i++];
        }
        while (j < n) {
            merged[idx++] = nums2[j++];
        }
        return merged;
    }

    public static void main(String[] args) {
        MedianOfTwoSortedArrays_merge medianOfTwoSortedArrays = new MedianOfTwoSortedArrays_merge();
        int[] nums1 = {1, 2}, nums2 = {3, 4};
        System.out.println(medianOfTwoSortedArrays.findMedianSortedArrays(nums1, nums2)); // 2.5
    }
}
