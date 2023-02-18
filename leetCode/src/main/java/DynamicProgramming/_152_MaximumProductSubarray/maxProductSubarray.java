package DynamicProgramming._152_MaximumProductSubarray;

public class maxProductSubarray {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[] largest = new int[n];
        int[] smallest = new int[n];
        largest[0] = nums[0];
        smallest[0] = nums[0];
        int max = largest[0];

        for (int i = 1; i < n; i++) {
            int tmpLargest = Math.max(nums[i] * largest[i - 1], nums[i] * smallest[i - 1]);
            largest[i] = Math.max(tmpLargest, nums[i]);

            int tmpSmallest = Math.min(nums[i] * largest[i - 1], nums[i] * smallest[i - 1]);
            smallest[i] = Math.min(tmpSmallest, nums[i]);

            max = Math.max(max, largest[i]);
        }
        return max;
    }
}

/*
        [2,     3,      -2,     4]
                i

         largest[2]
        smallest[2]
         tmpLargest = max(3 * 2, 3 * 2) = 6
         largest[i] = max(6, 3) = 6
         tmpSmallest = min(3 * 2, 3 * 2) = 6
         smallest[i] = min(6, 3) = 3
         largest[2, 6]
        smallest[2, 3]
        max = max(2, 6) = 6



        [2,     3,      -2,     4]
                         i

         largest[2, 6]
        smallest[2, 3]
         tmpLargest = max(-2 * 6, -2 * 3) = -6
         largest[i] = max(-6, -2) = -2
         tmpSmallest = min(-2 * 6, -2 * 3) = -12
         smallest[i] = min(-12, -2) = -12
         largest[2, 6, -2]
        smallest[2, 3, -12]
        max = max(6, -2) = 6



        [2,     3,      -2,     4]
                                i

         largest[2, 6, -2]
        smallest[2, 3, -12]
         tmpLargest = max(4 * -2, 4 * -12) = -8
         largest[i] = max(-8, 4) = 4
         tmpSmallest = min(4 * -2, 4 * -12) = -48
         smallest[i] = min(-48, 4) = -48
         largest[2, 6, -2, 4]
        smallest[2, 3, -12, -48]
        max = max(6, 4) = 6
 */


























