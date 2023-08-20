package BinarySearch._4_MedianOfTwoSortedArrays;

class MedianOfTwoSortedArrays_t1 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // if nums1's length is greater than nums2's length, switch them
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int x = nums1.length;
        int y = nums2.length;

        int left = 0;
        int right = x;

        while (left <= right) {
            int partitionX = left + ((right - left) >> 1);
            int partitionY = ((x + y + 1) >> 1) - partitionX;

            // if partitionX is 0 it menas nothing is there on left side. Use -INF for maxLeftX
            // if partitionX is length of nums1 then there is nothing on right side. Use +INF for maxRightX
            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int minRightX = (partitionX == x) ? Integer.MAX_VALUE : nums1[partitionX];

            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int minRightY = (partitionY == y) ? Integer.MAX_VALUE : nums2[partitionY];

            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                // we have partitioned array at correct place
                // Now we get max of left elements and min of right elements to get the median in case of even length combined array size
                // or get max of left elements for ODD length combined array size.
                if ((x + y) % 2 == 0) {
                    return (double) (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2;
                } else {
                    return (double) Math.max(maxLeftX, maxLeftY);
                }
            } else if (maxLeftX > minRightY) {// we are too far on right side for partitionX. Go on left side.
                right = partitionX - 1;
            } else { // we are too far on left side for partitionX. Go on right side.
                left = partitionX + 1;
            }
        }

        return Double.MIN_VALUE;
    }
}
