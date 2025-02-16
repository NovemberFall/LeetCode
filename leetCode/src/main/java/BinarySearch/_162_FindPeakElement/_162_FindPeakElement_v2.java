package BinarySearch._162_FindPeakElement;

class _162_FindPeakElement_v2 {
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) return -1;

        int left = 0, right = nums.length - 1;
        while (left < right - 1) { // prevent infinite loop
            int mid = (left + right) >>> 1;
            if (nums[mid - 1] < nums[mid] && nums[mid] > nums[mid + 1]) {
                return mid;
            } else if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return nums[left] >= nums[right] ? left : right;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 1, 3, 5, 6, 4};
        _162_FindPeakElement_v2 fpe = new _162_FindPeakElement_v2();
        int idx = fpe.findPeakElement(nums);
        System.out.println(idx); // 5
    }
}
