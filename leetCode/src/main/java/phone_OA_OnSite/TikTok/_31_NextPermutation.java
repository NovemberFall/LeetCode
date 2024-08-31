package phone_OA_OnSite.TikTok;

class _31_NextPermutation {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        if (i == -1) { // if all nums are decreasing, just revers all nums
            reverse(nums, 0);
            return;
        }

        int j = nums.length - 1;
        while (j >= 0 && nums[j] <= nums[i]) {
            j--;
        }

        swap(nums, i, j);
        reverse(nums, i + 1);
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private void reverse(int[] nums, int i) {
        int left = i;
        int right = nums.length - 1;
        while (left <= right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}
