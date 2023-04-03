package BinarySearch._33_SearchInRotatedSortedArray;

class searchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        if (nums==null || nums.length ==0) return -1;

        int peakIdx = findPeakIndex(nums);
        // if (peakIdx >= 0 && (nums[0] <= target && target <= nums[peakIdx]))
        if (nums[0] <= target && target <= nums[peakIdx]) {
            return binarySearch(nums, 0, peakIdx, target);
        } else {
            return binarySearch(nums, peakIdx + 1, nums.length - 1, target);
        }
    }

    private int findPeakIndex(int[] nums) {
        if (nums.length == 1) return 0;

        if (nums[0] < nums[nums.length - 1]) {
            // 如果是一个纯单调递增的数组，那么return 最后一个index
            return nums.length - 1;
        }
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]) {
                return mid;
            } else if (nums[left] <= nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return 0;
    }

    private int binarySearch(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) /2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
