package Arrays._238_ProductOfArrayExceptSelf;

class ProductOfArrayExceptSelf_v0 {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int[] prefix = new int[n];
        int[] postfix = new int[n];

        prefix[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] * nums[i];
        }

        postfix[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            postfix[i] = postfix[i + 1] * nums[i];
        }

        for (int i = 0; i < n; i++) {
            if (i - 1 < 0) {
                res[i] = postfix[i + 1] * 1;
                continue;
            }
            if (i + 1 >= n) {
                res[i] = prefix[i - 1] * 1;
                continue;
            }
            res[i] = prefix[i - 1] * postfix[i + 1];
        }
        return res;
    }
}
