package BinarySearch._33_SearchInRotatedSortedArray;

class binarySearchInRotatedSortedArray_recursion {
    public int search(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length - 1, target);
    }

    private int binarySearch(int[] nums, int left, int right, int target) {
        if (left > right) {
            return -1;
        }

        int mid = left + (right - left) / 2;
        int leftValue = nums[left];
        int midValue = nums[mid];
        int rightValue = nums[right];

        if (leftValue == target) {
            return left;
        }
        if (midValue == target) {
            return mid;
        }
        if (rightValue == target) {
            return right;
        }

        if (leftValue < midValue) {
            if (leftValue < target && target < midValue) {
                return binarySearch(nums, left + 1, right - 1, target);
            } else {
                return binarySearch(nums, mid + 1, right - 1, target);
            }
        } else {
            if (midValue < target && target < rightValue) {
                return binarySearch(nums, mid + 1, right - 1, target);
            } else {
                return binarySearch(nums, left + 1, mid - 1, target);
            }
        }
    }
}
