package BinarySearch._33_SearchInRotatedSortedArray;

class binarySearchInRotatedSortedArray_show_all_elseif {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;

            // If the target is found at the middle
            if (target == nums[mid]) {
                return mid;
            }

            // Check if the left side is sorted
            if (nums[left] <= nums[mid]) {

                // Target is in the left sorted half
                if (nums[left] <= target && target <= nums[mid]) {
                    right = mid - 1;
                }
                // Target is not in the left sorted half
                else if (nums[left] > target || target > nums[mid]) {
                    left = mid + 1;
                }

            }
            // Else, the right side must be sorted
            else if (nums[mid] < nums[right]) {

                // Target is in the right sorted half
                if (nums[mid] <= target && target <= nums[right]) {
                    left = mid + 1;
                }
                // Target is not in the right sorted half
                else if (nums[mid] > target || target > nums[right]) {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
