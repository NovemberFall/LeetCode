package BinarySearch._4_MedianOfTwoSortedArrays;

class MedianOfTwoSortedArrays_v1 {
    private int findKth(int[] nums1, int[] nums2, int i, int j, int k) {
        int m = nums1.length;
        int n = nums2.length;

        // Case 1: nums1 is exhausted
        if (i == m) {
            return nums2[j + k - 1];
        }

        // Case 2: nums2 is exhausted
        if (j == n) {
            return nums1[i + k - 1];
        }

        // Case 3: find the smallest remaining number
        if (k == 1) {
            return Math.min(nums1[i], nums2[j]);
        }

        int half = k / 2;
        int newI = Math.min(i + half, m) - 1;
        int newJ = Math.min(j + half, n) - 1;

        int pivot1 = nums1[newI];
        int pivot2 = nums2[newJ];

        if (pivot1 <= pivot2) {
            int removed = newI - i + 1;
            return findKth(nums1, nums2, newI + 1, j, k - removed);
        } else {
            int removed = newJ - j + 1;
            return findKth(nums1, nums2, i, newJ + 1, k - removed);
        }
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;

        if (total % 2 == 1) {
            return findKth(nums1, nums2, 0, 0, total / 2 + 1);
        }

        int left = findKth(nums1, nums2, 0, 0, total / 2);
        int right = findKth(nums1, nums2, 0, 0, total / 2 + 1);

        // Cast before addition to avoid integer overflow.
        return ((double) left + right) / 2.0;
    }
}
