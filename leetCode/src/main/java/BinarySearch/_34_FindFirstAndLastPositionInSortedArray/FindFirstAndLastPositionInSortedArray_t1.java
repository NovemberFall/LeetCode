package BinarySearch._34_FindFirstAndLastPositionInSortedArray;
import java.util.Arrays;

class FindFirstAndLastPositionInSortedArray_t1 {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        res[0] = findFirst(nums, target);
        res[1] = findLast(nums, target);
        return res;
    }

    private int findFirst(int[] nums, int target) {
        int idx = -1;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] == target) {
                idx = mid;
                // because nothing after mid can be the first occurrence of target.
                //maybe mid is the first occurrence , maybe not
                //so let's narrow the target for [0... mid-1] and find out
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return idx;
    }

    private int findLast(int[] nums, int target) {
        int idx = -1;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] == target) {
                idx = mid;
                // because nothing before mid can be the last occurrence of target.
                //maybe mid is the last occurrence , maybe not
                //so let's narrow the target for [mid+1 ... high] and find out
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return idx;
    }

    public static void main(String[] args) {
        FindFirstAndLastPositionInSortedArray_t1 findFirstAndLastPositionInSortedArray = new FindFirstAndLastPositionInSortedArray_t1();
        int[] nums = new int[]{2, 2, 3, 3, 3, 7, 8, 8, 8, 8, 9, 10, 11};
        int target = 8;
        int[] res = findFirstAndLastPositionInSortedArray.searchRange(nums, target);
        System.out.println(Arrays.toString(res)); // [6, 9]
    }
}
