package BinarySearch._4_MedianOfTwoSortedArrays;

class MedianOfTwoSortedArrays_t2 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;

        // 分割线左边的所有元素需要满足的个数 m + (n - m + 1) / 2;
        int totalLeft = (m + n + 1) >> 1;

        // 在 nums1 的区间 [0, m] 里查找恰当的分割线，
        // 使得 nums1[i - 1] <= nums2[j] && nums2[j - 1] <= nums1[i]
        int left = 0;
        int right = m;

        while (left < right) {
            int i = left + ((right - left + 1) >> 1);
            int j = totalLeft - i;

            // 我们可以给这句话 nums1[i - 1] <= nums2[j] && nums2[j - 1] <= nums1[i] 做一个取反！
            if (nums1[i - 1] > nums2[j]) {
                // 下一轮搜索的区间 [left, i - 1]
                right = i - 1;
            } else { // nums2[j - 1] > nums1[i]
                // 下一轮搜索的区间 [i, right]
                left = i;
                // [left(i), right]  但是这样可能进入死循环 => `i = left + ((right - left + 1) >> 2)`
            }
        }

        // 跳出循环，就说明我们已经满足了： nums1[i - 1] <= nums2[j] && nums2[j - 1] <= nums1[i]
        // 重新定义一下 i, j
        int i = left;
        int j = totalLeft - i;

        // 接下来我们做数组是否分别越界的检测
        int nums1LeftMax = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
        int nums1RightMin = i == m ? Integer.MAX_VALUE : nums1[i];
        int nums2LeftMax = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
        int nums2RightMin = j == n ? Integer.MAX_VALUE : nums2[j];

        if (((m + n) % 2) == 1) {
            return Math.max(nums1LeftMax, nums2LeftMax);
        } else {
            return (double) ((Math.max(nums1LeftMax, nums2LeftMax) + Math.min(nums1RightMin, nums2RightMin))) / 2;
        }
    }
}
