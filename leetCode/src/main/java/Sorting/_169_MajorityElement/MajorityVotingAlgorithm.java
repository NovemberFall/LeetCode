package Sorting._169_MajorityElement;

class MajorityVotingAlgorithm {
    public static int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int count = 0;
        int majority = nums[0];
        for (int num : nums) {
            if (num == majority) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                majority = num;
                count = 1;
            }
        }
        return majority;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 1, 2, 3, 4};
        int majority = majorityElement(arr);
        System.out.println(majority); // 1
    }
}
