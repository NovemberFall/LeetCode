package BinarySearch._34_FindFirstAndLastPositionInSortedArray;

class indFirstAndLastPositionInSortedArray_t2 {
    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return new int[]{-1, -1};
        }
        int[] res = new int[2];
        res[0] = findFirstPosition(nums, target);
        res[1] = findLastPosition(nums, target);
        return res;
    }

    private int findFirstPosition(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            // 小于一定不是解
            if (nums[mid] < target) {
                // 下一轮搜索区间是 [mid + 1..right]
                left = mid + 1;
            } else {
                // nums[mid] >= target，下一轮搜索区间是 [left..mid]
                right = mid;
            }
        }

        // 退出循环以后不能确定 nums[left] 是否等于 target，因此需要再判断一次
        return nums[left] == target ? left : -1;
    }

    private int findLastPosition(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + ((right - left + 1) >> 1);
            if (nums[mid] > target) {
                // 下一轮搜索区间是 [left..mid - 1]
                right = mid - 1;
            } else {
                // 下一轮搜索区间是 [mid..right]
                left = mid;
            }
        }
        return nums[left] == target ? left : -1;
    }
}
