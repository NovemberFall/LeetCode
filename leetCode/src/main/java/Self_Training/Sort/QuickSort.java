package Self_Training.Sort;

import java.util.Arrays;

class QuickSort {
    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums;
        }
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] array, int left, int right) {

    }

    private int partition(int[] array, int left, int right) {
        return 0;
    }

    private void swap(int[] array, int pivotIndex, int right) {
        int tmp = array[pivotIndex];
        array[pivotIndex] = array[right];
        array[right] = tmp;
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] nums = new int[]{1, 9, 8, 5, 3};
        int[] res = quickSort.sortArray(nums);
        System.out.println(Arrays.toString(res));
    }
}
