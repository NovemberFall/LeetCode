package BinarySearch._69_Sqrt_x;

class sqrt_x_tmp1 {
    public int mySqrt(int x) {
        int left = 0, right = x, ans = x;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if ((long) mid * mid <= x) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
}
