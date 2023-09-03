package TwoPointers._42_TrappingRainWater;

class TrappingRainWater_DP {
    public int trap(int[] height) {
        int n = height.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int count = 0;
        int leftMax = 0, rightMax = 0;

        for (int i = 1; i < n; i++) {
            leftMax = Math.max(leftMax, height[i - 1]);
            left[i] = leftMax;
        }

        for (int i = n - 2; i >= 0; i--) {
            rightMax = Math.max(rightMax, height[i + 1]);
            right[i] = rightMax;
        }

        for (int i = 0; i < n; i++) {
            count += Math.max(0, Math.min(left[i], right[i]) - height[i]);
        }

        return count;
    }

    public static void main(String[] args) {
        TrappingRainWater_DP trappingRainWater = new TrappingRainWater_DP();
        int[] rain = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int count = trappingRainWater.trap(rain);
        System.out.println(count); // 6
    }
}
