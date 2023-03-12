package Math;

class _136_SingleNumber {
    public int singleNumber(int[] nums) {
        int x = 0;
        for (int num : nums) {
            x ^= num;
        }
        return x;
    }

    public static void main(String[] args) {
        _136_SingleNumber singleNumber = new _136_SingleNumber();
        int[] nums = new int[]{4, 1, 2, 1, 2, 3, 3};
        int res = singleNumber.singleNumber(nums);
        System.out.println(res); // 4
    }
}
