package BinarySearch._35_SearchInsertPosition;

class SearchInsertPosition_v1 {
    public static int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;

        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
            System.out.println(mid);
        }
        return left;
    }

    public static void main(String[] args) {

        int[] nums2 = new int[]{1, 2, 3, 4, 5, 7, 9, 11};
        int res2 = searchInsert(nums2, 10);
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println(res2);
    }
}
