package BinarySearch;

class _154_FindMinimumInRotatedSortedArray_II {
    public int findMin(int[] nums) {
        if (nums.length == 1) return nums[0];

        if (nums[0] < nums[nums.length - 1]) return nums[0];

        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[left] < nums[right]) {
                return nums[left];
            } else if (nums[left] < nums[mid]) {
                left = mid + 1;
            } else if (nums[left] > nums[mid]){
                right = mid;
            }

        }
        return -1;
    }
}
