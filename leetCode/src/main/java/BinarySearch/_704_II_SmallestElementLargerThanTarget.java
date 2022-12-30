package BinarySearch;

import org.junit.jupiter.api.Test;

/**
 Given a target integer T and an integer array A sorted in ascending order,
 find the index of the smallest element in A that is larger than T or
                                        return -1 if there is no such index.

 Assumptions
 There can be duplicate elements in the array.

 Examples

 A = {1, 2, 3}, T = 1, return 1

 A = {1, 2, 3}, T = 3, return -1

 A = {1, 2, 2, 2, 3}, T = 1, return 1

 */
class _704_II_SmallestElementLargerThanTarget {
    public static int smallestElementLargerThanTarget(int[] array, int target) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int left = 0, right = array.length - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (array[mid] <= target) {
                left = mid;
            } else {
                right = mid;
            }
        }

        if (array[left] > target) {
            return left;
        }
        if (array[right] > target) {
            return right;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2, 2, 3};
        int res = smallestElementLargerThanTarget(nums, 1);
        System.out.println(res); // 1
    }

    @Test
    void test_all_Elements_Are_Same() {
        int[] nums = new int[]{1, 1, 1, 1, 1};
        int res = smallestElementLargerThanTarget(nums, 1);
        System.out.println(res); // -1
    }

    @Test
    void test_LeftIndex_Of_Indexes() {
        int[] nums = new int[]{2, 10, 13, 15, 19, 20, 27};
        int res = smallestElementLargerThanTarget(nums, 1);
        System.out.println(res); // 0
    }
}
