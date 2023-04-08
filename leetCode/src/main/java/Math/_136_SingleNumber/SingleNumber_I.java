package Math._136_SingleNumber;

class SingleNumber_I {
    public int singleNumber(int[] nums) {
        int x = 0;
        for (int num : nums) {
            x ^= num;
        }
        return x;
    }

    public static void main(String[] args) {
        SingleNumber_I singleNumber = new SingleNumber_I();
        int[] nums = new int[]{4, 1, 2, 1, 2, 3, 3};
        int res = singleNumber.singleNumber(nums);
        System.out.println(res); // 4
    }
}
