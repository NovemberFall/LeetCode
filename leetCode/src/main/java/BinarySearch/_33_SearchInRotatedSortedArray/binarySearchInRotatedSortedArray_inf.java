package BinarySearch._33_SearchInRotatedSortedArray;

/**
        [12, 13, 14, 15, 16, 0, 1, 2, 3, 4]

 - If target is let's say 14, then we adjust nums to this, where "inf" means infinity:
        [12, 13, 14, 15, 16, inf, inf, inf, inf, inf]

 - If target is let's say 3, then we adjust nums to this:
        [-inf, -inf, -inf, -inf, -inf, 0, 1, 2, 3, 4]

 */
class binarySearchInRotatedSortedArray_inf {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            int num = nums[mid];
            // If nums[mid] and target are "on the same side" of nums[0], we just take nums[mid].
            if ((nums[mid] < nums[0]) == (target < nums[0])) {
                num = nums[mid];
            } else {
                //Otherwise we use -infinity or +infinity as needed.
                num = target < nums[0] ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }

            if (num < target)
                left = mid + 1;
            else if (num > target)
                right = mid - 1;
            else
                return mid;
        }
        return -1;
    }
}
