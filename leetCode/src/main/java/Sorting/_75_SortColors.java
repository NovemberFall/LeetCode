package Sorting;

import java.util.Random;

class _75_SortColors {
    public void sortColors(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    private void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivotPos = partition(nums, left, right);
        quickSort(nums, left, pivotPos - 1);
        quickSort(nums, pivotPos + 1, right);
    }

    private int partition(int[] nums, int left, int right) {
        int pivotIdx = left + new Random().nextInt(right - left + 1);
        int pivotVal = nums[pivotIdx];
        swap(nums, pivotIdx, right);
        int leftBound = left;
        int rightBound = right - 1;
        while (leftBound <= rightBound) {
            if (nums[leftBound] < pivotVal) {
                leftBound++;
            } else if (nums[rightBound] >= pivotVal) {
                rightBound--;
            } else if (nums[leftBound] >= pivotVal && nums[rightBound] < pivotVal) {
                swap(nums, leftBound, rightBound);
                leftBound++;
                rightBound--;
            }
        }
        swap(nums, leftBound, right);
        return leftBound;
    }

    private void swap(int[] nums, int pivotIdx, int right) {
        int tmp = nums[pivotIdx];
        nums[pivotIdx] = nums[right];
        nums[right] = tmp;
    }
}
