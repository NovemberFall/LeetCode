package BitOperation.Basic.XOR;

class test2 {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 2, 3, 2};
        int total = 0;
        for (int num : nums) {
            total ^= num;
        }
        System.out.println(total);
    }
}
