package DynamicProgramming._152_MaximumProductSubarray;

class maximumProductSubarray {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int globalMax = Integer.MIN_VALUE;
        int imax = 1, imin = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                int tmp = imax;
                imax = imin;
                imin = tmp;
            }
            imax = Math.max(imax * nums[i], nums[i]);
            imin = Math.min(imin * nums[i], nums[i]);

            globalMax = Math.max(globalMax, imax);
        }
        return globalMax;
    }

    public static void main(String[] args) {
        maximumProductSubarray maximumProductSubarray = new maximumProductSubarray();
        int[] nums = {2, 3, -2, 4};
        System.out.println(maximumProductSubarray.maxProduct(nums)); // 6

        nums = new int[]{2, 3, -2, 4, -2};
        System.out.println(maximumProductSubarray.maxProduct(nums)); // 96
    }
}
