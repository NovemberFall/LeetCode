package DynamicProgramming._485_MaxConsecutiveOnes;

public class maxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int globalMax = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
                globalMax = Math.max(globalMax, count);
            } else {
                count = 0;
            }
        }
        return globalMax;
    }
}
