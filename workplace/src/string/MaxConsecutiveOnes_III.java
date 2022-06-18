package string;

public class MaxConsecutiveOnes_III {
//    public static int longestConsecutiveOnes(int [] nums, int k) {
//        int slow = 0;
//        int fast = 0;
//        int count = 0;
//        int longest = 0;
//        while (fast < nums.length) {
//            if (nums[fast] == 1) {
//                longest = Math.max(longest, ++fast - slow);
//                System.out.println("slow = " + slow);
//            } else if (count < k) {
//                count++;
//                longest = Math.max(longest, ++fast - slow);
//                System.out.println("Slow = " + slow);
//            } else if (nums[slow++] == 0) {
//                count--;
//            }
//        }
//        return longest;
//    }

    public static int longestConsecutiveOnes(int [] nums, int k) {
        int slow = 0;
        int fast = 0;
        int zeros = 0;
        int longest = 0;
        while (fast < nums.length) {
            if (nums[fast] == 0) {
                zeros++;
            }
            while (zeros > k) {
                if (nums[slow] == 0) {
                    zeros--;
                }
                slow++;
            }
            longest = Math.max(longest, fast - slow + 1);
            System.out.println(longest);
            fast++;
        }
        return longest;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,1,1,0, 0,0,1,1,1,1,0};
        int longest = longestConsecutiveOnes(arr, 2);
        System.out.println(longest);
    }
}
