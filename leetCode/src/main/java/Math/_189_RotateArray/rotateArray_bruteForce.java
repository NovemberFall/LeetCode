package Math._189_RotateArray;

import java.util.Arrays;

class rotateArray_bruteForce {
    public void rotate(int[] nums, int k) {
        int n = nums.length;

        k %= nums.length;
        for (int i = 0; i < k; i++) {
            int tmp = nums[n - 1];
            for (int j = n - 1; j > 0; j--) {
                nums[j] = nums[j - 1];
            }
            nums[0] = tmp;
        }
    }

    public static void main(String[] args) {
        rotateArray_bruteForce rabf = new rotateArray_bruteForce();
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        rabf.rotate(nums, 3);
        System.out.println(Arrays.toString(nums));
        // [5, 6, 7, 1, 2, 3, 4]
    }
}
