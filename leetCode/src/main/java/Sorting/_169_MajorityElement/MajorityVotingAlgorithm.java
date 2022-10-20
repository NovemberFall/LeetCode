package Sorting._169_MajorityElement;

class MajorityVotingAlgorithm {
    public static int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int n = nums.length;
        int count = 0, candidate = -1;
        for (int i = 0; i < n; i++) {
            if (count == 0) {
                candidate = nums[i];
                count = 1;
            } else {
                if (nums[i] == candidate) {
                    count++;
                } else {
                    count--;
                }
            }
        }

        count = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == candidate) {
                count++;
            }
        }

        if (count > (n / 2)) {
            return candidate;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        int arr[] = {1, 1, 1, 1, 2, 3, 4};
        int majority = majorityElement(arr);
        System.out.println(majority);
    }
}
